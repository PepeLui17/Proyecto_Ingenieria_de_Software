/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bo;

import com.donquijote.bean.BeanCliente;
import com.donquijote.bointerface.BuscarClienteInterfaceBO;
import com.donquijote.dao.BuscarClienteImplDAO;
import com.donquijote.persistence.Cliente;

/**
 *
 * @author José Luis
 */
public class BuscarClienteBO implements BuscarClienteInterfaceBO{
    private BuscarClienteImplDAO buscarClienteDAO;

//    @Override
//    public Users buscarCliente(String cedula) {
//        return buscarClienteDAO.findClientByCedula(cedula);
//    }

    public BuscarClienteImplDAO getBuscarClienteDAO() {
        return buscarClienteDAO;
    }

    public void setBuscarClienteDAO(BuscarClienteImplDAO buscarClienteDAO) {
        this.buscarClienteDAO = buscarClienteDAO;
    }    

    @Override
    public BeanCliente buscarCliente(String cedula) {
        BeanCliente beanCliente=new BeanCliente();
        System.out.println("-----------------aaa");
        Cliente obj=buscarClienteDAO.findClientByCedula(cedula);
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
