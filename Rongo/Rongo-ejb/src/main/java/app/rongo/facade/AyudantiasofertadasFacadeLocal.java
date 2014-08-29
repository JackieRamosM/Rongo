/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Ayudantiasofertadas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface AyudantiasofertadasFacadeLocal {

    void create(Ayudantiasofertadas ayudantiasofertadas);

    void edit(Ayudantiasofertadas ayudantiasofertadas);

    void remove(Ayudantiasofertadas ayudantiasofertadas);

    Ayudantiasofertadas find(Object id);

    List<Ayudantiasofertadas> findAll();

    List<Ayudantiasofertadas> findRange(int[] range);

    int count();
    
}
