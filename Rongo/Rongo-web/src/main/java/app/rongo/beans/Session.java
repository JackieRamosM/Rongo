/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Liliana
 */
public class Session {
    
    private String user;
    private String matriculauser;
    private List<String> materiasuser;
    
    public void getUserFromCas() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        setUser(facesContext.getExternalContext().getRemoteUser());
        
    }
    
    private void matriculaService(){
        
        try { // Call Web Service Operation
            getUserFromCas();
            app.get.matriculas.GetMatriculas_Service service = new app.get.matriculas.GetMatriculas_Service();
            app.get.matriculas.GetMatriculas port = service.getGetMatriculasPort();
            // TODO initialize WS operation arguments here
            java.lang.String username = getUser();
            // TODO process result here
            matriculauser = port.getMatricula(username);
            System.out.println("Result = "+matriculauser);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    private void materiasService(){
        
        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = getMatriculauser();
            // TODO process result here
            materiasuser = port.getMaterias(matricula); 
            System.out.println("Result = "+materiasuser);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMatriculauser() {
        matriculaService();
        return matriculauser;
    }

    public void setMatriculauser(String matricula) {
        this.matriculauser = matricula;
    }

    public List<String> getMateriasuser() {
        materiasService();
        return materiasuser;
    }

    public void setMateriasuser(List<String> materiasuser) {
        this.materiasuser = materiasuser;
    }
    
}
