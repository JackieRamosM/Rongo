/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.facade;

import app.rongo.persistence.Postulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Liliana
 */
@Local
public interface PostulacionFacadeLocal {

    void create(Postulacion postulacion);

    void edit(Postulacion postulacion);

    void remove(Postulacion postulacion);

    Postulacion find(Object id);

    List<Postulacion> findAll();

    List<Postulacion> findRange(int[] range);

    int count();
    
}
