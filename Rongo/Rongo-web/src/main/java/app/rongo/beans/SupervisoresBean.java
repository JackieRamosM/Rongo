/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.persistence.Supervisor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "supervisoresBean")
@SessionScoped
public class SupervisoresBean implements Serializable {
    @EJB
    private SupervisorFacadeLocal supervisorFacade;
    private Supervisor supervisor = new Supervisor();
    private List<Supervisor> supervisores;

    /**
     * Creates a new instance of SupervisorBean
     */
    public SupervisoresBean() {
    }
    
    public void init(){
        supervisor.setActivo(true);
        supervisor.setApellido("");
        supervisor.setCedula("");
        supervisor.setNombre("");
        supervisor.setCorreo("");
        supervisor.setIdsupervisor(Integer.SIZE);
    }
    
    public void encontrarSupervisores(){
        supervisores = supervisorFacade.findAll();
    }
    
    public void setSupervisores(){
        supervisorFacade.create(supervisor);
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
    public List<Supervisor> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(List<Supervisor> supervisores) {
        this.supervisores = supervisores;
    }
}
