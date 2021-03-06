package com.donquijote.persistence;
// Generated 16/08/2014 08:36:45 PM by Hibernate Tools 3.6.0



/**
 * DetalleFactura generated by hbm2java
 */
public class DetalleFactura  implements java.io.Serializable {


     private int iddetalleFactura;
     private Factura factura;
     private Libro libro;
     private int cantidad;
     private boolean estadoborrado;

    public DetalleFactura() {
    }

    public DetalleFactura(int iddetalleFactura, Factura factura, Libro libro, int cantidad, boolean estadoborrado) {
       this.iddetalleFactura = iddetalleFactura;
       this.factura = factura;
       this.libro = libro;
       this.cantidad = cantidad;
       this.estadoborrado = estadoborrado;
    }
   
    public int getIddetalleFactura() {
        return this.iddetalleFactura;
    }
    
    public void setIddetalleFactura(int iddetalleFactura) {
        this.iddetalleFactura = iddetalleFactura;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Libro getLibro() {
        return this.libro;
    }
    
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public boolean isEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }




}


