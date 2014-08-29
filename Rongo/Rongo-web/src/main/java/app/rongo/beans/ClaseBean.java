/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.facade.ClaseFacadeLocal;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Ayudantia;
import app.rongo.persistence.Clase;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "claseBean")
@RequestScoped
public class ClaseBean implements Serializable {
    
    @EJB
    ClaseFacadeLocal clase;
    List<Clase> clases;
    
    /**
     * Creates a new instance of ClaseBean
     */
    public ClaseBean() {
    }
    
    public List<Clase> getClasesAyudanteMateria(int idAyudante, int idAyudantia){
        clases = clase.findAll();
        Iterator<Clase> i = clases.iterator();
        while (i.hasNext()) {
            try{
                if(!i.next().getIdayudantia().getIdayudantia().equals(idAyudantia)) i.remove();
                if(!i.next().getIdayudante().equals(idAyudante)) i.remove();
            }catch(Error err){}
        }        
        return clases;
    }
    
    public List<Clase> getClases(){
        clases = clase.findAll();
        return clases;
    }
}
