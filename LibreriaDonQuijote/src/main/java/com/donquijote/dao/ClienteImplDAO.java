/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.dao;

import com.donquijote.daointerface.ClienteInterfaceDAO;
import com.donquijote.persistence.Cliente;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Marlon Calderon
 */
public class ClienteImplDAO extends HibernateDaoSupport implements ClienteInterfaceDAO{

    @Override
    public void insert(Cliente obj) {
        getHibernateTemplate().save(obj);
    }

    @Override
    public void delete(Cliente obj) {
        getHibernateTemplate().delete(obj);
    }

    @Override
    public void update(Cliente obj) {
        getHibernateTemplate().update(obj);
    }

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>)(getHibernateTemplate().find("from Cliente cli where cli.estadoborrado=false"));
    }
    
}
