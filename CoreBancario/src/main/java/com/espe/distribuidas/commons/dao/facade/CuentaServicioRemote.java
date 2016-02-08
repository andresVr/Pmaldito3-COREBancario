/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.commons.dao.facade;

import com.espe.distribuidas.model.Cliente;
import com.espe.distribuidas.model.Cuenta;
import java.util.Date;

/**
 *
 * @author Andres Vr
 */
public interface CuentaServicioRemote {

    public String Deposito(String numeroCuenta, String valorDeposito, String cedula, Date fecha);

    public String Retiro(String numeroCuenta, String valorRetiro, String cedula, Date fecha);

    public Cuenta obtenerCuentaClienteParte2(String cuenta);

    public Cliente obtenerCuentaClienteParte1(String cuenta);
}
