/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.ObservacionesActividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface ObservacionesActividadFacadeLocal {

    void create(ObservacionesActividad observacionesActividad);

    void edit(ObservacionesActividad observacionesActividad);

    void remove(ObservacionesActividad observacionesActividad);

    ObservacionesActividad find(Object id);

    List<ObservacionesActividad> findAll();

    List<ObservacionesActividad> findRange(int[] range);

    int count();
    
}
