/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.ClaseFacadeLocal;
import app.rongo.persistence.Clase;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "claseBean")
@SessionScoped
public class ClaseBean implements Serializable {
    
    @EJB
    ClaseFacadeLocal clase;
    List<Clase> clases;
    
    /**
     * Creates a new instance of ClaseBean
     */
    public ClaseBean() {
    }
    
    public List<Clase> getClases(){
        clases = clase.findAll();
        return clases;
    }
}
