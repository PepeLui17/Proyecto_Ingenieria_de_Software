/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.dao;

import com.donquijote.daointerface.LibroInterfaceDAO;
import com.donquijote.persistence.Libro;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author José Luis
 */
public class LibroImplDAO extends HibernateDaoSupport implements LibroInterfaceDAO{

    @Override
    public void insert(Libro obj) {
        getHibernateTemplate().save(obj);
    }

    @Override
    public void delete(Libro obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Libro obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Libro> getAll() {
        return (List<Libro>) getHibernateTemplate().find("from Libro lib where lib.estadoborrado=false");
    }
    
}
