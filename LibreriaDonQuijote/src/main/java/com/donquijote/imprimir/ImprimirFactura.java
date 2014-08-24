/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.imprimir;

import java.util.Date;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class ImprimirFactura {
    
    private String numeroFactura;
    
    private String nombreCliente;
    private String cedula;
    private String direccion;
    private Date fecha;
    private String telefono;
    private List<ImprimirDetalleFactura> listDetallesFactura;    
    private double totalFactura;

    
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<ImprimirDetalleFactura> getListDetallesFactura() {
        return listDetallesFactura;
    }

    public void setListDetallesFactura(List<ImprimirDetalleFactura> listDetallesFactura) {
        this.listDetallesFactura = listDetallesFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }
}
