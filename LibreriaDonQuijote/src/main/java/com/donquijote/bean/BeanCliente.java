/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bean;

import com.donquijote.bo.ClienteImplBO;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marlon Calderon
 */
public class BeanCliente {  

     private int idcliente;
     private String nombre;
     private String apellido;
     private String cedulaRuc;
     private String ciudad;
     private String direccion;
     private String telefono;
     private boolean estadoborrado;
     
     private ClienteImplBO clienteBO;
     private List<BeanCliente> listaclientes;
     private BeanCliente selectedCliente;
     private List<BeanCliente> filteredListaCliente;

    public BeanCliente() {
        
    }
   
    public int getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCedulaRuc() {
        return this.cedulaRuc;
    }
    
    public void setCedulaRuc(String cedulaRuc) {
        this.cedulaRuc = cedulaRuc;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public boolean isEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    
    public void prueba(){
        System.out.println(this.getNombre());
    }

    public ClienteImplBO getClienteBO() {
        return clienteBO;
    }

    public void setClienteBO(ClienteImplBO clienteBO) {
        this.clienteBO = clienteBO;
    }

    public List<BeanCliente> getListaclientes() {
        listaclientes = clienteBO.getAll();
        return listaclientes;
    }

    public void setListaclientes(List<BeanCliente> listaclientes) {
        this.listaclientes=listaclientes;
    }

    public BeanCliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(BeanCliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public List<BeanCliente> getFilteredListaCliente() {
        return filteredListaCliente;
    }

    public void setFilteredListaCliente(List<BeanCliente> filteredListaCliente) {
        this.filteredListaCliente = filteredListaCliente;
    }    
    
    public String insert() {
        clienteBO.insert(this);
        
        String msg = "Cliente ingresado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);       
        
        return "";
    }
    
    
    public String delete(ActionEvent actionEvent) {
        
        clienteBO.delete(selectedCliente);

        String msg = "Cliente eliminado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        
        listaclientes=clienteBO.getAll();
        filteredListaCliente=listaclientes;

        return "";
    }
    
    public String update(ActionEvent actionEvent) {

        clienteBO.update(selectedCliente);

        String msg = "Cliente modificado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        return "";
    }

}
