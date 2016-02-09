/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.servicio;

import com.espe.distribuidas.commons.dao.facade.ClienteServicioRemote;
import com.espe.distribuidas.dao.ClienteDAO;
import com.espe.distribuidas.model.Cliente;
import com.espe.distribuidas.model.Cuenta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Andres Vr
 */
@LocalBean
@Stateless
public class ClienteServicio implements ClienteServicioRemote{

    @EJB
    ClienteDAO clienteDAO;

    @Override
    public List<Cuenta> obterCuentasCliente(Cliente cliente) {
        Cliente clientetmp = cliente;
        return clienteDAO.find(clientetmp).get(0).getCuentaCliente();
    }
    
    @Override
    public Cliente obtenerClienteId(Cliente cliente){
        return clienteDAO.findById(cliente.getCedula(), true);
    
    }
    
    @Override
        public List<Cliente> obtenerTodosClientes(){
        return clienteDAO.findAll();
    
    }
        
        
}
