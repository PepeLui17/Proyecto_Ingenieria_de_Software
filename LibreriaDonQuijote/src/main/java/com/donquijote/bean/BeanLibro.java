/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bean;

import com.donquijote.bo.LibroImplBO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author José Luis
 */
public class BeanLibro {

    private int idLibro;
    private String nombre;
    private String autor;
    private String codigoISBN;
    private double precioUnitario;
    private double pvp;
    private String categoria;
    private String Editorial;
    private int edicion;
    private int anio;
    private int stock;
    private String descripcion;
    private boolean estadoBorrado;

    private LibroImplBO libroBO;
    private List<BeanLibro> listaLibros;
    private BeanLibro selectedLibro;
    
    private List<BeanLibro> filteredListaLibros;

    public BeanLibro() {
        listaLibros = new ArrayList<BeanLibro>();
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstadoBorrado() {
        return estadoBorrado;
    }

    public void setEstadoBorrado(boolean estadoBorrado) {
        this.estadoBorrado = estadoBorrado;
    }

    public LibroImplBO getLibroBO() {
        return libroBO;
    }

    public void setLibroBO(LibroImplBO libroBO) {
        this.libroBO = libroBO;
    }

    public List<BeanLibro> getListaLibros() {
        listaLibros = libroBO.getAll();
        return listaLibros;
    }

    public void setListaLibros(List<BeanLibro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public BeanLibro getSelectedLibro() {
        return selectedLibro;
    }

    public void setSelectedLibro(BeanLibro selectedLibro) {
        this.selectedLibro = selectedLibro;
    }

    public List<BeanLibro> getFilteredListaLibros() {
        return filteredListaLibros;
    }

    public void setFilteredListaLibros(List<BeanLibro> filteredListaLibros) {
        this.filteredListaLibros = filteredListaLibros;
    }

        
    public String insert() {
        if(this.verificarLibroInsert()&&libroBO.insert(this)){
            DesInicializar();

            String msg = "Libro ingresado correctamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            String msg = "El libro no se puede ingresar, verifique que los datos sean correctos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        return "";
    }

    public String delete(ActionEvent actionEvent) {
        
        libroBO.delete(selectedLibro);

        String msg = "Libro eliminado correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        filteredListaLibros=libroBO.getAll();
        listaLibros=libroBO.getAll();

        return "";
    }

    public String update(ActionEvent actionEvent) {
        if(selectedLibro.verificarLibroInsert()&&libroBO.update(selectedLibro)){            
            String msg = "Libro modificado correctamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            String msg = "El libro no se puede modificar, verifique que los datos sean correctos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        return "";
    }
    
    public void DesInicializar(){
        this.nombre="";
        this.autor="";
        this.codigoISBN="";
        this.precioUnitario=0;
        this.pvp=0;
        this.categoria="";
        this.Editorial="";
        this.edicion=0;
        this.anio=0;
        this.stock=0;
        this.descripcion="";
    }

    public List<BeanLibro> getAll() {
        return libroBO.getAll();
    }
    
    public boolean verificarLibroInsert(){
        int longitudCodISBN=this.getCodigoISBN().length();
        int anioPublicacion=this.anio;
        boolean valorFinal=true;
        if(longitudCodISBN!=10 || this.precioUnitario >= this.pvp || this.edicion <= 0 || (anioPublicacion < 1000 || anioPublicacion > 3000) || this.stock < 0){
            valorFinal=false;
        }
        return valorFinal;
    }

}
