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
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Liliana
 */
@Named(value = "ayudantiasofertadasBean")
@ViewScoped
public class AyudantiasofertadasBean implements Serializable {
    @EJB
    private AyudantiasofertadasFacadeLocal ayudantiasofertadasFacade ;   
    private Ayudantiasofertadas ayudantiaofertada = new Ayudantiasofertadas();
    private List<Ayudantiasofertadas> ayudantiasofertadas;
       
    /**
     * Creates a new instance of SupervisorBean
     */
    public AyudantiasofertadasBean() {
        ayudantiaofertada = new Ayudantiasofertadas();
    }
    
    public void init(){
        ayudantiaofertada.setNombreayudanatia("");
        ayudantiaofertada.setCargasemanal(0);
        ayudantiaofertada.setOtrorequisito("");
        ayudantiaofertada.setPromediomayorcarrera(Boolean.TRUE);
        ayudantiaofertada.setEstudianteregular(Boolean.TRUE);
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
     
    public void ofertarAyudantia(Ayudantiasofertadas ao) throws IOException{
        Date desde = ao.getVigentedesde();
        Date hasta = ao.getVigentehasta();
        if((desde.compareTo(hasta) == 0) || (desde.compareTo(hasta)<0))
            ayudantiasofertadasFacade.create(ao);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ofertas.xhtml");
    }
   
    public void validarFecha(){
        Date d1 = ayudantiaofertada.getVigentedesde();
        Date d2 = ayudantiaofertada.getVigentehasta();
        if(d1.compareTo(d2)>0) RequestContext.getCurrentInstance().execute("alert('La fecha vigencia debe ser después o igual a la de inicio.')");
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
    
    public List<Ayudantiasofertadas> getAyudantiasofertadas2() {
        encontrarAyudantiasofertadas();
        return ayudantiasofertadas;
    }
}
