/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.daointerface;

import com.donquijote.persistence.Cliente;

/**
 *
 * @author José Luis
 */
public interface FacturaInterfaceDAO {
    Cliente findClientByCedula(String cedula);
}
