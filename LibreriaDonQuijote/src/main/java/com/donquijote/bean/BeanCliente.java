/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bean;

import java.util.List;

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
     
     private List<BeanCliente> listaclientes;

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
}
