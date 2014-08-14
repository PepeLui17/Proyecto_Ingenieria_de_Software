/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bean;

/**
 *
 * @author José Luis
 */
public class BeanDetalleFactura {
    
    private int idDetalleFactura;
    private BeanFactura factura;
    private BeanLibro libro;
    private int cantidadProductos;
    private boolean estadoBorrado;

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public BeanFactura getFactura() {
        return factura;
    }

    public void setFactura(BeanFactura factura) {
        this.factura = factura;
    }

    public BeanLibro getLibro() {
        return libro;
    }

    public void setLibro(BeanLibro libro) {
        this.libro = libro;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public boolean isEstadoBorrado() {
        return estadoBorrado;
    }

    public void setEstadoBorrado(boolean estadoBorrado) {
        this.estadoBorrado = estadoBorrado;
    }
    
    
    
}