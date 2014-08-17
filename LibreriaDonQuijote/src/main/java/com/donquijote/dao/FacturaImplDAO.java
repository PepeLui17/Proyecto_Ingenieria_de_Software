/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.dao;

import com.donquijote.daointerface.FacturaInterfaceDAO;
import com.donquijote.persistence.Cliente;
import com.donquijote.persistence.Libro;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author José Luis
 */
public class FacturaImplDAO extends HibernateDaoSupport implements FacturaInterfaceDAO {

    @Override
    public Cliente findClientByCedula(String cedula) {
        System.out.println("-----------------");
        List<Cliente> listClientes = (List<Cliente>) getHibernateTemplate().find("from Cliente cli where cli.estadoborrado=false and cli.cedulaRuc='" + cedula+"'");
        System.out.println("-----------------");
        System.out.println("Cliente: " + listClientes.get(0).getNombre());
        if (!listClientes.isEmpty()) {
            return listClientes.get(0);
        }

        return null;
    }

}
