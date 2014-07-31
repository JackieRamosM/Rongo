/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.facade.ClaseFacade;
import app.rongo.persistence.Clase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Liliana
 */
@ManagedBean (name = "claseBean")
@Dependent
public class ClaseBean {
    @EJB
    ClaseFacade claseFacade = lookupClaseFacadeBean();
    private Clase clase;
    private List<Clase> clases;

    /**
     * Creates a new instance of ClaseBean
     */
    public ClaseBean() {
    }
    
    public List<Clase> getClases(){
        if((clases == null) || (clases.isEmpty())){            
            refresh();  
            System.out.println(clases+"=========================================");
        }
        return clases;
    }
    
    public void refresh(){
        getClaseFacade().getClases();
    }

    private ClaseFacade lookupClaseFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ClaseFacade) c.lookup("java:global/app.rongo_Rongo-ear_ear_1.0-SNAPSHOT/app.rongo_Rongo-ejb_ejb_1.0-SNAPSHOT/ClaseFacade!app.rongo.facade.ClaseFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public ClaseFacade getClaseFacade() {
        return claseFacade;
    }

    public void setClaseFacade(ClaseFacade claseFacade) {
        this.claseFacade = claseFacade;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

       
    
}
