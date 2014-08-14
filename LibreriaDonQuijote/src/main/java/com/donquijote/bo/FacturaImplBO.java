/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bo;

import com.donquijote.bean.BeanCliente;
import com.donquijote.bean.BeanLibro;
import com.donquijote.bointerface.FacturaInterfaceBO;
import com.donquijote.dao.FacturaImplDAO;
import com.donquijote.persistence.Cliente;
import com.donquijote.persistence.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class FacturaImplBO implements FacturaInterfaceBO{
    private FacturaImplDAO facturaDAO;

    public FacturaImplDAO getFacturaDAO() {
        return facturaDAO;
    }

    public void setFacturaDAO(FacturaImplDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    @Override
    public BeanCliente buscarCliente(String cedula) {
        BeanCliente beanCliente=new BeanCliente();
        System.out.println("-----------------aaa");
        Cliente obj=facturaDAO.findClientByCedula(cedula);
        System.out.println("-----------------bbb");
        if(obj!=null){
            System.out.println("-----------------ccc");
            beanCliente.setIdcliente(obj.getIdcliente());
            beanCliente.setNombre(obj.getNombre());
            beanCliente.setApellido(obj.getApellido());
            beanCliente.setCedulaRuc(obj.getCedulaRuc());
            beanCliente.setCiudad(obj.getCiudad());
            beanCliente.setDireccion(obj.getDireccion());
            beanCliente.setTelefono(obj.getTelefono());
            beanCliente.setEstadoborrado(obj.isEstadoborrado());
        }
        System.out.println("-----------------ddd");
        return beanCliente;
        
    }    
}
