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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class EmpleadoImplBO implements EmpleadoInterfaceBO {

    private EmpleadoImplDAO empleadoDAO;

    @Override
    public void insert(BeanEmpleado obj) {
        Users empleado = new Users();

        empleado.setNombre(obj.getNombres());
        empleado.setApellido(obj.getApellidos());
        empleado.setCedula(obj.getCedula());
        empleado.setFechanacimiento(obj.getFechaNacimiento());

        if (obj.getSexo() == 0) {
            empleado.setSexo(true);
        } else {
            empleado.setSexo(false);
        }

        empleado.setSalario(obj.getSalario());
        empleado.setUsername(obj.getUsername());
        empleado.setPassword(obj.getPassword());
        empleado.setEstadoborrado(false);
        empleado.setEnabled(true);

        empleadoDAO.insertEmpleado(empleado);

//        Authorities authority=new Authorities();
//        
//                
//        //Insertando datos a authority
//        authority.setAuthority("ROL_VENDEDOR");
//        authority.setUsers(empleado);
//        authority.setEstadoborrado(false);
//        
//        if(empleadoDAO.insertEmpleado(empleado))
//            empleadoDAO.insertAuthority(authority);
//        
////        empleadoDAO.insert(empleado);
////        empleadoDAO.insertAuthority(authority);
    }

    @Override
    public void delete(BeanEmpleado obj) {
        Users empleado = new Users();
        
        empleado.setIduser(obj.getIdEmpleado());
        empleado.setNombre(obj.getNombres());
        empleado.setApellido(obj.getApellidos());
        empleado.setCedula(obj.getCedula());
        empleado.setFechanacimiento(obj.getFechaNacimiento());

        if (obj.getSexo() == 0) {
            empleado.setSexo(true);
        } else {
            empleado.setSexo(false);
        }

        empleado.setSalario(obj.getSalario());
        empleado.setUsername(obj.getUsername());
        empleado.setPassword(obj.getPassword());
        empleado.setEstadoborrado(true);
        empleado.setEnabled(false);
        
        empleadoDAO.update(empleado);
    }

    @Override
    public void update(BeanEmpleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BeanEmpleado> getAll() {
        List<BeanEmpleado> lista = new ArrayList();
        for (Users obj : empleadoDAO.getAll()) {
            BeanEmpleado bean = new BeanEmpleado();

            bean.setIdEmpleado(obj.getIduser());
            bean.setNombres(obj.getNombre());
            bean.setApellidos(obj.getApellido());
            bean.setCedula(obj.getCedula());
            bean.setFechaNacimiento(obj.getFechanacimiento());

            if (obj.isSexo()) {
                bean.setSexo(0);
            } else {
                bean.setSexo(1);
            }

            bean.setSalario(obj.getSalario());
            bean.setUsername(obj.getUsername());
            bean.setPassword(obj.getPassword());
            bean.setEnabled(obj.isEnabled());
            bean.setEstadoBorrado(obj.isEstadoborrado());

            lista.add(bean);
        }
        return lista;
    }

    public EmpleadoImplDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoImplDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

}
