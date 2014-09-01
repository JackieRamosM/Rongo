/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Valordeldesempeno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SEHORE
 */
@Stateless
public class ValordeldesempenoFacade extends AbstractFacade<Valordeldesempeno> implements ValordeldesempenoFacadeLocal {
    @PersistenceContext(unitName = "app.rongo_Rongo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValordeldesempenoFacade() {
        super(Valordeldesempeno.class);
    }
    
}
