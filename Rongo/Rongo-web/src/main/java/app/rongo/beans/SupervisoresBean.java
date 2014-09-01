/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.beans;

import app.rongo.Postulante;
import app.rongo.Session;
import app.rongo.facade.AyudanteFacadeLocal;
import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.facade.AyudantiasofertadasFacadeLocal;
import app.rongo.facade.CuestionarioFacadeLocal;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.facade.PostulacionFacadeLocal;
import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.facade.ValordeldesempenoFacadeLocal;
import app.rongo.pdfmatico.PDFFinal;
import app.rongo.pdfmatico.PDFInforme;
import app.rongo.pdfmatico.PDFMatico;
import app.rongo.pdfmatico.PDFPrimera;
import app.rongo.persistence.Ayudante;
import app.rongo.persistence.Ayudantia;
import app.rongo.persistence.Ayudantiasofertadas;
import app.rongo.persistence.Cuestionario;
import app.rongo.persistence.Estudiante;
import app.rongo.persistence.HoraAsignada;
import app.rongo.persistence.Item;
import app.rongo.persistence.ObservacionesActividad;
import app.rongo.persistence.Postulacion;
import app.rongo.persistence.Supervisor;
import app.rongo.persistence.Valordeldesempeno;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "supervisoresBean")
@SessionScoped
public class SupervisoresBean {
    
    
    @EJB
    private ValordeldesempenoFacadeLocal valordeldesempenoFacade;
    
    @EJB
    private CuestionarioFacadeLocal cuestionarioFacade;

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    private Estudiante estudiante = new Estudiante();
    private List<Estudiante> estudiantes = new ArrayList();
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
    private List<Ayudante> ayudantesporsupervisor = new ArrayList();
    private EstudianteBean estudianteBean=new EstudianteBean();
    public int idEstudiante=-1;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    public String calificacion0="";

    public String getCalificacion0() {
        return calificacion0;
    }

    public void setCalificacion0(String calificacion0) {
        this.calificacion0 = calificacion0;
    }

    public String getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(String calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public String getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(String calificacion2) {
        this.calificacion2 = calificacion2;
    }

    public String getCalificacion3() {
        return calificacion3;
    }

    public void setCalificacion3(String calificacion3) {
        this.calificacion3 = calificacion3;
    }

    public String getCalificacion4() {
        return calificacion4;
    }

    public void setCalificacion4(String calificacion4) {
        this.calificacion4 = calificacion4;
    }

    public String getObservacion0() {
        return observacion0;
    }

    public void setObservacion0(String observacion0) {
        this.observacion0 = observacion0;
    }

    public String getObservacion1() {
        return observacion1;
    }

    public void setObservacion1(String observacion1) {
        this.observacion1 = observacion1;
    }

    public String getObservacion2() {
        return observacion2;
    }

    public void setObservacion2(String observacion2) {
        this.observacion2 = observacion2;
    }

    public String getObservacion3() {
        return observacion3;
    }

    public void setObservacion3(String observacion3) {
        this.observacion3 = observacion3;
    }

    public String getObservacion4() {
        return observacion4;
    }

    public void setObservacion4(String observacion4) {
        this.observacion4 = observacion4;
    }
    public String calificacion1="";
    public String calificacion2="";
    public String calificacion3="";
    public String calificacion4="";
    
    public String observacion0="";
    public String observacion1="";
    public String observacion2="";
    public String observacion3="";
    public String observacion4="";

    

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
public PDFMatico load(Cuestionario c){
        PDFMatico pdf=null;
        switch(c.getTipo()){
            case 0://Primera evaluacion
            {
                pdf=new PDFPrimera();
                loadStandartPDF(pdf,c);
             
             for(ObservacionesActividad oa:c.getObservacionesActividadList()){
                 ((PDFInforme)pdf).setActividad(oa.getActividadesRealizadas(),oa.getNumero());
                 ((PDFInforme)pdf).setHoras(oa.getHoras(), oa.getNumero());
                 ((PDFInforme)pdf).setObservaciones(oa.getObservaciones(), oa.getNumero());
             }
            }
            break;
            case 1:// evaluacion Final
            {
                pdf=new PDFFinal();
                loadStandartPDF(pdf,c);
             for(Valordeldesempeno v:c.getValordeldesempenoList()){
                        pdf.setCalificacion(v.getCalificacion(), v.getCriterio());
                        pdf.setCalificacion(v.getCalificacion(), v.getCriterio());
             }
            
            }
            break;
            default:// Informe Ayudantes (se asume que es 2)
            {
                pdf=new PDFInforme();
                loadStandartPDF(pdf,c);
                for(Valordeldesempeno v:c.getValordeldesempenoList()){
                           pdf.setCalificacion(v.getCalificacion(), v.getCriterio());
                           pdf.setCalificacion(v.getCalificacion(), v.getCriterio());
                }
            }
            break;
        
        }
        return pdf;
    }
    public void loadStandartPDF(PDFMatico pdf,Cuestionario c){
             pdf.setUnidadAcademica(c.getArea());
             pdf.setNombreAyudante(estudianteBean.estudianteName(ayudanteFacade.find(c.getIdayudante()).getIdEstudiante().getUsuario()));
             pdf.setJefe(getSupervisor().getNombre()+" "+getSupervisor().getApellido());
             pdf.setMatricula(estudianteBean.estudianteMatricula(ayudanteFacade.find(c.getIdayudante()).getIdEstudiante().getUsuario()));
             pdf.setDesde(""+c.getDesde().getDay(),""+c.getDesde().getMonth(),""+c.getDesde().getYear());
             pdf.setHasta(""+c.getHasta().getDay(),""+c.getHasta().getMonth(),""+c.getHasta().getYear());
             pdf.setAñoAcademico(c.getAnioacademicodesde(),c.getAnioacademicohasta());
             pdf.setFecha_evaluacion(""+c.getFecha().getDay()+"/"+c.getFecha().getMonth()+"/"+c.getFecha().getYear());
             for(HoraAsignada h:c.getHoraAsignadaList()){
             pdf.setHorario(h.getDia(),h.getHoras());
             }
             for(Item i:c.getItemList()){
                 switch(i.getTipo().intValue()){
                     case 0://Lo mejor en su desempeño:
                     {
                         ((PDFFinal)pdf).setDesempeño(i.getContenido());
                     }
                         break;
                     case 1://Lo que debe mejorar:
                     {
                         ((PDFFinal)pdf).setMejorar(i.getContenido());
                     }
                         break;
                         case 2://Total de horas laboradas:
                     {
                         ((PDFInforme)pdf).setHoras_laboradas(i.getContenido());
                     }
                         break;
                     case 3://Observaciones generales:
                     {
                         ((PDFInforme)pdf).setObservacionesGenerales(i.getContenido());
                     }
                         break;
                 }
             }
    }
public void generarPrimeraEvaluacion(){
    Cuestionario c=new Cuestionario();
    int i=1;
    c.setTipo(0);//Primera evaluacion; 1 Evaluacion final, 2 informe de ayudantes; 
    c.setIdevaluacionDesempeno(cuestionarioFacade.count()+1);
    c.setArea("FIEC");
            int idAyudante=-1;
            for(Ayudante a:ayudanteFacade.findAll()){
            if(a.getIdEstudiante().getIdUsuario()==idEstudiante){
            idAyudante=a.getIdayudante();
            }
            }
            c.setIdayudante(idAyudante);
        
    c.setIdsupervisor(getSupervisor());
    c.setDesde(new Date(2014,6,7));
    c.setHasta(new Date(2014,6,8));
    c.setAnioacademicodesde(2014);
    c.setAnioacademicohasta(2015);
    c.setFecha(new Date());
    
    cuestionarioFacade.create(c);
    
    
    Valordeldesempeno vd;
    
    vd=new Valordeldesempeno(valordeldesempenoFacade.count()+1);
    vd.setCriterio(0);
    vd.setIdevaluacion2(c);
    vd.setObservacion(observacion0);
    vd.setCalificacion(Integer.parseInt("0"+calificacion0.replaceAll("\\D+","")));
    valordeldesempenoFacade.create(vd);    
    
    vd=new Valordeldesempeno(valordeldesempenoFacade.count()+1);
    vd.setCriterio(1);
    vd.setIdevaluacion2(c);
    vd.setObservacion(observacion1);
    vd.setCalificacion(Integer.parseInt("0"+calificacion1.replaceAll("\\D+","")));
    valordeldesempenoFacade.create(vd);    
    
    vd=new Valordeldesempeno(valordeldesempenoFacade.count()+1);
    vd.setCriterio(2);
    vd.setIdevaluacion2(c);
    vd.setObservacion(observacion2);
    vd.setCalificacion(Integer.parseInt("0"+calificacion2.replaceAll("\\D+","")));
    valordeldesempenoFacade.create(vd);    
    
    vd=new Valordeldesempeno(valordeldesempenoFacade.count()+1);
    vd.setCriterio(3);
    vd.setIdevaluacion2(c);
    vd.setObservacion(observacion3);
    vd.setCalificacion(Integer.parseInt("0"+calificacion3.replaceAll("\\D+","")));
    valordeldesempenoFacade.create(vd);    
    
    vd=new Valordeldesempeno(valordeldesempenoFacade.count()+1);
    vd.setCriterio(4);
    vd.setIdevaluacion2(c);
    vd.setObservacion(observacion4);
    vd.setCalificacion(Integer.parseInt("0"+calificacion4.replaceAll("\\D+","")));
    valordeldesempenoFacade.create(vd);    
    
    
    
    /*
        PDFPrimera pdf=new PDFPrimera();
        pdf.setUnidadAcademica("FIEC");
        pdf.setNombreAyudante("ninguno");
        pdf.setMatricula("<esperando>");
        pdf.setJefe(getSupervisor().getNombre()+" "+getSupervisor().getApellido());
        pdf.setDesde("<esperando>", "<esperando>", "<esperando>");
        pdf.setHasta("<esperando>", "<esperando>", "<esperando>");
        pdf.setAñoAcademico(0000,0000);
        
        //pdf.setHorario(l, mar, mi, j, v, s, d);
        for(int i=0;i<5;i++){
            pdf.setCalificacion(0,i);
            pdf.setObservaciones("<escribir observacion aqui>", i);
        }
    */
    
    
    PDFMatico pdf=load(c);
    pdf.generate();
        
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
            est.setIdPostulacion(p.getIdpostulacion());
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

    public void rechazarPostulante(Postulante e){
        Postulacion pos = new Postulacion();
        pos=postulacionFacade.find(e.getIdPostulacion());
        postulacionFacade.remove(pos);
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

        for (Estudiante b : es) {
            if (b.getUsuario().equals(e.getUsuario())) {
                estudiante = b;
            }
        }

        for (Postulacion p : getPostulantesporsupervisor()) {
            if (p.getIdestudiante().equals(estudiante)) {
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

        for (Ayudantia ay : ayudantias) {
            if (ay.getIdsupervisor().equals(s) && ay.getNombre().equals(a.getNombreayudanatia())) {
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

    public void obtenerAyudantesporsupervisor() {
        Supervisor s;
        List<Ayudantia> ayu = new ArrayList();
        ayudantesporsupervisor = new ArrayList();

        obtenerSupervisorLogueado();
        s = getSupervisor();
        ayudantias = ayudantiaFacade.findAll();

        for (Ayudantia a : ayudantias) {
            if (a.getIdsupervisor().equals(s)) {
                ayu.add(a);
            }
        }
        ayudantes = ayudanteFacade.findAll();
        for (Ayudante a : ayudantes) {
            for (Ayudantia ay : ayu) {
                if (a.getIdayudantia().equals(ay)) {
                    ayudantesporsupervisor.add(a);
                }
            }
        }

        /*for (Ayudante ay : ayudantesporsupervisor) {
            estudiantes.add(ay.getIdEstudiante());
            
        }*/
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

    public List<Ayudante> getAyudantesporsupervisor() {
        return ayudantesporsupervisor;
    }

    public void setAyudantesporsupervisor(List<Ayudante> ayudantesporsupervisor) {
        this.ayudantesporsupervisor = ayudantesporsupervisor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
