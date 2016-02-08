/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.servicio;

import com.espe.distribuidas.commons.dao.facade.CuentaServicioRemote;
import com.espe.distribuidas.dao.CuentaDAO;
import com.espe.distribuidas.dao.MovimientoDAO;
import com.espe.distribuidas.model.Cliente;
import com.espe.distribuidas.model.Cuenta;
import com.espe.distribuidas.model.Movimiento;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Andres Vr
 */
@LocalBean
@Stateless
public class CuentaServicio implements CuentaServicioRemote{

    @EJB
    CuentaDAO cuentaDAO;

    @EJB
    MovimientoDAO movimientoDAO;

    @Override
    public Cliente obtenerCuentaClienteParte1(String cuenta) {
        Cuenta cuentatmp = new Cuenta(cuenta);
        return cuentaDAO.find(cuentatmp).get(0).getClienteCuenta();
    }

    @Override
    public Cuenta obtenerCuentaClienteParte2(String cuenta) {
        Cuenta cuentarmp = new Cuenta();
        return cuentaDAO.find(cuentarmp).get(0);
    }

    public BigDecimal calcularNuevoSaldo(Integer tipo, BigDecimal saldo, BigDecimal transaccion) {
        BigDecimal valor = null;
        if (tipo == 0) {
            valor = saldo.add(transaccion);
        } else {
            valor = saldo.subtract(transaccion);
        }
        return valor;
    }

    @Override
    public String Deposito(String numeroCuenta, String valorDeposito, String cedula, Date fecha) {

        Cuenta cuentatmp = obtenerCuentaClienteParte2(numeroCuenta);
        if (cuentatmp != null) {
            Movimiento movimientotmp = new Movimiento();
            movimientotmp.setFechaHora(fecha);
            movimientotmp.setIdCuenta(numeroCuenta);
            movimientotmp.setMonto(new BigDecimal(valorDeposito));
            movimientotmp.setMovimientoCuenta(cuentatmp);
            movimientotmp.setSaldo(calcularNuevoSaldo(0, cuentatmp.getSaldo(), new BigDecimal(valorDeposito)));
            movimientotmp.setTipoMovimiento("DP");
            return "00" + "_" + calcularNuevoSaldo(0, cuentatmp.getSaldo(), new BigDecimal(valorDeposito));
        } else {
            return "01";

        }
    }

    @Override
    public String Retiro(String numeroCuenta, String valorRetiro, String cedula, Date fecha) {

        Cuenta cuentatmp = obtenerCuentaClienteParte2(numeroCuenta);
        if (cuentatmp != null) {

            Movimiento movimientotmp = new Movimiento();
            movimientotmp.setFechaHora(fecha);
            movimientotmp.setIdCuenta(numeroCuenta);
            movimientotmp.setMonto(new BigDecimal(valorRetiro));
            movimientotmp.setMovimientoCuenta(cuentatmp);
            movimientotmp.setSaldo(calcularNuevoSaldo(1, cuentatmp.getSaldo(), new BigDecimal(valorRetiro)));
            movimientotmp.setTipoMovimiento("RP");
            return "00" + "_" + calcularNuevoSaldo(0, cuentatmp.getSaldo(), new BigDecimal(valorRetiro));
        } else {
            return "01";

        }

    }

}
