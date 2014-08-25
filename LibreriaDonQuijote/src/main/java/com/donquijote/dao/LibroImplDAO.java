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
    public boolean insert(Libro obj) {
        try{
            getHibernateTemplate().save(obj);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void delete(Libro obj) {
        getHibernateTemplate().delete(obj);
    }

    @Override
    public boolean update(Libro obj) {
        try{
            getHibernateTemplate().merge(obj);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Libro> getAll() {
        return (List<Libro>) getHibernateTemplate().find("from Libro lib where lib.estadoborrado=false");
    }

    @Override
    public Libro findLibroById(int idLibro) {
        List<Libro> listLibros = (List<Libro>) getHibernateTemplate().find("from Libro lib where lib.estadoborrado=false and lib.idlibro=" + idLibro);

        if (!listLibros.isEmpty()) {
            return listLibros.get(0);
        }

        return null;
    }
    
}
