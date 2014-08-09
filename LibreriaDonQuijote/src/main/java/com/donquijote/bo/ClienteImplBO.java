
/**
 *
 * @author Marlon Calderon
 */

package com.donquijote.bo;

import com.donquijote.bean.BeanCliente;
import com.donquijote.bointerface.ClienteInterfaceBO;
import com.donquijote.dao.ClienteImplDAO;
import com.donquijote.persistence.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteImplBO implements ClienteInterfaceBO{

    private ClienteImplDAO clienteDAO;
    
    @Override
    public void insert(BeanCliente obj) {
        Cliente cliente=new Cliente();
        cliente.setNombre(obj.getNombre());
        cliente.setApellido(obj.getApellido());
        cliente.setCedulaRuc(obj.getCedulaRuc());
        cliente.setCiudad(obj.getCiudad());
        cliente.setDireccion(obj.getDireccion());
        cliente.setTelefono(obj.getTelefono());
        cliente.setEstadoborrado(false);
        
        clienteDAO.insert(cliente);
    }

    @Override
    public void delete(BeanCliente obj) {
        Cliente cliente=new Cliente();
        cliente.setIdcliente(obj.getIdcliente());
        cliente.setNombre(obj.getNombre());
        cliente.setApellido(obj.getApellido());
        cliente.setCedulaRuc(obj.getCedulaRuc());
        cliente.setCiudad(obj.getCiudad());
        cliente.setDireccion(obj.getDireccion());
        cliente.setTelefono(obj.getTelefono());
        cliente.setEstadoborrado(true);
        
        clienteDAO.update(cliente);
    }

    @Override
    public void update(BeanCliente obj) {
        Cliente cliente=new Cliente();
        cliente.setIdcliente(obj.getIdcliente());
        cliente.setNombre(obj.getNombre());
        cliente.setApellido(obj.getApellido());
        cliente.setCedulaRuc(obj.getCedulaRuc());
        cliente.setCiudad(obj.getCiudad());
        cliente.setDireccion(obj.getDireccion());
        cliente.setTelefono(obj.getTelefono());
        cliente.setEstadoborrado(false);
        
        clienteDAO.update(cliente);
    }

    @Override
    public List<BeanCliente> getAll() {
        List<BeanCliente> lista=new ArrayList<BeanCliente>();
        for(Cliente obj: clienteDAO.getAll()){
            BeanCliente bean=new BeanCliente();
            bean.setIdcliente(obj.getIdcliente());
            bean.setNombre(obj.getNombre());
            bean.setApellido(obj.getApellido());
            bean.setCedulaRuc(obj.getCedulaRuc());
            bean.setCiudad(obj.getCiudad());
            bean.setDireccion(obj.getDireccion());
            bean.setTelefono(obj.getTelefono());
            bean.setEstadoborrado(false);
            
            lista.add(bean);
        }
        return lista;
    }
    
}
