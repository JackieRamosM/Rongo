/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.persistence.beans;

import app.rongo.facade.AyudantiaFacadeLocal;
import app.rongo.persistence.Ayudantia;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Administrador
 */
@Named(value = "ayudantiaBean")
@SessionScoped
public class AyudantiaBean implements Serializable {
    
    @EJB
    AyudantiaFacadeLocal ayudantia;
    List<Ayudantia> ayudantias;
    
    public AyudantiaBean() {}
    
    public void getAyudantias(){
        ayudantias = ayudantia.findAll();
    }
    
    public boolean ayudantiaExiste(String ayudantia){
        boolean res = false;
        getAyudantias();
        for(Ayudantia a : ayudantias){
            if(ayudantia.toLowerCase().contains(a.getNombre().toLowerCase()))
                res = true;
        }
        return res;
    }
}
