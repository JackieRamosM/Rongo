/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Asistencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface AsistenciaFacadeLocal {

    void create(Asistencia asistencia);

    void edit(Asistencia asistencia);

    void remove(Asistencia asistencia);

    Asistencia find(Object id);

    List<Asistencia> findAll();

    List<Asistencia> findRange(int[] range);

    int count();
    
}
