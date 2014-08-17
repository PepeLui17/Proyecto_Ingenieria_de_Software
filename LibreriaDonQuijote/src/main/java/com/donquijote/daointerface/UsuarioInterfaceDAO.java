/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.daointerface;

import com.donquijote.persistence.Usuario;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface UsuarioInterfaceDAO {
    void insertEmpleado(Usuario obj);
    void delete(Usuario obj);
    void update(Usuario obj);
    List<Usuario> getAll();    
    Usuario getUsuarioByUsername(String username);
}
