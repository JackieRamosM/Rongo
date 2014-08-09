/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.facade;

import app.rongo.persistence.Ayudantia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Liliana
 */
@Stateless
public class AyudantiaFacade extends AbstractFacade<Ayudantia> implements AyudantiaFacadeLocal {
    @PersistenceContext(unitName = "app.rongo_Rongo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AyudantiaFacade() {
        super(Ayudantia.class);
    }
    
}