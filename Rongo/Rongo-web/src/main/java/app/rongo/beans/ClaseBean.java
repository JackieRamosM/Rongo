/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import app.rongo.facade.AyudanteFacadeLocal;
import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.facade.ClaseFacadeLocal;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Ayudantia;
import app.rongo.persistence.Clase;
import java.io.Serializable;
import java.util.Date;
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
    private AyudanteFacadeLocal ayudanteFacade;
    @EJB
    private AyudantiaFacadeLocal ayudantiaFacade;
    
    private Date fecha;
    private Date horaini;
    private Date horafin;
    private String descripcion;
    
    private Clase nuevaClase;
    
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
                if(!i.next().getIdayudante().getIdayudante().equals(idAyudante)) i.remove();
            }catch(Error err){}
        }        
        return clases;
    }
    
    public void insertarClase(int a1, int a2) {
        nuevaClase = new Clase();
        Ayudantia ayudantia = ayudantiaFacade.find(a1);
        Ayudante ayudante = ayudanteFacade.find(a2);
        
        if(ayudantia!=null && ayudante!=null) {
            nuevaClase.setIdclase(Integer.SIZE);
            if(!(horaini==null || horafin==null || fecha==null || descripcion==null)) {
                nuevaClase.setHoraini(horaini);
                nuevaClase.setHorafin(horafin);
                nuevaClase.setDescripcion(getDescripcion());
                nuevaClase.setIdayudantia(ayudantia);
                nuevaClase.setFecha(fecha);
                nuevaClase.setDioclase(true);
                nuevaClase.setIdayudante(ayudante);

                clase.create(nuevaClase);
            }
        }
    }
    
    public List<Clase> getClases(){
        clases = clase.findAll();
        return clases;
    }

    public ClaseFacadeLocal getClase() {
        return clase;
    }

    public void setClase(ClaseFacadeLocal clase) {
        this.clase = clase;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraini() {
        return horaini;
    }

    public void setHoraini(Date horaini) {
        this.horaini = horaini;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
