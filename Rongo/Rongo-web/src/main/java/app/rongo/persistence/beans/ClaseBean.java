/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.facade.ClaseFacadeLocal;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Ayudantia;
import app.rongo.persistence.Clase;
import app.rongo.persistence.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
    @EJB
    private AyudantiaFacadeLocal ayudantiaFacade;
    private Ayudantia ayudantia = new Ayudantia();
    private List<Ayudantia> ayudantias = new ArrayList();
    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    
    /**
     * Creates a new instance of ClaseBean
     */
    public ClaseBean() {
    }
    
    public List<Clase> getClasesAyudanteMateria(int idestudiante, String ayudantia){
        ayudantias = ayudantiaFacade.findAll();
        Ayudantia ayu = null;
        for(Ayudantia ay : ayudantias){
            System.out.println(ay.getNombre());
            if(ayudantia.contains(ay.getNombre()))
                ayu = ay;
        }
        ayu.getIdayudantia();
        Estudiante e = estudianteFacade.find(idestudiante);
        clases = clase.findAll();
        Iterator<Clase> i = clases.iterator();
        /*while (i.hasNext()) {
            try{
                if (!i.next().getIdayudantia().getIdayudantia().equals(ayu.getIdayudantia()))i.remove();
                if(!i.next().getIdayudante().getIdayudante().equals(idestudiante)) i.remove();
            }catch(Error err){}
        }*/
        return clases;
    }
    
    public List<Clase> getClases(){
        clases = clase.findAll();
        return clases;
    }
}
