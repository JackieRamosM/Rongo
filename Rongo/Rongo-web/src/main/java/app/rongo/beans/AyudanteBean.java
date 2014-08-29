/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.beans;

import app.rongo.Session;
import app.rongo.facade.AyudanteFacadeLocal;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Ayudantia;
import app.rongo.persistence.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named(value = "ayudanteBean")
@Dependent
public class AyudanteBean {

    @EJB
    private AyudanteFacadeLocal ayudanteFacade;
    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    private List<Estudiante> estudiantes;
    private final Session session = new Session();
    private final String usuario = session.getUser();
    private Estudiante estudiante;
    private List<Ayudante> ayudantes = new ArrayList<Ayudante>();
    private List<Ayudantia> ayudantiasdelayudante = new ArrayList<Ayudantia>();

    /**
     * Creates a new instance of AyudanteBean
     */
    public AyudanteBean() {
    }

    public void findEstudiante() {
        estudiantes = new ArrayList<Estudiante>();
        estudiantes = estudianteFacade.findAll();
        for (Estudiante e : estudiantes) {
            if (e.getUsuario().equals(usuario)) {
                estudiante = e;
                break;
            }
        }

    }

    public void obtenerAyudantiasDelAyudante() {
        findEstudiante();
        ayudantes = ayudanteFacade.findAll();
        for (Ayudante a : ayudantes) {
            if (a.getIdEstudiante().equals(estudiante)) {
                ayudantiasdelayudante.add(a.getIdayudantia());
                System.out.println("ayudantia=" + a.getIdayudantia().getNombre() + " cod="+session.codigoService(a.getIdayudantia().getNombre()));
                
            }
        }
    }
    
    public String obtenermateria(String cod){
        System.out.println("cod="+cod + "" +session.codigoService(cod));
        return session.codigoService(cod);
    }

    public String getAyudanteName(int id) {
        Ayudante a = ayudanteFacade.find(id);
        Estudiante e = estudianteFacade.find(a.getIdEstudiante().getIdUsuario());
        return session.nombreService(session.matriculaService(e.getUsuario()));
    }

    public String getAyudanteNombre() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("b"));
        Ayudante a = ayudanteFacade.find(id);
        Estudiante e = estudianteFacade.find(a.getIdEstudiante().getIdUsuario());
        return session.nombreService(session.matriculaService(e.getUsuario()));
    }

    public String getAyudanteUser(int id) {
        Ayudante a = ayudanteFacade.find(id);
        Estudiante e = estudianteFacade.find(a.getIdEstudiante().getIdUsuario());
        return e.getUsuario();
    }

    public int getIdAyudante() {
        return Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("b"));
    }

    public Estudiante getEstudiante() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("b"));
        Ayudante a = ayudanteFacade.find(id);
        return estudianteFacade.find(a.getIdEstudiante().getIdUsuario());
    }

    public String getEstudianteMateria() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("b"));
        Ayudante a = ayudanteFacade.find(id);
        return session.carreraService(session.matriculaService(a.getIdEstudiante().getUsuario()));
    }

    public List<Ayudantia> getAyudantiasdelayudante() {
        return ayudantiasdelayudante;
    }

    public void setAyudantiasdelayudante(List<Ayudantia> ayudantiasdelayudante) {
        this.ayudantiasdelayudante = ayudantiasdelayudante;
    }

    public Session getSession() {
        return session;
    }
}
