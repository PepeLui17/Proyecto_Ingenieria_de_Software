/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.FacturaImplBO;
import com.donquijote.bo.LibroImplBO;
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

    private FacturaImplBO facturaBO;
    private LibroImplBO libroBO;
      
    private List<BeanLibro> listLibros;
    private BeanLibro selectedLibro;
    
    ///////
    //private List<BeanDetalleFactura> listaDetallesFactura;
    //private BeanEmpleado userLogged;
    //private int cantidadProductos;
    //////    
    
    public BeanFactura() {
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

    //Método para obtener sugerencias de libros cada vez que se busque un 
    //libro para agregarlo a la facctura
    public List<BeanLibro> completeLibro(String query){
        List<BeanLibro> suggestions = new ArrayList<BeanLibro>();
        listLibros=libroBO.getAll();
        
        for (BeanLibro libro : listLibros) {
            //if (libro.getNombre().startsWith(query)) {
            if (libro.getNombre().toLowerCase().contains(query)) {
                suggestions.add(libro);
            }
        }
        
        return suggestions;
        
    }
    
}
