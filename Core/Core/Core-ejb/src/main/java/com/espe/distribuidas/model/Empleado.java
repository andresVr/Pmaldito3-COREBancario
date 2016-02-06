/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Andres Vr
 */
@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

    @Id
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idEmpleado;

    @Column(name = "NOMBRES", nullable = false)
    private String nombres;

    @Column(name = "CORREO_ELECTRONICO", nullable = false)
    private String correoElectronico;

    @Column(name = "NOMBRE_USUARIO", nullable = false)
    private String usuario;

    @Column(name = "CONTRASENIA", nullable = false)
    private String contrasena;

    public Empleado() {
    }

    public Empleado(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idEmpleado);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.idEmpleado, other.idEmpleado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombres=" + nombres + ", correoElectronico=" + correoElectronico + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }

    
}
