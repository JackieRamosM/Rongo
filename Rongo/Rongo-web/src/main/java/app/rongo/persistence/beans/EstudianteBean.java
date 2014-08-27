/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence.beans;

import app.rongo.beans.Session;
import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Ayudantiasofertadas;
import app.rongo.persistence.Estudiante;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

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
    private String nombre;
    private int idestudiante;
    private boolean admin;
    private UploadedFile file;

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
    
    public String estudianteName(String user){
        return session.nombreService(session.matriculaService(user));
    }
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            //FacesContext.getCurrentInstance().addMessage(null, message);
            UploadedFile uploadedFile = file;
            //create an InputStream from the uploaded file
            InputStream inputStr = null;
            try {
                inputStr = uploadedFile.getInputstream();
            } catch (IOException e) {
                //log error
            }
            //create destination File
            String destPath = "C:\\Users\\Liliana\\Documents\\Git\\rongo\\Rongo\\tmp\\file2.pdf";
            File destFile = new File(destPath);
            //use org.apache.commons.io.FileUtils to copy the File
            try {
                FileUtils.copyInputStreamToFile(inputStr, destFile);
            } catch (IOException e) {
                //log error
            }
        } else {
            System.out.println("I'm Groot");
        }
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

}
