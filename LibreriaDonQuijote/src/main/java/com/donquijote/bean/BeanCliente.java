/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bean;

import com.donquijote.bo.ClienteImplBO;
import com.donquijote.dao.ClienteImplDAO;
import com.donquijote.persistence.Cliente;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.management.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
        if(this.esCedulaValida()&&this.formatearTelefono()){
            if(clienteBO.insert(this)){                
                this.DesInicializar();
                String msg = "Cliente ingresado correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                this.regresarFormato();
                String msg = "Datos incorrectos, el Cliente no se ha ingresado";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }            
        }else{
           if(!this.esCedulaValida()){
               String msg = "La cedula ingresada es inválida";
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
               FacesContext.getCurrentInstance().addMessage(null, message);
           }
           if(!this.formatearTelefono()){
               String msg = "El teléfono ingresado no tiene formato correcto";
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
               FacesContext.getCurrentInstance().addMessage(null, message);
           }
        }        
               
        
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
        selectedCliente.regresarFormato();
        if(selectedCliente.esCedulaValida()&&selectedCliente.formatearTelefono()){
            
            clienteBO.update(selectedCliente);
            String msg = "Cliente modificado correctamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
               
        }else{
            if(!selectedCliente.esCedulaValida()){
               String msg = "La cedula ingresada es inválida";
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
               FacesContext.getCurrentInstance().addMessage(null, message);
           }
           if(!selectedCliente.formatearTelefono()){
               String msg = "El teléfono ingresado no tiene formato correcto";
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
               FacesContext.getCurrentInstance().addMessage(null, message);
           }
        }
        
        return "";
    }
    
    public void DesInicializar(){
        this.nombre="";
        this.apellido="";
        this.cedulaRuc="";
        this.ciudad="";
        this.direccion="";
        this.telefono="";       
    }
    
    public void regresarFormato(){
        String pr1,pr2;       
        
        pr1=this.getTelefono().substring(0,2);
        pr2=this.getTelefono().substring(3,this.getTelefono().length());
        this.setTelefono(pr1+pr2);
    }
    
    public boolean formatearTelefono(){
        int i;
        String pr1,pr2;
        for(i=0;i<this.getTelefono().length();i++){            
            if(!Character.isDigit(this.getTelefono().charAt(i))){
                return false;
            }
        }
        if(this.getTelefono().length()<9||this.getTelefono().length()>10){
            return false;
        }
        
        pr1=this.getTelefono().substring(0,2);
        pr2=this.getTelefono().substring(2,this.getTelefono().length());
        
        if(this.esCedulaValida()){
            this.setTelefono(pr1+"-"+pr2);
        }
        
        
        return true;
    }
    
    /*Esta funcion para comprobar cedula la copie de http://www.coplec.org/files/Util.java @author Luis Antonio Burbano*/
    public boolean esCedulaValida() {
        int nProvincias=24;
        
        //verifica que tenga 10 dígitos y que contenga solo valores numéricos
        if (!((this.cedulaRuc.length() == 10) && this.cedulaRuc.matches("^[0-9]{10}$"))) {
            return false;
        }

        //verifica que los dos primeros dígitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
        int prov = Integer.parseInt(this.cedulaRuc.substring(0, 2));

        if (!((prov > 0) && (prov <= nProvincias))) {
            return false;
        }

        //verifica que el último dígito de la cédula sea válido
        int[] d = new int[10];

        //Asignamos el string a un array
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(this.cedulaRuc.charAt(i) + "");
        }

        int imp = 0;
        int par = 0;

        //sumamos los duplos de posición impar
        for (int i = 0; i < d.length; i += 2) {
            d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
            imp += d[i];
        }

        //sumamos los digitos de posición par
        for (int i = 1; i < (d.length - 1); i += 2) {
            par += d[i];
        }

        //Sumamos los dos resultados
        int suma = imp + par;
        
        //Restamos de la decena superior
        int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1) +
                "0") - suma;
        
        //Si es diez el décimo dígito es cero        
        d10 = (d10 == 10) ? 0 : d10;

        //si el décimo dígito calculado es igual al digitado la cédula es correcta
        return d10 == d[9];
    }
    
}
