/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.beans;

import app.rongo.Session;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.facade.PostulacionFacadeLocal;
import app.rongo.persistence.Ayudantiasofertadas;
import app.rongo.persistence.Estudiante;
import app.rongo.persistence.Postulacion;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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
    @EJB
    private PostulacionFacadeLocal postulacionFacade;

    private List<Estudiante> estudiantes;
    private Postulacion p = new Postulacion();
    private Estudiante estudiante = new Estudiante();
    private final Session session = new Session();
    private final String usuario = session.getUser();
    private List<String> materias = session.getMateriasuser();
    private String datos = session.getDatos();
    private String user;
    private String skype;
    private String intereses;
    private String twitter;
    private String nombre;
    private int idestudiante;
    private boolean admin;

    public void findEstudiante() {
        estudiantes = estudianteFacade.findAll();
        for (Estudiante e : estudiantes) {
            if (e.getUsuario().equals(usuario)) {
                estudiante = e;
                break;
            }
        }
        intereses = estudiante.getIntereses();
        skype = estudiante.getSkype();
        twitter = estudiante.getTwitter();
        user = estudiante.getUsuario();
    }

    public void init() {
        estudiante.setAdmin(false);
        estudiante.setIdUsuario(Integer.MIN_VALUE);
        estudiante.setIntereses("");
        estudiante.setTwitter("");
        estudiante.setUsuario("");
        estudiante.setSkype("");
        findEstudiante();
    }

    public void editarEstudiante() throws IOException {
        estudiante.setIntereses(intereses);
        estudiante.setTwitter(twitter);
        estudiante.setSkype(skype);
        estudianteFacade.edit(estudiante);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public String estudianteName(String user) {
        return session.nombreService(session.matriculaService(user));
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public String getDatos() {
        return datos;
    }

    public void initpostulacion() {
        p = new Postulacion();
        p.setArchivo("");
        p.setIdayudantiaofertada(new Ayudantiasofertadas());
        p.setIdestudiante(new Estudiante());
        p.setIdpostulacion(Integer.MAX_VALUE);
    }

    public void postularse(Ayudantiasofertadas ao) {
        try {
            findEstudiante();
            p.setIdpostulacion(Integer.SIZE);
            p.setArchivo("");
            p.setIdayudantiaofertada(ao);
            p.setIdestudiante(estudiante);

            postulacionFacade.create(p);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Postulacion getP() {
        return p;
    }

    public void setP(Postulacion p) {
        this.p = p;
    }

}
