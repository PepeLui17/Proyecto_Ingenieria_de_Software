/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bointerface;

import com.donquijote.bean.BeanCliente;
import java.util.List;

/**
 *
 * @author Marlon Calderon
 */
public interface ClienteInterfaceBO {
    public boolean insert(BeanCliente obj);
    public void delete(BeanCliente obj);
    public void update(BeanCliente obj);
    List<BeanCliente> getAll();
    
}
