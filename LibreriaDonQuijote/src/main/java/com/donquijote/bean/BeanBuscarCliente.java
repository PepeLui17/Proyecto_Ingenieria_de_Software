/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.BuscarClienteBO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Luis
 */
public class BeanBuscarCliente {

    private String cedulaIngresada;
    private BeanCliente beanCliente;

    private BuscarClienteBO buscarClienteBO;

    public BeanBuscarCliente() {
    }

    public String getCedulaIngresada() {
        return cedulaIngresada;
    }

    public void setCedulaIngresada(String cedulaIngresada) {
        this.cedulaIngresada = cedulaIngresada;
    }

    public BeanCliente getBeanCliente() {
        return beanCliente;
    }

    public void setBeanCliente(BeanCliente beanCliente) {
        this.beanCliente = beanCliente;
    }

    public BuscarClienteBO getBuscarClienteBO() {
        return buscarClienteBO;
    }

    public void setBuscarClienteBO(BuscarClienteBO buscarClienteBO) {
        this.buscarClienteBO = buscarClienteBO;
    }

    
    public String verificarCliente() {

        try {
            System.out.println("entro al try");
            beanCliente = buscarClienteBO.buscarCliente(cedulaIngresada);
            System.out.println("siguiente linea try");
            if (beanCliente.getNombre() != null) {
                return "/vendedor/venta.xhtml";
            }
        } catch (Exception e) {
            String msg = "El cliente no existe";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }

        return "";
    }

}
