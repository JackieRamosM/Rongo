/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.AyudantiasofertadasFacadeLocal;
import app.rongo.persistence.Ayudantiasofertadas;
import app.rongo.persistence.Supervisor;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "ayudantiasofertadasBean")
@SessionScoped
public class AyudantiasofertadasBean implements Serializable {
    @EJB
    private AyudantiasofertadasFacadeLocal ayudantiasofertadasFacade;   
    private Ayudantiasofertadas ayudantiaofertada = new Ayudantiasofertadas();
    private List<Ayudantiasofertadas> ayudantiasofertadas;
    

    /**
     * Creates a new instance of SupervisorBean
     */
    public AyudantiasofertadasBean() {
    }
    
    public void init(){
        ayudantiaofertada.setCargasemanal(0);
        ayudantiaofertada.setRequisitos("");
        ayudantiaofertada.setDescripcion("");
        ayudantiaofertada.setIdayudantiasofertadas(Integer.SIZE);
        ayudantiaofertada.setIdsupervisor(new Supervisor());
        ayudantiaofertada.setTipodeayudantia("");
        ayudantiaofertada.setVigentedesde(new Date());
        ayudantiaofertada.setVigentehasta(new Date());
    }
    
    public void encontrarAyudantiasofertadas(){
        ayudantiasofertadas = ayudantiasofertadasFacade.findAll();
    }
    public void setAyudantiasofertadas(Ayudantiasofertadas ao) throws IOException{
        ayudantiasofertadasFacade.create(ao);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ofertas.xhtml");
    }
    public void removerAyudantiaofertada(Ayudantiasofertadas ao) throws IOException{
        ayudantiasofertadasFacade.remove(ao);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ofertas.xhtml");
    }

    public AyudantiasofertadasFacadeLocal getAyudantiasofertadasFacade() {
        return ayudantiasofertadasFacade;
    }

    public void setAyudantiasofertadasFacade(AyudantiasofertadasFacadeLocal ayudantiasofertadasFacade) {
        this.ayudantiasofertadasFacade = ayudantiasofertadasFacade;
    }

    public Ayudantiasofertadas getAyudantiaofertada() {
        return ayudantiaofertada;
    }

    public void setAyudantiaofertada(Ayudantiasofertadas ayudantiaofertada) {
        this.ayudantiaofertada = ayudantiaofertada;
    }

    public List<Ayudantiasofertadas> getAyudantiasofertadas() {
        return ayudantiasofertadas;
    }

    public void setAyudantiasofertadas(List<Ayudantiasofertadas> ayudantiasofertadas) {
        this.ayudantiasofertadas = ayudantiasofertadas;
    }
    
}
