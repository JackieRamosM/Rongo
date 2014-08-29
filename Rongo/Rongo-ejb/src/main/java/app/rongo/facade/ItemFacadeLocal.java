/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SEHORE
 */
@Local
public interface ItemFacadeLocal {

    void create(Item item);

    void edit(Item item);

    void remove(Item item);

    Item find(Object id);

    List<Item> findAll();

    List<Item> findRange(int[] range);

    int count();
    
}
