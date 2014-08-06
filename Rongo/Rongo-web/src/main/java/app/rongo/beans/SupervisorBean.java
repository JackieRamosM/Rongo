/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.persistence.Supervisor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    private SupervisorFacadeLocal supervisorFacade ;
    private Supervisor supervisor;
   
    /**
     * Creates a new instance of SupervisorBean
     */
    public SupervisorBean() {
        
               
    }
    
    @PostConstruct
    public void init(){
        this.supervisor = new Supervisor();
    }
    
    public void setSupervisores(){
        //supervisor = new Supervisor(Integer.SIZE, getNombre(), getApellido(), getCedula(), getCorreo(), true);
        getSupervisor().setIdsupervisor(Integer.SIZE);
        getSupervisor().setActivo(true);
        getSupervisorFacade().create(supervisor);
    }

    public SupervisorFacadeLocal getSupervisorFacade() {
        return supervisorFacade;
    }

    public void setSupervisorFacade(SupervisorFacadeLocal supervisorFacade) {
        this.supervisorFacade = supervisorFacade;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
    
}
