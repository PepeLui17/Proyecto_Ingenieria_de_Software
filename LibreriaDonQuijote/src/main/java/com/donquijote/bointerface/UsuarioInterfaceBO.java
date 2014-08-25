/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bointerface;

import com.donquijote.bean.BeanUsuario;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface UsuarioInterfaceBO {
    boolean insert(BeanUsuario obj);
    void delete(BeanUsuario obj);
    boolean update(BeanUsuario obj);
    List<BeanUsuario> getAll();
    BeanUsuario getUsuarioByUsername(String username);
}
