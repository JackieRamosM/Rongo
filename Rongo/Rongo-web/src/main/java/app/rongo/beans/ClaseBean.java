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
        int index = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("c"));
        clases = clase.findAll();
        Iterator<Clase> i = clases.iterator();
        while (i.hasNext()) {
            try{
                if(!i.next().getIdayudantia().getIdayudantia().equals(idAyudantia)) i.remove();
            }catch(Error err){}
        }
        if(index < 0) {
            for(int k=index; k==0; k++) {
            }
        }
        else if(index > 0) {
            for(int k=index; k==0; k--) {
            }
        }
        else {
            Calendar cal = Calendar.getInstance();
        }
        return clases;
    }
    
    public String getWeek(){
        int index = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("c"));
        String week = "";
        if(index < 0) {
            Calendar cal = Calendar.getInstance(Locale.US);
            cal.set(Calendar.WEEK_OF_YEAR, 0);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            for(int k=index; k==0; k++) cal.add(Calendar.DAY_OF_MONTH, -7);
            week = "Semana del " + new SimpleDateFormat("d").format(cal.getTime()) + " al ";
            cal.set(Calendar.DAY_OF_WEEK, 6);
            week = week + new SimpleDateFormat("d").format(cal.getTime()) + " de " + new SimpleDateFormat("MMMM").format(cal.getTime()) + " de " + new SimpleDateFormat("YYYY").format(cal.getTime());
            
        }
        else if(index > 0) {
            for(int k=index; k==0; k--) {
            }
        }
        else {
            Calendar cal = Calendar.getInstance(Locale.US);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            week = "Semana del " + new SimpleDateFormat("d").format(cal.getTime()) + " al ";
            cal.set(Calendar.DAY_OF_WEEK, 6);
            week = week + new SimpleDateFormat("d").format(cal.getTime()) + " de " + new SimpleDateFormat("MMMM").format(cal.getTime()) + " de " + new SimpleDateFormat("YYYY").format(cal.getTime());
        }
        return week;
    }
    
    public int getIndex() {
        return Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("c"));
    }
    
    public List<Clase> getClases(){
        clases = clase.findAll();
        return clases;
    }
}
