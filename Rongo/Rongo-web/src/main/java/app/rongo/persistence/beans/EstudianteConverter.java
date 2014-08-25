/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.EstudianteFacadeLocal;
import app.rongo.persistence.Estudiante;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrador
 */
@FacesConverter("app.rongo.persistence.beans.EstudianteConverter")
public class EstudianteConverter implements Converter {
    @EJB
    EstudianteFacadeLocal facade;
    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {    
        value = value.replaceAll("\\D+","");
        Estudiante estudiante = facade.find(Integer.parseInt(value));
        return estudiante;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
