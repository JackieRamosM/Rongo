/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.beans.Session;
import app.rongo.facade.AyudanteFacadeLocal;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Estudiante;
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
    AyudanteFacadeLocal ayudanteFacade;
    @EJB
    EstudianteFacadeLocal estudianteFacade;
    private final Session session = new Session();
    
    /**
     * Creates a new instance of AyudanteBean
     */
    public AyudanteBean() {
    }
    
    public String getAyudanteName(int id) {
        Ayudante a = ayudanteFacade.find(id);
        Estudiante e = estudianteFacade.find(a.getIdEstudiante().getIdUsuario());
        return session.nombreService(session.matriculaService(e.getUsuario()));
    }
    
    public String getAyudanteNombre(){
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
    
    public Estudiante getEstudiante() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("b"));
        Ayudante a = ayudanteFacade.find(id);
        return estudianteFacade.find(a.getIdEstudiante().getIdUsuario());
    }
    
    public String getEstudianteMateria(){
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("b"));
        Ayudante a = ayudanteFacade.find(id);
        return session.carreraService(session.matriculaService(a.getIdEstudiante().getUsuario()));
    }
}
