/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.Session;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named(value = "materiaBean")
@Dependent
public class MateriaBean {

    private final Session session = new Session();
    
    public MateriaBean() {}
    
    public String getMateriaNombre(String codigo) {
        return session.codigoService(codigo);
    }
}
