/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.servicio;

import com.espe.distribuidas.dao.EmpleadoDAO;
import com.espe.distribuidas.model.Empleado;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Andres Vr
 */
@LocalBean
@Stateless
public class EmpleadoServicio {

    @EJB
    EmpleadoDAO empleadoDAO;

    public Boolean loginEmpleado(String usuario, String pass) {
        Empleado empleadotmp = new Empleado(usuario, pass);
        return empleadoDAO.find(empleadotmp).size() == 1;

    }

}
