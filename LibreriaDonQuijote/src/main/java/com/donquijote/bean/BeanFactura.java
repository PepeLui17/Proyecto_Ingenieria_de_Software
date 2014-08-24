/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.FacturaImplBO;
import com.donquijote.bo.LibroImplBO;
import com.donquijote.bo.UsuarioImplBO;
import com.donquijote.imprimir.ImprimirDetalleFactura;
import com.donquijote.imprimir.ImprimirFactura;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Luis
 */
public class BeanFactura {

    private String cedulaIngresada;
    private BeanCliente beanCliente;
    private double totalFactura;

    private FacturaImplBO facturaBO;
    private LibroImplBO libroBO;
    private UsuarioImplBO usuarioBO;

    private List<BeanLibro> listLibros;
    private BeanLibro selectedLibro;

    ///////
    private List<BeanDetalleFactura> listaDetallesFactura;
    private BeanDetalleFactura selectedDetalleFactura;
    private BeanUsuario beanUsuario;
    private int cantidadProductos;
    private int posDetail;

    private ImprimirFactura impFactura; 
    
    private int idFactura;
    private String numeroFactura;
    private double IVA;
    private Date fechaCompra;
    private boolean estadoBorrado;
    
    //////    
    public BeanFactura() {
        listLibros = new ArrayList<BeanLibro>();
        listaDetallesFactura = new ArrayList<BeanDetalleFactura>();
        posDetail = 0;
    }

    public String getCedulaIngresada() {
        return cedulaIngresada;
    }

    public void setCedulaIngresada(String cedulaIngresada) {
        this.cedulaIngresada = cedulaIngresada;
    }

    public BeanCliente getBeanCliente() {
        return beanCliente;
    }

    public void setBeanCliente(BeanCliente beanCliente) {
        this.beanCliente = beanCliente;
    }

    public FacturaImplBO getFacturaBO() {
        return facturaBO;
    }

    public void setFacturaBO(FacturaImplBO facturaBO) {
        this.facturaBO = facturaBO;
    }

    public LibroImplBO getLibroBO() {
        return libroBO;
    }

    public void setLibroBO(LibroImplBO libroBO) {
        this.libroBO = libroBO;
    }

    public List<BeanLibro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<BeanLibro> listLibros) {
        this.listLibros = listLibros;
    }

    public BeanLibro getSelectedLibro() {
        return selectedLibro;
    }

    public void setSelectedLibro(BeanLibro selectedLibro) {
        this.selectedLibro = selectedLibro;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public List<BeanDetalleFactura> getListaDetallesFactura() {
        return listaDetallesFactura;
    }

    public void setListaDetallesFactura(List<BeanDetalleFactura> listaDetallesFactura) {
        this.listaDetallesFactura = listaDetallesFactura;
    }

    public BeanDetalleFactura getSelectedDetalleFactura() {
        return selectedDetalleFactura;
    }

    public void setSelectedDetalleFactura(BeanDetalleFactura selectedDetalleFactura) {
        this.selectedDetalleFactura = selectedDetalleFactura;
    }

    public int getPosDetail() {
        return posDetail;
    }

    public void setPosDetail(int posDetail) {
        this.posDetail = posDetail;
    }

    public UsuarioImplBO getUsuarioBO() {
        return usuarioBO;
    }

    public void setUsuarioBO(UsuarioImplBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isEstadoBorrado() {
        return estadoBorrado;
    }

    public void setEstadoBorrado(boolean estadoBorrado) {
        this.estadoBorrado = estadoBorrado;
    }

    public ImprimirFactura getImpFactura() {
        return impFactura;
    }

    public void setImpFactura(ImprimirFactura impFactura) {
        this.impFactura = impFactura;
    }

    public double getTotalFactura() {

        this.totalFactura = 0;

        for (BeanDetalleFactura detail : listaDetallesFactura) {
            this.totalFactura = this.totalFactura + detail.getCantidadProductos() * detail.getLibro().getPvp();
        }

        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String verificarCliente() {

        try {
            System.out.println("entro al try");
            beanCliente = facturaBO.buscarCliente(cedulaIngresada);
            System.out.println("siguiente linea try");
            if (beanCliente.getNombre() != null) {
                return "/vendedor/venta.xhtml";
            }
        } catch (Exception e) {
            String msg = "El cliente no existe";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }

        return "";
    }

    public String aniadirDetalleFactura() {
        if (beanCliente == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al iniciar facturación", "Ingrese primero cedula del cliente para iniciar facturación, dirijase a la pestaña 'Nueva Venta' ");
            FacesContext.getCurrentInstance().addMessage(null, message);
            selectedLibro = null;
        } else if (selectedLibro != null && libroEstaEnFactura(selectedLibro.getNombre())) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al ingresar libro", "El libro ya se encuentra en la factura");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (selectedLibro != null && cantidadProductos <= 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al ingresar cantidad", "Ingrese una cantidad valida");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (selectedLibro != null && cantidadProductos > selectedLibro.getStock()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al ingresar cantidad", "La cantidad ingresada supera el stock disponible");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (selectedLibro != null) {
            BeanDetalleFactura beanDetalle = new BeanDetalleFactura();
            beanDetalle.setCantidadProductos(cantidadProductos);
            beanDetalle.setLibro(selectedLibro);
            beanDetalle.setEstadoBorrado(false);

            beanDetalle.setPosicion(posDetail);

            posDetail++;
            listaDetallesFactura.add(beanDetalle);
            selectedLibro = null;
        }

        cantidadProductos = 0;

        return "";
    }

    public boolean libroEstaEnFactura(String nombreLibro) {

        for (BeanDetalleFactura bean : listaDetallesFactura) {
            if (bean.getLibro().getNombre().equals(nombreLibro)) {
                return true;
            }
        }

        return false;
    }

    //Método para obtener sugerencias de libros cada vez que se busque un 
    //libro para agregarlo a la facctura
    public List<BeanLibro> completeLibro(String query) {
        List<BeanLibro> suggestions = new ArrayList<BeanLibro>();
        listLibros = libroBO.getAll();

        for (BeanLibro libro : listLibros) {
            //if (libro.getNombre().startsWith(query)) {
            if (libro.getNombre().toLowerCase().contains(query)) {
                suggestions.add(libro);
            }
        }

        return suggestions;
    }

    public String deleteDetailFromList(ActionEvent actionEvent) {
        int index = 0;
        for (BeanDetalleFactura detalleF : listaDetallesFactura) {
            if (detalleF.getPosicion() == selectedDetalleFactura.getPosicion()) {
                listaDetallesFactura.remove(index);
                return "";
            }
            index++;
        }

        return "";
    }

    public String updateDetailFromList(ActionEvent actionEvent) {
        int index = 0;
        for (BeanDetalleFactura detalleF : listaDetallesFactura) {
            if (detalleF.getPosicion() == selectedDetalleFactura.getPosicion()) {
                if (selectedDetalleFactura.getCantidadACambiar() <= 0) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar cantidad", "Ingrese una cantidad valida");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                } else if (selectedDetalleFactura.getCantidadACambiar() > selectedDetalleFactura.getLibro().getStock()) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar cantidad", "La cantidad ingresada supera el stock disponible");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                } else {
                    System.out.println("" + index);
                    BeanDetalleFactura bean = listaDetallesFactura.get(index);
                    bean.setCantidadProductos(selectedDetalleFactura.getCantidadACambiar());
                }

            }
            index++;
        }

        return "";
    }

    public String saveFactura(String username) {
        if (beanCliente == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar factura", "Ingrese primero cedula del cliente para iniciar facturación, dirijase a la pestaña 'Nueva Venta' ");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (listaDetallesFactura.size() == 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar factura", "No ha ingresado productos a la factura");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {

            beanUsuario = usuarioBO.getUsuarioByUsername(username);
            facturaBO.saveFactura(this);

            this.llenarImpFactura();
            this.DesInicializar();
            return "/vendedor/imprimirFactura.xhtml";
        }

        return "";

    }

    public String imprimirProforma() {
        if (beanCliente == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar factura", "Ingrese primero cedula del cliente para iniciar facturación, dirijase a la pestaña 'Nueva Venta' ");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (listaDetallesFactura.size() == 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar factura", "No ha ingresado productos a la factura");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            this.llenarImpFactura();
            this.DesInicializar();
            return "/vendedor/imprimirFactura.xhtml";
        }
        return "";
    }

    public void llenarImpFactura() {
        impFactura = new ImprimirFactura();

        impFactura.setNumeroFactura(facturaBO.ultimoNumeroFactura());
        impFactura.setNombreCliente(beanCliente.getNombre() + " " + beanCliente.getApellido());
        impFactura.setCedula(beanCliente.getCedulaRuc());
        impFactura.setDireccion(beanCliente.getDireccion());
        Date fecha = new Date();
        impFactura.setFecha(fecha);
        impFactura.setTelefono(beanCliente.getTelefono());
        impFactura.setTotalFactura(totalFactura);

        List<ImprimirDetalleFactura> ListImpDetalles = new ArrayList<ImprimirDetalleFactura>();
        for (BeanDetalleFactura detallesFact : listaDetallesFactura) {
            ImprimirDetalleFactura impDetalle = new ImprimirDetalleFactura();

            impDetalle.setCantidad(detallesFact.getCantidadProductos());
            impDetalle.setNombreProducto(detallesFact.getLibro().getNombre());
            impDetalle.setPrecioUnitario(detallesFact.getLibro().getPvp());
            impDetalle.setValorTotal(detallesFact.getCantidadProductos() * detallesFact.getLibro().getPvp());

            ListImpDetalles.add(impDetalle);
        }

        impFactura.setListDetallesFactura(ListImpDetalles);

    }

    public void DesInicializar() {
        cedulaIngresada = "";
        beanCliente = null;
        totalFactura = 0;
        listLibros = new ArrayList<BeanLibro>();
        selectedLibro = null;
        listaDetallesFactura = new ArrayList<BeanDetalleFactura>();
        selectedDetalleFactura = null;
        cantidadProductos = 0;
        posDetail = 0;

    }

}
