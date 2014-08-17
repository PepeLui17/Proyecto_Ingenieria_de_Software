/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.UsuarioImplBO;

/**
 *
 * @author José Luis
 */
public class BeanLogin {

    private UsuarioImplBO usuarioBO;

    public boolean esAdministrador(String username) {
        BeanUsuario user = usuarioBO.getUsuarioByUsername(username);
        return user.getRol().equals("administrador");
    }

    public UsuarioImplBO getUsuarioBO() {
        return usuarioBO;
    }

    public void setUsuarioBO(UsuarioImplBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

}
