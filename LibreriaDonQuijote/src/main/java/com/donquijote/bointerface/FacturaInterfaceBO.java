/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bointerface;

import com.donquijote.bean.BeanCliente;
import com.donquijote.bean.BeanFactura;

/**
 *
 * @author José Luis
 */
public interface FacturaInterfaceBO{
    public void saveFactura(BeanFactura obj);
    BeanCliente buscarCliente(String cedula);
    public String ultimoNumeroFactura();
}
