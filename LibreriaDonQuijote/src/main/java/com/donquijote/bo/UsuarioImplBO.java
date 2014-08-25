/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bo;

import com.donquijote.bean.BeanUsuario;
import com.donquijote.bointerface.UsuarioInterfaceBO;
import com.donquijote.dao.UsuarioImplDAO;
import com.donquijote.persistence.Rol;
import com.donquijote.persistence.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class UsuarioImplBO implements UsuarioInterfaceBO {

    private UsuarioImplDAO usuarioDAO;

    @Override
    public boolean insert(BeanUsuario obj) {
        Usuario empleado = new Usuario();

        Rol rolEmpleado = new Rol();
        rolEmpleado.setIdrol(2);
        rolEmpleado.setNombrerol("vendedor");
        rolEmpleado.setEstadoborrado(false);

        empleado.setRol(rolEmpleado);
        empleado.setNombre(obj.getNombres());
        empleado.setApellido(obj.getApellidos());
        empleado.setCedula(obj.getCedula());
        empleado.setFechanacimiento(obj.getFechaNacimiento());

        if (obj.getSexo() == 0) {
            empleado.setSexo(false);
        } else {
            empleado.setSexo(true);
        }

        empleado.setSalario(obj.getSalario());
        empleado.setUsername(obj.getUsername());
        empleado.setPassword(obj.getPassword());
        empleado.setEstadoborrado(false);
        empleado.setEnabled(true);

        return usuarioDAO.insertEmpleado(empleado);
    }

    @Override
    public void delete(BeanUsuario obj) {
        Usuario empleado = new Usuario();

        Rol rolEmpleado = new Rol();
        rolEmpleado.setIdrol(2);
        rolEmpleado.setNombrerol("vendedor");
        rolEmpleado.setEstadoborrado(false);

        empleado.setRol(rolEmpleado);

        empleado.setIdusuario(obj.getIdEmpleado());
        empleado.setNombre(obj.getNombres());
        empleado.setApellido(obj.getApellidos());
        empleado.setCedula(obj.getCedula());
        empleado.setFechanacimiento(obj.getFechaNacimiento());

        if (obj.getSexo() == 0) {
            empleado.setSexo(false);
        } else {
            empleado.setSexo(true);
        }

        empleado.setSalario(obj.getSalario());
        empleado.setUsername(obj.getUsername());
        empleado.setPassword(obj.getPassword());
        empleado.setEstadoborrado(true);
        empleado.setEnabled(false);

        usuarioDAO.update(empleado);
    }

    @Override
    public boolean update(BeanUsuario obj) {
        Usuario empleado = new Usuario();

        Rol rolEmpleado = new Rol();
        rolEmpleado.setIdrol(2);
        rolEmpleado.setNombrerol("vendedor");
        rolEmpleado.setEstadoborrado(false);

        empleado.setRol(rolEmpleado);

        empleado.setIdusuario(obj.getIdEmpleado());
        empleado.setNombre(obj.getNombres());
        empleado.setApellido(obj.getApellidos());
        empleado.setCedula(obj.getCedula());
        empleado.setFechanacimiento(obj.getFechaNacimiento());

        if (obj.getSexo() == 0) {
            empleado.setSexo(false);
        } else {
            empleado.setSexo(true);
        }

        empleado.setSalario(obj.getSalario());
        empleado.setUsername(obj.getUsername());
        empleado.setPassword(obj.getPassword());
        empleado.setEstadoborrado(false);
        empleado.setEnabled(true);

        return usuarioDAO.update(empleado);
    }

    @Override
    public List<BeanUsuario> getAll() {
        List<BeanUsuario> lista = new ArrayList();
        for (Usuario obj : usuarioDAO.getAll()) {
            BeanUsuario bean = new BeanUsuario();

            bean.setIdEmpleado(obj.getIdusuario());
            bean.setNombres(obj.getNombre());
            bean.setApellidos(obj.getApellido());
            bean.setCedula(obj.getCedula());
            bean.setFechaNacimiento(obj.getFechanacimiento());

            if (obj.isSexo()) {
                bean.setSexo(1);
            } else {
                bean.setSexo(0);
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

    public UsuarioImplDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioImplDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public BeanUsuario getUsuarioByUsername(String username) {
        Usuario obj = usuarioDAO.getUsuarioByUsername(username);

        BeanUsuario bean = new BeanUsuario();
        bean.setIdEmpleado(obj.getIdusuario());
        bean.setNombres(obj.getNombre());
        bean.setApellidos(obj.getApellido());
        bean.setUsername(obj.getUsername());
        bean.setPassword(obj.getPassword());
        bean.setSalario(obj.getSalario());
        bean.setCedula(obj.getCedula());
        bean.setFechaNacimiento(obj.getFechanacimiento());

        if (obj.isSexo()) {
            bean.setSexo(1);
        } else {
            bean.setSexo(0);
        }
        
        bean.setEstadoBorrado(obj.isEstadoborrado());
        bean.setEnabled(obj.isEnabled());

        bean.setRol(obj.getRol().getNombrerol());

        return bean;
    }

}
