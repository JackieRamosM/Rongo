/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.facade;

import app.rongo.persistence.Clase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Liliana
 */
@Local
public interface ClaseFacadeLocal {

    void create(Clase clase);

    void edit(Clase clase);

    void remove(Clase clase);

    Clase find(Object id);

    List<Clase> findAll();

    List<Clase> findRange(int[] range);

    int count();
    
}
