/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.daointerface;

import com.donquijote.persistence.Cliente;
import com.donquijote.persistence.DetalleFactura;
import com.donquijote.persistence.Factura;
import java.util.Date;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface FacturaInterfaceDAO {
    void saveFactura(Factura obj);
    void saveDetalleFactura(DetalleFactura obj);
    Cliente findClientByCedula(String cedula);
    Factura obtainLastFactura();
    List<Factura> getFacturasByFecha(Date fechaInicio, Date fechaFin);
}
