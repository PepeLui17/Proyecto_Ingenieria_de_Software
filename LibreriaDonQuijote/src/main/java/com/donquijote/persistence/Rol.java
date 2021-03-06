package com.donquijote.persistence;
// Generated 16/08/2014 08:36:45 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private int idrol;
     private String nombrerol;
     private boolean estadoborrado;
     private Set usuarios = new HashSet(0);

    public Rol() {
    }

	
    public Rol(int idrol, String nombrerol, boolean estadoborrado) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
        this.estadoborrado = estadoborrado;
    }
    public Rol(int idrol, String nombrerol, boolean estadoborrado, Set usuarios) {
       this.idrol = idrol;
       this.nombrerol = nombrerol;
       this.estadoborrado = estadoborrado;
       this.usuarios = usuarios;
    }
   
    public int getIdrol() {
        return this.idrol;
    }
    
    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }
    public String getNombrerol() {
        return this.nombrerol;
    }
    
    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }
    public boolean isEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


