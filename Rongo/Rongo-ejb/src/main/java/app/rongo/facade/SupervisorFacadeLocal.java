/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Supervisor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface SupervisorFacadeLocal {

    void create(Supervisor supervisor);

    void edit(Supervisor supervisor);

    void remove(Supervisor supervisor);

    Supervisor find(Object id);

    List<Supervisor> findAll();

    List<Supervisor> findRange(int[] range);

    int count();
    
}
