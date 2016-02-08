/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andres Vr
 */
@Entity
@Table(name = "MOVIMIENTO")
public class Movimiento implements Serializable {

    @Id
    @Column(name = "ID_MOVIMIENTO", nullable = false)
    private Integer idMovimiento;

    @Column(name = "ID_CUENTA", nullable = false)
    private String idCuenta;

    @Column(name = "TIPO_MOVIMIENTO", nullable = false)
    private String tipoMovimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_Y_HORA", nullable = false)
    private Date fechaHora;

    @Column(name = "MONTO", nullable = false)
    private BigDecimal monto;

    @Column(name = "SALDO", nullable = false)
    private BigDecimal saldo;

    @ManyToOne(optional = false)
    private Cuenta movimientoCuenta;

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cuenta getMovimientoCuenta() {
        return movimientoCuenta;
    }

    public void setMovimientoCuenta(Cuenta movimientoCuenta) {
        this.movimientoCuenta = movimientoCuenta;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idMovimiento);
        return hash;
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
        final Movimiento other = (Movimiento) obj;
        if (!Objects.equals(this.idMovimiento, other.idMovimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", idCuenta=" + idCuenta + ", tipoMovimiento=" + tipoMovimiento + ", fechaHora=" + fechaHora + ", monto=" + monto + ", saldo=" + saldo + '}';
    }

}
