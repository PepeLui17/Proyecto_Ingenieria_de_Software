/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.FacturaImplBO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Luis
 */
public class BeanConsultaReporte {

    private Date fechaInicio, fechaFin;
    private double totalFactura;
    private List<BeanDetalleFactura> listDetallesFactura;

    private List<BeanFactura> listFacturas;
    private BeanFactura selectedFactura;
    private List<BeanFactura> filteredListFacturas;

    private FacturaImplBO facturaBO;

    public BeanConsultaReporte() {
        listFacturas = new ArrayList<BeanFactura>();
        listDetallesFactura = new ArrayList<BeanDetalleFactura>();
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTotalFactura() {
        totalFactura = 0;
        for (BeanDetalleFactura beanDetalle : listDetallesFactura) {
            totalFactura = totalFactura + beanDetalle.getCantidadProductos() * beanDetalle.getLibro().getPvp();
        }
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public List<BeanDetalleFactura> getListDetallesFactura() {
        if (selectedFactura != null) {
            listDetallesFactura = facturaBO.getDetallesByIdFactura(selectedFactura.getIdFactura());
        }
        return listDetallesFactura;
    }

    public void setListDetallesFactura(List<BeanDetalleFactura> listDetallesFactura) {
        this.listDetallesFactura = listDetallesFactura;
    }

    public List<BeanFactura> getListFacturas() {
        return listFacturas;
    }

    public void setListFacturas(List<BeanFactura> listFacturas) {
        this.listFacturas = listFacturas;
    }

    public List<BeanFactura> getFilteredListFacturas() {
        return filteredListFacturas;
    }

    public void setFilteredListFacturas(List<BeanFactura> filteredListFacturas) {
        this.filteredListFacturas = filteredListFacturas;
    }

    public FacturaImplBO getFacturaBO() {
        return facturaBO;
    }

    public void setFacturaBO(FacturaImplBO facturaBO) {
        this.facturaBO = facturaBO;
    }

    public String consultarReporte() {
        try {
            listFacturas = facturaBO.getFacturasByFecha(fechaInicio, fechaFin);
            if (listFacturas.size() == 0) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje de información", "No se encontraron ventas en la fechas seleccionadas");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de ingreso de datos", "Una de las fechas ingresadas no es valida");
            FacesContext.getCurrentInstance().addMessage(null, message);
            listFacturas = new ArrayList<BeanFactura>();
        }
        return "";
    }

    public BeanFactura getSelectedFactura() {
        return selectedFactura;
    }

    public void setSelectedFactura(BeanFactura selectedFactura) {
        this.selectedFactura = selectedFactura;
    }

}
