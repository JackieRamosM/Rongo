/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.CurriculumFacadeLocal;
import app.rongo.persistence.Curriculum;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.servlet.http.Part;

/**
 *
 * @author Administrador
 */
@Named(value = "curriculumBean")
@SessionScoped
public class CurriculumBean implements Serializable {
    
    @EJB
    CurriculumFacadeLocal curriculumFacade;
    Curriculum curriculum;
    private Part file;
    private String fileContent = "";
    List<Curriculum> curriculums;
    
    /**
     * Creates a new instance of ClaseBean
     */
    public CurriculumBean() {
    }
 
    public void init(){
        curriculum = new Curriculum();
       /* curriculum.setArchivo("");
        curriculum.setNombre("test");*/
        file = Part.class.getEnumConstants()[0];
        fileContent = "";
    }
    
    public void upload() throws IOException, MessagingException {
        try {
            fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
            curriculum.setNombre("Test");
          //  curriculum.setArchivo(fileContent);
            curriculumFacade.create(curriculum);
        } catch (IOException e) {}
    }
 
    public List<Curriculum> getClases(){
        curriculums = curriculumFacade.findAll();
        return curriculums;
    }
    
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
}
