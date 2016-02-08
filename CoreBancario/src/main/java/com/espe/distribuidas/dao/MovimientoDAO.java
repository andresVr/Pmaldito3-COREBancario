/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.distribuidas.dao;

import com.espe.distribuidas.commons.dao.DefaultGenericDAOImple;
import com.espe.distribuidas.model.Movimiento;
import javax.ejb.Stateless;

/**
 *
 * @author Andres Vr
 */
@Stateless
public class MovimientoDAO extends DefaultGenericDAOImple<Movimiento, String>  {
         public MovimientoDAO() {
        super(Movimiento.class);
    }
    
}
