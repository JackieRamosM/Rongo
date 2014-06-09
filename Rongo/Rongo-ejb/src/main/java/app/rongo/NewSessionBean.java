/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {
    public NewSessionBean(){
        super();
        System.setProperty("javax.net.ssl.trustStore",  "c:\\Program Files\\Java\\jdk1.7.0_55\\jre\\lib\\security\\cacerts");  
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    }

    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
