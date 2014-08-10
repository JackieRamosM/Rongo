/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;


import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Liliana
 */
@Named(value = "clasesActualesBean")
@SessionScoped
public class ClasesActualesBean implements Serializable {
 
    private final Session session= new Session();
    private List<String> materias = session.getMateriasuser(); ;
    
        
    

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }
    
       
    
}
