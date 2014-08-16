/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.FacturaImplBO;
import com.donquijote.bo.LibroImplBO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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

    private List<BeanLibro> listLibros;
    private BeanLibro selectedLibro;

    ///////
    private List<BeanDetalleFactura> listaDetallesFactura;
    private BeanDetalleFactura selectedDetalleFactura;
    //private BeanEmpleado userLogged;
    private int cantidadProductos;
    private int posDetail;
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

}
