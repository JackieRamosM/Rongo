/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.PostulacionFacadeLocal;
import app.rongo.persistence.Postulacion;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "postulanteBean")
@ViewScoped
public class PostulanteBean {
    @EJB
    private PostulacionFacadeLocal postulacionFacade;
    private List<Postulacion> postulaciones;

    /**
     * Creates a new instance of PostulanteBean
     */
    
    public void getPostulantes(){
        postulaciones = postulacionFacade.findAll();
    }

    public PostulacionFacadeLocal getPostulacionFacade() {
        return postulacionFacade;
    }

    public void setPostulacionFacade(PostulacionFacadeLocal postulacionFacade) {
        this.postulacionFacade = postulacionFacade;
    }

    public List<Postulacion> getPostulaciones() {
        return postulaciones;
    }

    public void setPostulaciones(List<Postulacion> postulaciones) {
        this.postulaciones = postulaciones;
    }

    
    
}
