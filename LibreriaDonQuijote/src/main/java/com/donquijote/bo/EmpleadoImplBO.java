/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bo;

import com.donquijote.bean.BeanEmpleado;
import com.donquijote.bointerface.EmpleadoInterfaceBO;
import com.donquijote.dao.EmpleadoImplDAO;
import com.donquijote.persistence.Users;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class EmpleadoImplBO implements EmpleadoInterfaceBO{
    
    private EmpleadoImplDAO empleadoDAO;

    @Override
    public void insert(BeanEmpleado obj) {
        Users empleado=new Users();
        
        empleado.setNombre(obj.getNombres());
        empleado.setApellido(obj.getApellidos());
        empleado.setCedula(obj.getCedula());
        empleado.setFechanacimiento(obj.getFechaNacimiento());
        
        if(obj.getSexo()==0)
            empleado.setSexo(true);
        else
            empleado.setSexo(false);
        
        empleado.setSalario(obj.getSalario());
        empleado.setUsername(obj.getUsername());
        empleado.setPassword(obj.getPassword());
        empleado.setEstadoborrado(false);
        empleado.setEnabled(true);
        
        empleadoDAO.insert(empleado);
    }

    @Override
    public void delete(BeanEmpleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BeanEmpleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BeanEmpleado> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EmpleadoImplDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoImplDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }
    
}
