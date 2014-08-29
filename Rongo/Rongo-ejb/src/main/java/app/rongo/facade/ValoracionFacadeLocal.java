/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Valoracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface ValoracionFacadeLocal {

    void create(Valoracion valoracion);

    void edit(Valoracion valoracion);

    void remove(Valoracion valoracion);

    Valoracion find(Object id);

    List<Valoracion> findAll();

    List<Valoracion> findRange(int[] range);

    int count();
    
}
