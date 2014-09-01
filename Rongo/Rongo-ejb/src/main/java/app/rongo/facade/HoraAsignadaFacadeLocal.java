/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.HoraAsignada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface HoraAsignadaFacadeLocal {

    void create(HoraAsignada horaAsignada);

    void edit(HoraAsignada horaAsignada);

    void remove(HoraAsignada horaAsignada);

    HoraAsignada find(Object id);

    List<HoraAsignada> findAll();

    List<HoraAsignada> findRange(int[] range);

    int count();
    
}
