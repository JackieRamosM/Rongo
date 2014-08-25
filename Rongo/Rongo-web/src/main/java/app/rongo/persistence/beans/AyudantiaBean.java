/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence.beans;
import app.rongo.facade.AyudanteFacadeLocal;
import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Ayudantia;
import java.io.Serializable;import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named(value = "ayudantiaBean")
@SessionScoped
public class AyudantiaBean implements Serializable {

    @EJB
    private AyudanteFacadeLocal ayudanteFacade;
    private Ayudante ayudante = new Ayudante();
    private List<Ayudante> ayudantes = new ArrayList();
    @EJB
    private AyudantiaFacadeLocal ayudantiaFacade;
    private Ayudantia ayudantia = new Ayudantia();
    private List<Ayudantia> ayudantias = new ArrayList();
    
    private String materia = "";
    
    public AyudantiaBean() {}
    
    public void getAyudantiasDisponibles(){
        ayudantias = ayudantiaFacade.findAll();
    }

    public boolean ayudantiaExiste(String ayudantia){
        boolean res = false;
        getAyudantiasDisponibles();
        for(Ayudantia a : ayudantias){
            if(ayudantia.toLowerCase().contains(a.getNombre().toLowerCase()))
                res = true;
        }
        return res;
    }
    
    public List<Ayudante> encontrarAyudantes(){
        String a = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ayudantia");
        setMateria(a);
        getAyudantiasDisponibles();
        Ayudantia ayu = null;
        for(Ayudantia ay : ayudantias){
            System.out.println(ay.getNombre());
            if(a.contains(ay.getNombre()))
                ayu = ay;
        }
        ayudantes = ayudanteFacade.findAll();
        System.out.println(ayudantes);
        Iterator<Ayudante> i = ayudantes.iterator();
        while (i.hasNext()) {
            try{
                if (i.next().getIdayudantia().getIdayudantia() != ayu.getIdayudantia()) {
                    i.remove();
                }
            }catch(Error e){}
        }
        return ayudantes;
    }

    public String getLinkMateria(){
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ayudantia");
    }

    public AyudanteFacadeLocal getAyudanteFacade() {
        return ayudanteFacade;
    }

    public void setAyudanteFacade(AyudanteFacadeLocal ayudanteFacade) {
        this.ayudanteFacade = ayudanteFacade;
    }

    public Ayudante getAyudante() {
        return ayudante;
    }

    public void setAyudante(Ayudante ayudante) {
        this.ayudante = ayudante;
    }

    public List<Ayudante> getAyudantes() {
        return ayudantes;
    }

    public void setAyudantes(List<Ayudante> ayudantes) {
        this.ayudantes = ayudantes;
    }

    public AyudantiaFacadeLocal getAyudantiaFacade() {
        return ayudantiaFacade;
    }

    public void setAyudantiaFacade(AyudantiaFacadeLocal ayudantiaFacade) {
        this.ayudantiaFacade = ayudantiaFacade;
    }

    public Ayudantia getAyudantia() {
        return ayudantia;
    }

    public void setAyudantia(Ayudantia ayudantia) {
        this.ayudantia = ayudantia;
    }

    public List<Ayudantia> getAyudantias() {
        return ayudantias;
    }

    public void setAyudantias(List<Ayudantia> ayudantias) {
        this.ayudantias = ayudantias;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
