/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.daointerface;

import com.donquijote.persistence.Cliente;
import java.util.List;

/**
 *
 * @author Marlon Calderon
 */
public interface ClienteInterfaceDAO {
    void insert(Cliente obj);
    void delete(Cliente obj);
    void update(Cliente obj);
    List<Cliente> getAll();
}
