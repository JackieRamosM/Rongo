/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Cuestionario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface CuestionarioFacadeLocal {

    void create(Cuestionario cuestionario);

    void edit(Cuestionario cuestionario);

    void remove(Cuestionario cuestionario);

    Cuestionario find(Object id);

    List<Cuestionario> findAll();

    List<Cuestionario> findRange(int[] range);

    int count();
    
}
