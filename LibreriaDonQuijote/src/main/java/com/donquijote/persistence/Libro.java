package com.donquijote.persistence;
// Generated 16/08/2014 08:36:45 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Libro generated by hbm2java
 */
public class Libro  implements java.io.Serializable {


     private int idlibro;
     private String nombre;
     private String autor;
     private String codigoisbn;
     private double preciounitario;
     private double pvp;
     private String categoria;
     private String editorial;
     private int edicion;
     private int aniopublicacion;
     private int stock;
     private String descripcion;
     private boolean estadoborrado;
     private Set detalleFacturas = new HashSet(0);

    public Libro() {
    }

	
    public Libro(int idlibro, String nombre, String autor, String codigoisbn, double preciounitario, double pvp, String categoria, String editorial, int edicion, int aniopublicacion, int stock, String descripcion, boolean estadoborrado) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.autor = autor;
        this.codigoisbn = codigoisbn;
        this.preciounitario = preciounitario;
        this.pvp = pvp;
        this.categoria = categoria;
        this.editorial = editorial;
        this.edicion = edicion;
        this.aniopublicacion = aniopublicacion;
        this.stock = stock;
        this.descripcion = descripcion;
        this.estadoborrado = estadoborrado;
    }
    public Libro(int idlibro, String nombre, String autor, String codigoisbn, double preciounitario, double pvp, String categoria, String editorial, int edicion, int aniopublicacion, int stock, String descripcion, boolean estadoborrado, Set detalleFacturas) {
       this.idlibro = idlibro;
       this.nombre = nombre;
       this.autor = autor;
       this.codigoisbn = codigoisbn;
       this.preciounitario = preciounitario;
       this.pvp = pvp;
       this.categoria = categoria;
       this.editorial = editorial;
       this.edicion = edicion;
       this.aniopublicacion = aniopublicacion;
       this.stock = stock;
       this.descripcion = descripcion;
       this.estadoborrado = estadoborrado;
       this.detalleFacturas = detalleFacturas;
    }
   
    public int getIdlibro() {
        return this.idlibro;
    }
    
    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getCodigoisbn() {
        return this.codigoisbn;
    }
    
    public void setCodigoisbn(String codigoisbn) {
        this.codigoisbn = codigoisbn;
    }
    public double getPreciounitario() {
        return this.preciounitario;
    }
    
    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }
    public double getPvp() {
        return this.pvp;
    }
    
    public void setPvp(double pvp) {
        this.pvp = pvp;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getEditorial() {
        return this.editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public int getEdicion() {
        return this.edicion;
    }
    
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    public int getAniopublicacion() {
        return this.aniopublicacion;
    }
    
    public void setAniopublicacion(int aniopublicacion) {
        this.aniopublicacion = aniopublicacion;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    public Set getDetalleFacturas() {
        return this.detalleFacturas;
    }
    
    public void setDetalleFacturas(Set detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }




}


