/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bean;

import com.donquijote.bo.LibroImplBO;
import java.util.List;

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

    //private List<Libro> libros;
    //private Libro selectedLibro;
    
    public BeanLibro() {
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
        return libroBO.getAll();
        //return listaLibros;
    }

    public void setListaLibros(List<BeanLibro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    public String insert() {
        libroBO.insert(this);
        //alumnoBO.insert(this);
        //getAll();
        return "";
    }
    
    public String delete() {
        //alumnoBO.delete(this);
        //getAll();
        return "";
    }
    
    public String update() {
        //lumnoBO.update(this);
        getAll();
        return "";
    }
    
    //@PostConstruct
    public List<BeanLibro> getAll() {
        return libroBO.getAll();
        //setListaLibros(libroBO.getAll());
//        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        Map<String, Object> sessionMap = externalContext.getSessionMap();
//        BeanLogin bean = (BeanLogin)sessionMap.get("usuarioLogeado");
//        setLista(alumnoBO.getAllByFechas(bean));
    }
    
    
    
}
