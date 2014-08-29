/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo;

import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Liliana
 */
public class Session {

    private String user;
    private String matriculauser;
    private String datos;
    private String nombre;
    private double promedio;
    private List<String> materiasuser;

    public void getUserFromCas() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        setUser(facesContext.getExternalContext().getRemoteUser());
       

    }

    private void matriculaService() {

        try { // Call Web Service Operation

            app.get.matriculas.GetMatriculas_Service service = new app.get.matriculas.GetMatriculas_Service();
            app.get.matriculas.GetMatriculas port = service.getGetMatriculasPort();
            // TODO initialize WS operation arguments here
            java.lang.String username = getUser();
            // TODO process result here
            matriculauser = port.getMatricula(username);

        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    public String matriculaService(String us) {
        String mat = "";
        try { // Call Web Service Operation

            app.get.matriculas.GetMatriculas_Service service = new app.get.matriculas.GetMatriculas_Service();
            app.get.matriculas.GetMatriculas port = service.getGetMatriculasPort();
            // TODO initialize WS operation arguments here
            java.lang.String username = us;
            // TODO process result here
            mat = port.getMatricula(username);

        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return mat;
    }

    private void materiasService() {

        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = getMatriculauser();
            // TODO process result here
            materiasuser = port.getMaterias(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void datosService() {

        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = getMatriculauser();
            // TODO process result here
            datos = port.getDatos(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    
    public String carreraService(String mat) {
        String dat="";
        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = mat;
            // TODO process result here
            dat = port.getDatos(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return dat;
    }

    private void nombreService() {

        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = getMatriculauser();
            // TODO process result here
            nombre = port.getNombre(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

    public String nombreService(String mat) {
        String nom = "";
        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = mat;
            // TODO process result here
            nom = port.getNombre(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return nom;
    }

    private void promedioService() {

        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = getMatriculauser();
            // TODO process result here
            promedio = port.getPromedioGeneral(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

    public double promedioService(String mat) {

        double prom = 0;
        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = mat;
            // TODO process result here
            prom = port.getPromedioGeneral(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return prom;
    }
    
    public boolean estadoService(String mat){
        boolean estado=false;
        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String matricula = mat;
            // TODO process result here
            estado = port.getEstadoRegular(matricula);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return estado;
    }
    
    public String codigoService(String cod){
        String nom="";
        try { // Call Web Service Operation
            app.espol.phantom.EspolPhantom_Service service = new app.espol.phantom.EspolPhantom_Service();
            app.espol.phantom.EspolPhantom port = service.getEspolPhantomPort();
            // TODO initialize WS operation arguments here
            java.lang.String codigo = cod;
            // TODO process result here
            nom= port.obtenerMateriasDesdeCodigo(codigo);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return nom;
    }

    public String getUser() {
        getUserFromCas();
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMatriculauser() {
        matriculaService();
        return matriculauser;
    }

    public List<String> getMateriasuser() {
        materiasService();
        return materiasuser;
    }

    public String getDatos() {
        datosService();
        return datos;
    }

    public String getNombre() {
        nombreService();
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPromedio() {
        promedioService();
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

}
