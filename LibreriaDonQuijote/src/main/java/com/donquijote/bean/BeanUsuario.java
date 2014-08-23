/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.UsuarioImplBO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Luis
 */
public class BeanUsuario {

    private int idEmpleado;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String rol;
    private Date fechaNacimiento;
    private int sexo;
    private double salario;
    private String username;
    private String password;
    private boolean estadoBorrado;
    private boolean enabled;

    private UsuarioImplBO usuarioBO;
    private List<BeanUsuario> listaEmpleados;
    private BeanUsuario selectedEmpleado;

    private List<BeanUsuario> filteredListaEmpleados;
    
    public BeanUsuario() {
        listaEmpleados = new ArrayList<BeanUsuario>();
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstadoBorrado() {
        return estadoBorrado;
    }

    public void setEstadoBorrado(boolean estadoBorrado) {
        this.estadoBorrado = estadoBorrado;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public BeanUsuario getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(BeanUsuario selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }

    public UsuarioImplBO getUsuarioBO() {
        return usuarioBO;
    }

    public void setUsuarioBO(UsuarioImplBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

    public List<BeanUsuario> getListaEmpleados() {
        listaEmpleados = usuarioBO.getAll();
        return listaEmpleados;
    }

    public void setListaEmpleados(List<BeanUsuario> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<BeanUsuario> getFilteredListaEmpleados() {
        return filteredListaEmpleados;
    }

    public void setFilteredListaEmpleados(List<BeanUsuario> filteredListaEmpleados) {
        this.filteredListaEmpleados = filteredListaEmpleados;
    }    
    
    public String insert() {
        usuarioBO.insert(this);
        
        DesInicializar();
        
        String msg = "Empleado ingresado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);       
        
        return "";
    }

    public String delete(ActionEvent actionEvent) {
        
        usuarioBO.delete(selectedEmpleado);

        String msg = "Empleado eliminado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        
        listaEmpleados=usuarioBO.getAll();
        filteredListaEmpleados=listaEmpleados;

        return "";
    }
    
    public String update(ActionEvent actionEvent) {

        usuarioBO.update(selectedEmpleado);

        String msg = "Empleado modificado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        return "";
    }
    
    public void DesInicializar() {
        this.apellidos = "";
        this.nombres = "";
        this.cedula = "";
        this.fechaNacimiento = null;
        this.rol = "";
        this.salario = 0;
        this.sexo = 0;
        this.username = "";
        this.password = "";
    }

}
