/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.facade;

import app.rongo.persistence.Valordeldesempeno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Liliana
 */
@Local
public interface ValordeldesempenoFacadeLocal {

    void create(Valordeldesempeno valordeldesempeno);

    void edit(Valordeldesempeno valordeldesempeno);

    void remove(Valordeldesempeno valordeldesempeno);

    Valordeldesempeno find(Object id);

    List<Valordeldesempeno> findAll();

    List<Valordeldesempeno> findRange(int[] range);

    int count();
    
}
