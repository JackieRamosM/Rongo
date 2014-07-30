/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

import java.io.Serializable;
import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Liliana
 */
@Named(value = "clasesBean")
@SessionScoped
public class ClasesBean implements Serializable {
    @EJB
    private app.rongo.helper.ClasesHelper clasesHelper;
    private String h;

    /**
     * Creates a new instance of ClasesBean
     */
    
    public ClasesBean() {
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
    
    
    
}
