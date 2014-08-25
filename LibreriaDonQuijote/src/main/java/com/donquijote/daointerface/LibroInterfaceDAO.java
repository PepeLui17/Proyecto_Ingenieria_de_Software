/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.daointerface;

import com.donquijote.persistence.Libro;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface LibroInterfaceDAO {
    boolean insert(Libro obj);
    void delete(Libro obj);
    boolean update(Libro obj);
    List<Libro> getAll();
    Libro findLibroById(int idLibro);
}
