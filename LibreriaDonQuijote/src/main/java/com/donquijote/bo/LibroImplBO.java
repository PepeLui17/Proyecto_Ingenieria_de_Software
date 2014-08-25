/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.bo;

import com.donquijote.bointerface.LibroInterfaceBO;
import com.donquijote.bean.BeanLibro;
import com.donquijote.dao.LibroImplDAO;
import com.donquijote.persistence.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Luis
 */
public class LibroImplBO implements LibroInterfaceBO {

    private LibroImplDAO libroDAO;

    @Override
    public boolean insert(BeanLibro obj) {
        Libro libro = new Libro();
        libro.setNombre(obj.getNombre());
        libro.setAutor(obj.getAutor());
        libro.setCodigoisbn(obj.getCodigoISBN());
        libro.setPreciounitario(obj.getPrecioUnitario());
        libro.setPvp(obj.getPvp());
        libro.setCategoria(obj.getCategoria());
        libro.setEditorial(obj.getEditorial());
        libro.setEdicion(obj.getEdicion());
        libro.setAniopublicacion(obj.getAnio());
        libro.setStock(obj.getStock());
        libro.setDescripcion(obj.getDescripcion());
        libro.setEstadoborrado(false);

        return libroDAO.insert(libro);

    }

    @Override
    public void delete(BeanLibro obj) {
        Libro libro = new Libro();
        libro.setIdlibro(obj.getIdLibro());
        libro.setNombre(obj.getNombre());
        libro.setAutor(obj.getAutor());
        libro.setCodigoisbn(obj.getCodigoISBN());
        libro.setPreciounitario(obj.getPrecioUnitario());
        libro.setPvp(obj.getPvp());
        libro.setCategoria(obj.getCategoria());
        libro.setEditorial(obj.getEditorial());
        libro.setEdicion(obj.getEdicion());
        libro.setAniopublicacion(obj.getAnio());
        libro.setStock(obj.getStock());
        libro.setDescripcion(obj.getDescripcion());
        libro.setEstadoborrado(true);

        libroDAO.update(libro);
    }

    @Override
    public boolean update(BeanLibro obj) {
        Libro libro = new Libro();
        libro.setIdlibro(obj.getIdLibro());
        libro.setNombre(obj.getNombre());
        libro.setAutor(obj.getAutor());
        libro.setCodigoisbn(obj.getCodigoISBN());
        libro.setPreciounitario(obj.getPrecioUnitario());
        libro.setPvp(obj.getPvp());
        libro.setCategoria(obj.getCategoria());
        libro.setEditorial(obj.getEditorial());
        libro.setEdicion(obj.getEdicion());
        libro.setAniopublicacion(obj.getAnio());
        libro.setStock(obj.getStock());
        libro.setDescripcion(obj.getDescripcion());
        libro.setEstadoborrado(false);

        return libroDAO.update(libro);
    }

    @Override
    public List<BeanLibro> getAll() {
        List<BeanLibro> lista = new ArrayList();
        for (Libro obj : libroDAO.getAll()) {
            BeanLibro bean = new BeanLibro();
            bean.setIdLibro(obj.getIdlibro());
            bean.setNombre(obj.getNombre());
            bean.setAutor(obj.getAutor());
            bean.setCodigoISBN(obj.getCodigoisbn());
            bean.setPrecioUnitario(obj.getPreciounitario());
            bean.setPvp(obj.getPvp());
            bean.setCategoria(obj.getCategoria());
            bean.setEditorial(obj.getEditorial());
            bean.setEdicion(obj.getEdicion());
            bean.setAnio(obj.getAniopublicacion());
            bean.setStock(obj.getStock());
            bean.setDescripcion(obj.getDescripcion());
            bean.setEstadoBorrado(obj.isEstadoborrado());

            lista.add(bean);
        }
        return lista;
    }

    public LibroImplDAO getLibroDAO() {
        return libroDAO;
    }

    public void setLibroDAO(LibroImplDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

}
