/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.persistence.Supervisor;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    public void setSupervisores() throws IOException{
        supervisorFacade.create(supervisor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("supervisores.xhtml");
    }
    public void removerSupervisor(Supervisor supervisor) throws IOException{
        supervisorFacade.remove(supervisor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("supervisores.xhtml");
    }    
    public void editarSupervisor(Supervisor supervisor) throws IOException{
        supervisorFacade.edit(supervisor);        
        FacesContext.getCurrentInstance().getExternalContext().redirect("supervisores.xhtml");
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