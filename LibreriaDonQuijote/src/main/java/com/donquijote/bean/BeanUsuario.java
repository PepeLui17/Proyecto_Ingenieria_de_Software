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
        if(this.esCedulaValida()&&this.verificarEmpleado()){
            if(usuarioBO.insert(this)){
                DesInicializar();

                String msg = "Empleado ingresado correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                String msg = "No se puede ingresar al empleado, verifique los datos";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }else{
            String msg = "No se puede ingresar al empleado, verifique los datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
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

        if(selectedEmpleado.esCedulaValida()&&selectedEmpleado.verificarEmpleado()){
            if(usuarioBO.update(selectedEmpleado)){
                String msg = "Empleado modificado correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                String msg = "No se puede modificar, revise los datos";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }else{
            String msg = "No se puede modificar, revise los datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
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
    public boolean verificarEmpleado(){
        boolean valorFinal=true;
        if (this.salario<0){
            valorFinal=false;
        }
        return valorFinal;
    }
    
    /*Esta funcion para comprobar cedula la copie de http://www.coplec.org/files/Util.java @author Luis Antonio Burbano*/
    public boolean esCedulaValida() {
        int nProvincias=24;
        
        //verifica que tenga 10 dígitos y que contenga solo valores numéricos
        if (!((this.cedula.length() == 10) && this.cedula.matches("^[0-9]{10}$"))) {
            return false;
        }

        //verifica que los dos primeros dígitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
        int prov = Integer.parseInt(this.cedula.substring(0, 2));

        if (!((prov > 0) && (prov <= nProvincias))) {
            return false;
        }

        //verifica que el último dígito de la cédula sea válido
        int[] d = new int[10];

        //Asignamos el string a un array
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(this.cedula.charAt(i) + "");
        }

        int imp = 0;
        int par = 0;

        //sumamos los duplos de posición impar
        for (int i = 0; i < d.length; i += 2) {
            d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
            imp += d[i];
        }

        //sumamos los digitos de posición par
        for (int i = 1; i < (d.length - 1); i += 2) {
            par += d[i];
        }

        //Sumamos los dos resultados
        int suma = imp + par;
        
        //Restamos de la decena superior
        int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1) +
                "0") - suma;
        
        //Si es diez el décimo dígito es cero        
        d10 = (d10 == 10) ? 0 : d10;

        //si el décimo dígito calculado es igual al digitado la cédula es correcta
        return d10 == d[9];
    }
    
}
