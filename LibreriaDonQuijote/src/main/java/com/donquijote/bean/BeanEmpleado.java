/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.EmpleadoImplBO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Luis
 */
public class BeanEmpleado {

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

    private EmpleadoImplBO empleadoBO;
    private List<BeanEmpleado> listaEmpleados;
    private BeanEmpleado selectedEmpleado;

    private List<BeanEmpleado> filteredListaEmpleados;
    
    public BeanEmpleado() {
        listaEmpleados = new ArrayList<BeanEmpleado>();
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

    public BeanEmpleado getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(BeanEmpleado selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }

    public EmpleadoImplBO getEmpleadoBO() {
        return empleadoBO;
    }

    public void setEmpleadoBO(EmpleadoImplBO empleadoBO) {
        this.empleadoBO = empleadoBO;
    }

    public List<BeanEmpleado> getListaEmpleados() {
        listaEmpleados = empleadoBO.getAll();
        listaEmpleados.remove(0);
        return listaEmpleados;
    }

    public void setListaEmpleados(List<BeanEmpleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<BeanEmpleado> getFilteredListaEmpleados() {
        return filteredListaEmpleados;
    }

    public void setFilteredListaEmpleados(List<BeanEmpleado> filteredListaEmpleados) {
        this.filteredListaEmpleados = filteredListaEmpleados;
    }    
    
    public String insert() {
        empleadoBO.insert(this);
        
        DesInicializar();
        
        String msg = "Empleado ingresado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
                
        filteredListaEmpleados=empleadoBO.getAll();
        listaEmpleados=empleadoBO.getAll();
        
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
