/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.dao;

import com.donquijote.daointerface.UsuarioInterfaceDAO;
import com.donquijote.persistence.Rol;
import com.donquijote.persistence.Usuario;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author José Luis
 */
public class UsuarioImplDAO extends HibernateDaoSupport implements UsuarioInterfaceDAO {

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
        return (List<Usuario>) getHibernateTemplate().find("SELECT u FROM Usuario as u LEFT JOIN FETCH u.rol where u.estadoborrado=false and u.rol.nombrerol='vendedor'");
    }

    @Override
    public Usuario getUsuarioByUsername(String username) {
        
        List<Usuario> listUsuarios = (List<Usuario>) getHibernateTemplate().find("select u from Usuario as u LEFT JOIN FETCH u.rol where u.estadoborrado=false and u.username='" + username + "'");
        if (!listUsuarios.isEmpty()) {
            return listUsuarios.get(0);
        }

        return null;
    }

}
