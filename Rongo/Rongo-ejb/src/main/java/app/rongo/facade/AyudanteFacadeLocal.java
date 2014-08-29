/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Ayudante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface AyudanteFacadeLocal {

    void create(Ayudante ayudante);

    void edit(Ayudante ayudante);

    void remove(Ayudante ayudante);

    Ayudante find(Object id);

    List<Ayudante> findAll();

    List<Ayudante> findRange(int[] range);

    int count();
    
}
