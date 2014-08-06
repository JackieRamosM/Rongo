/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.persistence.Supervisor;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "supervisorBean")
@SessionScoped
public class SupervisorBean implements Serializable {
    @EJB
    private SupervisorFacadeLocal supervisorFacade;
    private Supervisor supervisor;
    
    

    /**
     * Creates a new instance of SupervisorBean
     */
    public SupervisorBean() {
    }
    
    public void setSupervisores(){
        supervisor = new Supervisor(new Integer("10"), "Liliana", "Ramos", 921886743, "lramos", true);
        /*supervisor.setIdsupervisor(new Integer(10));
        supervisor.setNombre("Liliana");
        supervisor.setApellido("Ramos");
        supervisor.setCedula(new Integer(921886743));
        supervisor.setCorreo("lramos");
        //supervisor.setIdcuestionario(null);*/
       // supervisor.setActivo(true);
        
        //supervisor.setAyudantiaList(null);
        
        supervisorFacade.create(supervisor);
    }
}
