/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.dao;

import com.donquijote.daointerface.EmpleadoInterfaceDAO;
import com.donquijote.persistence.Usuario;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author José Luis
 */
public class EmpleadoImplDAO extends HibernateDaoSupport implements EmpleadoInterfaceDAO{

    @Override
    public void insertEmpleado(Usuario obj) {
        getHibernateTemplate().save(obj);
    }

    @Override
    public void delete(Usuario obj) {
        getHibernateTemplate().delete(obj);
    }

    @Override
    public void update(Usuario obj) {
        getHibernateTemplate().merge(obj);
    }

    @Override
    public List<Usuario> getAll() {
        //return (List<Users>) getHibernateTemplate().find("us from Users us, Authorities au where us.username=au.username and au.authority='ROL_VENDEDOR' and us.estadoborrado=false");
        return (List<Usuario>) getHibernateTemplate().find("from Usuario us where us.estadoborrado=false");
    }
    
    
}
