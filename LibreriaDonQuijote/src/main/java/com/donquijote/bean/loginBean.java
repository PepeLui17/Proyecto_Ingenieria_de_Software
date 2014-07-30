/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author José Luis
 */
@ManagedBean
@SessionScoped
public class loginBean {

    private String admin;
    private String vendedor;
      
    
    public boolean esAdministrador(String usuario)
    {
        if (usuario.equals("admin")) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    public boolean esVendedor(String usuario){
        if (usuario.equals("jlmj")) {
            return true;
        } else {
        return false;}
    }
}
