/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Andres Vr
 */
@Entity
@Table(name = "CUENTA")
public class Cuenta implements Serializable {

    @Id
    @Column(name = "ID_CUENTA", nullable = false)
    private String numeroCuenta;

    @Column(name = "ID_CLIENTE", nullable = false)
    private String codigoCliente;

    @Column(name = "SALDO", nullable = false)
    private BigDecimal saldo;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @ManyToOne(optional = false)
    private Cliente clienteCuenta;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movimientoCuenta")
    List<Movimiento> movimientoCuenta;

    public Cuenta() {
    }

    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(Cliente clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
    }

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.numeroCuenta);
        return hash;
    }

    public List<Movimiento> getMovimientoCuenta() {
        return movimientoCuenta;
    }

    public void setMovimientoCuenta(List<Movimiento> movimientoCuenta) {
        this.movimientoCuenta = movimientoCuenta;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.numeroCuenta, other.numeroCuenta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", codigoCliente=" + codigoCliente + ", saldo=" + saldo + ", tipo=" + tipo + '}';
    }

}
