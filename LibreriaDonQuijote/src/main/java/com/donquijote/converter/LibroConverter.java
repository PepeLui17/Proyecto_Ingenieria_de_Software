/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.converter;

import com.donquijote.bean.BeanLibro;
import com.donquijote.bo.LibroImplBO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author José Luis
 */
public class LibroConverter implements Converter {

    private LibroImplBO libroBO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        List<BeanLibro> listLibros = libroBO.getAll();

        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            for (BeanLibro libro : listLibros) {
                if (libro.getCodigoISBN().equals(submittedValue)) {
                    return libro;
                }
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No es un libro valido");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return ((BeanLibro) value).getCodigoISBN();
        }
    }

    public LibroImplBO getLibroBO() {
        return libroBO;
    }

    public void setLibroBO(LibroImplBO libroBO) {
        this.libroBO = libroBO;
    }

}
