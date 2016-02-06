/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.commons.dao.facade;

import com.espe.distribuidas.model.Cliente;
import com.espe.distribuidas.model.Cuenta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Andres Vr
 */
@Remote
public interface ClienteServicioRemote {

    public List<Cuenta> obterCuentasCliente(Cliente cliente);

    public Cliente obtenerClienteId(Cliente cliente);

    public List<Cliente> obtenerTodosClientes();

}
