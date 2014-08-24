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
        Usuario user = usuarioDAO.getUsuarioByUsername(obj.getUserLogged().getUsername());
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
}
