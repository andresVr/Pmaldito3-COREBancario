/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.commons.dao.facade;

import javax.ejb.Remote;

/**
 *
 * @author Andres Vr
 */
@Remote
public interface EmpleadoServicio {
    public Boolean loginEmpleado(String usuario, String pass) ;
    
}
