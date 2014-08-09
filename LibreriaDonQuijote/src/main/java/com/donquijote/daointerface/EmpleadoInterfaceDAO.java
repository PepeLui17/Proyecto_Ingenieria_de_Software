/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.daointerface;

import com.donquijote.persistence.Authorities;
import com.donquijote.persistence.Users;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface EmpleadoInterfaceDAO {
    void insertEmpleado(Users obj);
    void insertAuthority(Authorities obj);
    void delete(Users obj);
    void update(Users obj);
    List<Users> getAll();    
}
