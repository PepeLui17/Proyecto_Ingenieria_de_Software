/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.donquijote.bean.BeanCliente;
import com.donquijote.bo.ClienteImplBO;
/**
 *
 * @author Marlon Calderon
 */
public class ClienteTest {
    
    private BeanCliente cb;
    
    public ClienteTest() {
        cb=new BeanCliente();
        cb.setNombre("Name");
        cb.setApellido("LastName");
        cb.setCedulaRuc("");
        cb.setCiudad("Guayaquil");
        cb.setDireccion("Sauces 8");
        cb.setTelefono("0984287897");
        cb.setEstadoborrado(false);
    }
        
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         System.out.println("Hello World!");
     }
     
     @Test
     public void validaCedula(){ //Cedula esta correcta
         cb.setCedulaRuc("0925317638");
         assertEquals(true, cb.esCedulaValida());
     }
     
     @Test
     public void validaTelefono(){ //Celular
         cb.setTelefono("0984287897");
         //System.out.println("P1 "+cb.getTelefono()+cb.getTelefono().length());
         assertEquals(true, cb.formatearTelefono());
         System.out.println(cb.getTelefono());
     }
     
     @Test
     public void validaTelefono2(){ //Convencional
         cb.setTelefono("042243962");
         //System.out.println("P2 "+cb.getTelefono()+cb.getTelefono().length());
         assertEquals(true, cb.formatearTelefono());
         System.out.println(cb.getTelefono());
     }     
}
