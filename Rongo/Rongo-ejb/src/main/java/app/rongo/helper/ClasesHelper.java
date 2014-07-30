/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.helper;

import app.rongo.persistence.Clase;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Liliana
 */
@Stateless
@LocalBean
public class ClasesHelper {

    private EntityManager em;

    public List<Clase> getClases() {
        Query q = em.createNamedQuery("Clase.findAll");
        return null;
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
