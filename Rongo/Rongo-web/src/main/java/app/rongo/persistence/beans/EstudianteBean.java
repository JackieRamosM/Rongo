/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence.beans;

import app.rongo.beans.Session;
import app.rongo.facade.EstudianteFacade;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Estudiante;
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
@Named(value = "estudianteBean")
@SessionScoped
public class EstudianteBean implements Serializable {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    private List<Estudiante> estudiantes;
    private Estudiante estudiante = new Estudiante();
    private final Session session = new Session();
    private final String usuario = session.getUser();
    private List<String> materias = session.getMateriasuser();
    private String datos = session.getDatos();
    private String user;
    private String skype;
    private String intereses;
    private String twitter;
    private boolean admin;

    public EstudianteBean() {
    }
    
    public void findEstudiante(){
        estudiantes = estudianteFacade.findAll();
        for (Estudiante e : estudiantes) {
            if (e.getUsuario().equals(usuario)) {
                estudiante = e;
                break;
            }
        }
        intereses = estudiante.getIntereses();
        //admin = estudiante.getAdmin();
        skype = estudiante.getSkype();
        twitter = estudiante.getTwitter();
        user = estudiante.getUsuario();
    }
    
    public void init(){
        estudiante.setAdmin(false);
        estudiante.setIdUsuario(Integer.MIN_VALUE);
        estudiante.setIntereses("");
        estudiante.setTwitter("");
        estudiante.setUsuario("");
        estudiante.setSkype("");
        findEstudiante();
    }
    
    public void editarEstudiante() throws IOException{
        estudiante.setIntereses(intereses);
        estudiante.setTwitter(twitter);
        estudiante.setSkype(skype);
        estudianteFacade.edit(estudiante);        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    public EstudianteFacadeLocal getEstudianteFacade() {
        return estudianteFacade;
    }

    public void setEstudianteFacade(EstudianteFacadeLocal estudianteFacade) {
        this.estudianteFacade = estudianteFacade;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUser() {
        return user;
    }

    public String getDatos() {
        return datos;
    }
    
}
