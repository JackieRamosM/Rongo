/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.facade;

import app.rongo.persistence.Curriculum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Liliana
 */
@Local
public interface CurriculumFacadeLocal {

    void create(Curriculum curriculum);

    void edit(Curriculum curriculum);

    void remove(Curriculum curriculum);

    Curriculum find(Object id);

    List<Curriculum> findAll();

    List<Curriculum> findRange(int[] range);

    int count();
    
}
