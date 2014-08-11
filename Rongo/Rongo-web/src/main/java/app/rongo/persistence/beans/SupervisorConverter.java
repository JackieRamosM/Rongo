/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;
import app.rongo.facade.SupervisorFacadeLocal;
import app.rongo.persistence.Supervisor;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrador
 */
@FacesConverter("app.rongo.persistence.beans.SupervisorConverter")
public class SupervisorConverter implements Converter {
    @EJB
    SupervisorFacadeLocal facade;
    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {    
        value = value.replaceAll("\\D+","");
        Supervisor supervisor = facade.find(Integer.parseInt(value));
        return supervisor;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }

}
