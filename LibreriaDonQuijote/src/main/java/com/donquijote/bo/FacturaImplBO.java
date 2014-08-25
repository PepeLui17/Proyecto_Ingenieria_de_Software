/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bo;

import com.donquijote.bean.BeanCliente;
import com.donquijote.bean.BeanDetalleFactura;
import com.donquijote.bean.BeanFactura;
import com.donquijote.bean.BeanLibro;
import com.donquijote.bean.BeanUsuario;
import com.donquijote.bointerface.FacturaInterfaceBO;
import com.donquijote.dao.FacturaImplDAO;
import com.donquijote.dao.LibroImplDAO;
import com.donquijote.dao.UsuarioImplDAO;
import com.donquijote.persistence.Cliente;
import com.donquijote.persistence.DetalleFactura;
import com.donquijote.persistence.Factura;
import com.donquijote.persistence.Libro;
import com.donquijote.persistence.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class FacturaImplBO implements FacturaInterfaceBO {

    private FacturaImplDAO facturaDAO;
    private UsuarioImplDAO usuarioDAO;
    private LibroImplDAO libroDAO;

    public FacturaImplDAO getFacturaDAO() {
        return facturaDAO;
    }

    public void setFacturaDAO(FacturaImplDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    public UsuarioImplDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioImplDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public LibroImplDAO getLibroDAO() {
        return libroDAO;
    }

    public void setLibroDAO(LibroImplDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    @Override
    public BeanCliente buscarCliente(String cedula) {
        BeanCliente beanCliente = new BeanCliente();
        Cliente obj = facturaDAO.findClientByCedula(cedula);
        if (obj != null) {
            beanCliente.setIdcliente(obj.getIdcliente());
            beanCliente.setNombre(obj.getNombre());
            beanCliente.setApellido(obj.getApellido());
            beanCliente.setCedulaRuc(obj.getCedulaRuc());
            beanCliente.setCiudad(obj.getCiudad());
            beanCliente.setDireccion(obj.getDireccion());
            beanCliente.setTelefono(obj.getTelefono());
            beanCliente.setEstadoborrado(obj.isEstadoborrado());
        }
        return beanCliente;

    }

    @Override
    public void saveFactura(BeanFactura obj) {
        Usuario user = usuarioDAO.getUsuarioByUsername(obj.getBeanUsuario().getUsername());
        Cliente client = facturaDAO.findClientByCedula(obj.getBeanCliente().getCedulaRuc());

        Factura factura = new Factura();

        factura.setUsuario(user);
        factura.setCliente(client);

        int num = Integer.parseInt(facturaDAO.obtainLastFactura().getNumerofactura()) + 1;
        String numFact = Integer.toString(num);
        factura.setNumerofactura(numFact);

        factura.setIva(12);

        Date fecha = new Date();
        factura.setFechacompra(fecha);
        factura.setEstadoborrado(false);

        facturaDAO.saveFactura(factura);

        /////Guardaando los detalles de factura        
        List<BeanDetalleFactura> listDetallesFac = obj.getListaDetallesFactura();
        Factura ultimaFactura = facturaDAO.obtainLastFactura();

        for (BeanDetalleFactura bean : listDetallesFac) {
            DetalleFactura detalleF = new DetalleFactura();
            detalleF.setFactura(ultimaFactura);
            detalleF.setCantidad(bean.getCantidadProductos());

            int idLibro = bean.getLibro().getIdLibro();
            Libro libro = libroDAO.findLibroById(idLibro);
            detalleF.setLibro(libro);

            detalleF.setEstadoborrado(false);

            //Modificando stock del libro
            libro.setStock(libro.getStock() - bean.getCantidadProductos());
            libroDAO.update(libro);

            facturaDAO.saveDetalleFactura(detalleF);

        }

    }

    @Override
    public String ultimoNumeroFactura() {
        return facturaDAO.obtainLastFactura().getNumerofactura();
    }

    @Override
    public List<BeanFactura> getFacturasByFecha(Date fechaInicio, Date fechaFin) {
        List<BeanFactura> lista = new ArrayList<BeanFactura>();
        
        for(Factura obj: facturaDAO.getFacturasByFecha(fechaInicio, fechaFin)){
            BeanFactura bean=new BeanFactura();
            bean.setIdFactura(obj.getIdfactura());
            bean.setNumeroFactura(obj.getNumerofactura());
            bean.setIVA(obj.getIva());
            bean.setFechaCompra(obj.getFechacompra());
            bean.setEstadoBorrado(obj.isEstadoborrado());
            
            BeanUsuario bUsuario=new BeanUsuario();
            bUsuario.setNombres(obj.getUsuario().getNombre());
            bUsuario.setApellidos(obj.getUsuario().getApellido());
            
            
            BeanCliente bCliente = new BeanCliente();
            bCliente.setNombre(obj.getCliente().getNombre());
            bCliente.setApellido(obj.getCliente().getApellido());
            bCliente.setCedulaRuc(obj.getCliente().getCedulaRuc());
            
            bean.setBeanUsuario(bUsuario);
            bean.setBeanCliente(bCliente);
            
            lista.add(bean);                    
        }
        
        return lista;
    }

    @Override
    public List<BeanDetalleFactura> getDetallesByIdFactura(int idFactura) {
        List<BeanDetalleFactura> lista=new ArrayList<BeanDetalleFactura>();
        
        for(DetalleFactura obj: facturaDAO.getDetallesByIdFactura(idFactura)){
            BeanDetalleFactura bean = new BeanDetalleFactura();
            bean.setCantidadProductos(obj.getCantidad());
            
            BeanLibro bLibro= new BeanLibro();
            bLibro.setNombre(obj.getLibro().getNombre());
            bLibro.setPvp(obj.getLibro().getPvp());
            bLibro.setCodigoISBN(obj.getLibro().getCodigoisbn());
            
            bean.setLibro(bLibro);
            
            lista.add(bean);
            
        }
        
        return lista;
    }
}
