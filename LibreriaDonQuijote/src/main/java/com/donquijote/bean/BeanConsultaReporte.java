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

/**
 *
 * @author José Luis
 */
public class BeanConsultaReporte {

    private Date fechaInicio, fechaFin;

    private List<BeanDetalleFactura> listDetallesFactura;

    private List<BeanFactura> listFacturas;
    private BeanFactura selectedFactura;

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

    public List<BeanDetalleFactura> getListDetallesFactura() {
        if (selectedFactura !=null) {
            System.out.println("entroo: "+selectedFactura.getNumeroFactura());
            listDetallesFactura = facturaBO.getDetallesByIdFactura(selectedFactura.getIdFactura());
            System.out.println("tamaño: "+listDetallesFactura.size());
        }
        return listDetallesFactura;
    }

    public void setListDetallesFactura(List<BeanDetalleFactura> listDetallesFactura) {
        this.listDetallesFactura = listDetallesFactura;
    }

    public List<BeanFactura> getListFacturas() {
        //listFacturas = facturaBO.getFacturasByFecha(fechaInicio, fechaFin);
        return listFacturas;
    }

    public void setListFacturas(List<BeanFactura> listFacturas) {
        this.listFacturas = listFacturas;
    }

    public FacturaImplBO getFacturaBO() {
        return facturaBO;
    }

    public void setFacturaBO(FacturaImplBO facturaBO) {
        this.facturaBO = facturaBO;
    }

    public String consultarReporte() {
        listFacturas = facturaBO.getFacturasByFecha(fechaInicio, fechaFin);
        return "";
    }

    public BeanFactura getSelectedFactura() {
        return selectedFactura;
    }

    public void setSelectedFactura(BeanFactura selectedFactura) {
        this.selectedFactura = selectedFactura;
    }

    public List<BeanDetalleFactura> obtenerDetallesFactura() {
        List<BeanDetalleFactura> lista = new ArrayList<BeanDetalleFactura>();
        lista = facturaBO.getDetallesByIdFactura(selectedFactura.getIdFactura());

        return lista;
    }

    public String delete(ActionEvent actionEvent) {
        return "";
    }

}
