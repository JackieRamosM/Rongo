/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.facade;

import app.rongo.persistence.Clase;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author SEHORE
 */
public class ClaseFacadeNGTest {
    private static final String MODULE_NAME = "embedded";  
private static final String TARGET_DIR = "target/" + MODULE_NAME;
    private static Context ctx;  
    private static EJBContainer container; 
    private static DataSource datasource;
    public ClaseFacadeNGTest() {
    }
    
    public static void createContainer() {  
        Map<String, Object> properties = new HashMap<String, Object>();  
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root","./src/test/glassfish");  
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "./src/test/glassfish/domains/domain1/config/domain.xml");
        container = EJBContainer.createEJBContainer(properties);
        ctx = container.getContext();  
        /*try {
            datasource = (DataSource) ctx.lookup("rongo");
        } catch (NamingException ex) {
            Logger.getLogger(ClaseFacadeNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    private static File prepareModuleDirectory() throws IOException {  
    File result = new File(TARGET_DIR);  
    FileUtils.copyDirectory(new File("target/classes"), result);  
    FileUtils.copyFile(new File("target/test-classes/META-INF/persistence.xml"),   
            new File(TARGET_DIR + "/META-INF/persistence.xml"));  
    return result;  
}
    @BeforeClass
    public static void setUpClass() throws Exception {
        createContainer();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        container.close();
    }
    /**
     * Test of find method, of class ClaseFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = new Integer(1);
        ClaseFacadeLocal instance = (ClaseFacadeLocal)container.getContext().lookup("java:global/classes/ClaseFacade");
        Clase expResult = null;
        Clase result = instance.find(id);
        assertNotNull(result,"si el id es 1, esperamos que la respuesta sea algo distinto a null");
        id = new Integer(0);
        result = instance.find(id);
        assertNull(result,"si el id es 0, esperamos que la respuesta sea null");
       // container.close();
    }

    /**
     * Test of findAll method, of class ClaseFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
       // EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClaseFacadeLocal instance = (ClaseFacadeLocal)container.getContext().lookup("java:global/classes/ClaseFacade");
        List result = instance.findAll();
        assertNotNull(result,"esperamos que el resultado no sea null ya que tenemos al menos una clase en la base");
       // container.close();
    }
    /**
     * Test of count method, of class ClaseFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
       // EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClaseFacadeLocal instance = (ClaseFacadeLocal)container.getContext().lookup("java:global/classes/ClaseFacade");
        int expResult = 1;
        int result = instance.count();
        assertEquals(result, expResult,"esperamos que la cuenta sea 1 ya que tenemos solo 1 clase en la base");
       // container.close();
        
    }
}