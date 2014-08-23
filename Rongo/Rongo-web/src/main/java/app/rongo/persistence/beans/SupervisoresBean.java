/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence.beans;

import app.rongo.beans.Postulante;
import app.rongo.beans.Session;
import app.rongo.facade.AyudanteFacadeLocal;
import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.facade.AyudantiasofertadasFacadeLocal;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.facade.PostulacionFacadeLocal;
import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Ayudantia;
import app.rongo.persistence.Ayudantiasofertadas;
import app.rongo.persistence.Estudiante;
import app.rongo.persistence.Postulacion;
import app.rongo.persistence.Supervisor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "supervisoresBean")
@ViewScoped
public class SupervisoresBean {
    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    private Estudiante estudiante = new Estudiante();
    @EJB
    private AyudanteFacadeLocal ayudanteFacade;
    private Ayudante ayudante = new Ayudante();
    private List<Ayudante> ayudantes = new ArrayList();
    @EJB
    private AyudantiaFacadeLocal ayudantiaFacade;
    private Ayudantia ayudantia = new Ayudantia();
    private List<Ayudantia> ayudantias = new ArrayList();
    @EJB
    private SupervisorFacadeLocal supervisorFacade;
    private Supervisor supervisor = new Supervisor();
    @EJB
    private AyudantiasofertadasFacadeLocal ayudantiasofertadasFacade;
    @EJB
    private PostulacionFacadeLocal postulacionFacade;
    private List<Postulacion> postulantes;
    

    private List<Postulacion> postulantesporsupervisor = new ArrayList();
    private List<Ayudantiasofertadas> ayudantiasofertadas;
    private List<Ayudantiasofertadas> ayudantiasofertadasporsupervisor = new ArrayList();
    private final Session session = new Session();
    private final String usuario = session.getUser();
    private List<Supervisor> supervisores;
    private List<Postulante> estc = new ArrayList();
    private PostulanteBean postulante = new PostulanteBean();

    public void init() {
        supervisor.setActivo(true);
        supervisor.setApellido("");
        supervisor.setCedula("");
        supervisor.setNombre("");
        supervisor.setCorreo("");
        supervisor.setIdsupervisor(Integer.SIZE);
    }

    public void supervisoresActivos() {
        Iterator<Supervisor> i = supervisores.iterator();
        while (i.hasNext()) {
            Supervisor s = i.next();
            if (s.getActivo() == false) {
                i.remove();
            }
        }
    }

    public void encontrarSupervisores() {
        supervisores = supervisorFacade.findAll();
        Collections.sort(supervisores, new Comparator<Supervisor>() {
            public int compare(Supervisor s1, Supervisor s2) {
                return s1.getApellido().compareTo(s2.getApellido());
            }
        });
    }

    public void setSupervisores() throws IOException {
        supervisorFacade.create(supervisor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("supervisores.xhtml");
    }

    public void removerSupervisor(Supervisor supervisor) throws IOException {
        supervisorFacade.remove(supervisor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("supervisores.xhtml");
    }

    public void editarSupervisor(Supervisor supervisor) throws IOException {
        supervisorFacade.edit(supervisor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("supervisores.xhtml");
    }

    public SupervisorFacadeLocal getSupervisorFacade() {
        return supervisorFacade;
    }

    public void setSupervisorFacade(SupervisorFacadeLocal supervisorFacade) {
        this.supervisorFacade = supervisorFacade;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public List<Supervisor> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(List<Supervisor> supervisores) {
        this.supervisores = supervisores;
    }

    public void obtenerSupervisorLogueado() {
        supervisores = new ArrayList();
        encontrarSupervisores();
        for (Supervisor s : supervisores) {
            String[] str = s.getCorreo().split("@");
            if (str[0].equals(usuario)) {
                setSupervisor(s);
                break;
            }
        }
    }

    public void obtenerAyudantiasOfertadasPorSupervisor() {
        obtenerSupervisorLogueado();
        ayudantiasofertadas = new ArrayList();
        ayudantiasofertadasporsupervisor = new ArrayList();
        try {
            ayudantiasofertadas = ayudantiasofertadasFacade.findAll();

            for (Ayudantiasofertadas ao : ayudantiasofertadas) {
                if (supervisor.getIdsupervisor() == ao.getIdsupervisor().getIdsupervisor()) {
                    getAyudantiasofertadasporsupervisor().add(ao);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void obtenerPostulatesPorSupervisor() {
        obtenerAyudantiasOfertadasPorSupervisor();
        postulantes = new ArrayList();
        postulantes = postulacionFacade.findAll();
        setPostulantesporsupervisor(new ArrayList());

        try {
            for (Postulacion p : getPostulantes()) {
                for (Ayudantiasofertadas ao : getAyudantiasofertadasporsupervisor()) {
                    if (ao.getIdayudantiasofertadas() == p.getIdayudantiaofertada().getIdayudantiasofertadas()) {
                        getPostulantesporsupervisor().add(p);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void datosEstudiante() {
        Session s = new Session();
        String mat = "";
        String cod = "";
        setPostulantesporsupervisor(new ArrayList());
        obtenerPostulatesPorSupervisor();
        estc = new ArrayList();
        for (Postulacion p : getPostulantesporsupervisor()) {
            Estudiante e = p.getIdestudiante();
            Postulante est = new Postulante();
            mat = s.matriculaService(e.getUsuario());
            est.setCarrera(s.carreraService(mat));
            est.setNombre(s.nombreService(mat));
            est.setPromediogeneral("" + s.promedioService(mat));
            est.setUsuario(e.getUsuario());
            est.setMatricula(mat);
            if (p.getIdayudantiaofertada().getTipodeayudantia().equals("academica")) {
                cod = s.codigoService(p.getIdayudantiaofertada().getNombreayudanatia());
                est.setAyudantiaaplicada(cod);
            } else {
                est.setAyudantiaaplicada(p.getIdayudantiaofertada().getNombreayudanatia());
            }
            if (s.estadoService(mat)) {
                est.setEstado("activo");
            } else {
                est.setEstado("inactivo");
            }
            estc.add(est);
        }
    }

    public void aceptarPostulante(Postulante e) {
        Ayudantiasofertadas a = new Ayudantiasofertadas();
        Ayudantia ayudantiaencontrada = new Ayudantia();
        Postulacion postula = new Postulacion();
        List<Estudiante> es = new ArrayList();
        Supervisor s;
        
        obtenerPostulatesPorSupervisor();
        s = getSupervisor();
        
        es = estudianteFacade.findAll();
        
        for(Estudiante b : es){
            if(b.getUsuario().equals(e.getUsuario()))
                estudiante = b;
        }
        
        
        
        for(Postulacion p: getPostulantesporsupervisor()){
            if(p.getIdestudiante().equals(estudiante)){
                a = p.getIdayudantiaofertada();
                postula = p;
            }
        }
        getAyudantia().setIdayudantia(Integer.SIZE);
        getAyudantia().setIdsupervisor(s);
        getAyudantia().setNombre(a.getNombreayudanatia());
        getAyudantia().setTipodeayudantia(a.getTipodeayudantia());
        ayudantiaFacade.create(getAyudantia());
        ayudantias = ayudantiaFacade.findAll();
        
        for(Ayudantia ay: ayudantias){
            if(ay.getIdsupervisor().equals(s) && ay.getNombre().equals(a.getNombreayudanatia())){
                ayudantiaencontrada = ay;
            }
        }
        getAyudante().setFechaayudante(new Date());
        getAyudante().setIdEstudiante(estudiante);
        getAyudante().setIdayudante(Integer.SIZE);
        getAyudante().setIdayudantia(ayudantiaencontrada);
        getAyudante().setObservacion("");
        ayudanteFacade.create(getAyudante());
        
        postulacionFacade.remove(postula);
        
    }

    public List<Ayudantiasofertadas> getAyudantiasofertadas() {
        return ayudantiasofertadas;
    }

    public void setAyudantiasofertadas(List<Ayudantiasofertadas> ayudantiasofertadas) {
        this.ayudantiasofertadas = ayudantiasofertadas;
    }

    public List<Ayudantiasofertadas> getAyudantiasofertadasporsupervisor() {
        return ayudantiasofertadasporsupervisor;
    }

    public void setAyudantiasofertadasporsupervisor(List<Ayudantiasofertadas> ayudantiasofertadasporsupervisor) {
        this.ayudantiasofertadasporsupervisor = ayudantiasofertadasporsupervisor;
    }

    public PostulanteBean getPostulante() {
        return postulante;
    }

    public void setPostulante(PostulanteBean postulante) {
        this.postulante = postulante;
    }

    public List<Postulacion> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(List<Postulacion> postulantes) {
        this.postulantes = postulantes;
    }

    public List<Postulacion> getPostulantesporsupervisor() {
        return postulantesporsupervisor;
    }

    public void setPostulantesporsupervisor(List<Postulacion> postulantesporsupervisor) {
        this.postulantesporsupervisor = postulantesporsupervisor;
    }

    public List<Postulante> getEstc() {
        return estc;
    }

    public void setEstc(List<Postulante> estc) {
        this.estc = estc;
    }

    public Ayudantia getAyudantia() {
        return ayudantia;
    }

    public void setAyudantia(Ayudantia ayudantia) {
        this.ayudantia = ayudantia;
    }

    public List<Ayudante> getAyudantes() {
        return ayudantes;
    }

    public void setAyudante(List<Ayudante> ayudante) {
        this.ayudantes = ayudante;
    }

    public Ayudante getAyudante() {
        return ayudante;
    }

    public void setAyudante(Ayudante ayudante) {
        this.ayudante = ayudante;
    }
    
}

