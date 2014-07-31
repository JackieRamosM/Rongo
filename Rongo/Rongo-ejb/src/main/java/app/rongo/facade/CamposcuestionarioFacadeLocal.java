/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.facade;

import app.rongo.persistence.Camposcuestionario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Liliana
 */
@Local
public interface CamposcuestionarioFacadeLocal {

    void create(Camposcuestionario camposcuestionario);

    void edit(Camposcuestionario camposcuestionario);

    void remove(Camposcuestionario camposcuestionario);

    Camposcuestionario find(Object id);

    List<Camposcuestionario> findAll();

    List<Camposcuestionario> findRange(int[] range);

    int count();
    
}
