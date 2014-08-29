/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Ayudantia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface AyudantiaFacadeLocal {

    void create(Ayudantia ayudantia);

    void edit(Ayudantia ayudantia);

    void remove(Ayudantia ayudantia);

    Ayudantia find(Object id);

    List<Ayudantia> findAll();

    List<Ayudantia> findRange(int[] range);

    int count();
    
}
