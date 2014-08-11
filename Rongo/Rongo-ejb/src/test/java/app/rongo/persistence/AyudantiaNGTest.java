/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo.persistence;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author SEHORE
 */
public class AyudantiaNGTest {
    
    public AyudantiaNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getIdayudantia method, of class Ayudantia.
     */
    @Test
    public void testGetIdayudantia() {
        System.out.println("getIdayudantia");
        Ayudantia instance = new Ayudantia();
        Integer result = instance.getIdayudantia();
        assertEquals(result, null,"siendo null el id de la ayudantia en el constructor, parece que el id no fue null");
        int n=8;
        instance = new Ayudantia(new Integer(n));
        assertEquals(instance.getIdayudantia(), new Integer(n),"siendo "+n+" el id de la ayudantia en el constructor, parece que el id al pedirselo no fue "+n);
    
    
    }

    /**
     * Test of setIdayudantia method, of class Ayudantia.
     */
    @Test
    public void testSetIdayudantia() {
        System.out.println("setIdayudantia");
        Ayudantia instance = new Ayudantia();
        instance.setIdayudantia(null);
        Integer result = instance.getIdayudantia();
        assertEquals(instance.getIdayudantia(), null,"siendo null el id de la ayudantia en setAyudantia, parece que el id no fue null");
        int n=8;
        instance = new Ayudantia();
        instance.setIdayudantia(n);
        assertEquals(instance.getIdayudantia(), new Integer(n),"siendo "+n+" el id de la ayudantia en setAyudantia, parece que el id al pedirselo no fue "+n);
    
    }

    /**
     * Test of getNombre method, of class Ayudantia.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Ayudantia instance = new Ayudantia();
        instance.setNombre("Estructrura de Datos");
        String expResult = "Estructrura de Datos";
        String result = instance.getNombre();
        assertEquals(result, expResult);
    }

    /**
     * Test of setNombre method, of class Ayudantia.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        
        Ayudantia instance = new Ayudantia();
        instance.setNombre("Bases de datos");
        String expResult = "Bases de datos";
        String result = instance.getNombre();
        assertEquals(result, expResult);
    }

    /**
     * Test of getTipodeayudantia method, of class Ayudantia.
     */
    @Test
    public void testGetTipodeayudantia() {
        System.out.println("getTipodeayudantia");
        Ayudantia instance = new Ayudantia();
        instance.setTipodeayudantia("Academica");
        String expResult = "Academica";
        String result = instance.getTipodeayudantia();
        assertEquals(result, expResult);
    }

    /**
     * Test of setTipodeayudantia method, of class Ayudantia.
     */
    @Test
    public void testSetTipodeayudantia() {
        System.out.println("setTipodeayudantia");
        String tipodeayudantia = "Academica";
        Ayudantia instance = new Ayudantia();
        instance.setTipodeayudantia(tipodeayudantia);
    }

    /**
     * Test of getAyudanteList method, of class Ayudantia.
     */
    @Test
    public void testGetAyudanteList() {
        System.out.println("getAyudanteList");
        Ayudantia instance = new Ayudantia();
        List expResult = null;
        List result = instance.getAyudanteList();
        assertEquals(result, expResult);
    }

    /**
     * Test of setAyudanteList method, of class Ayudantia.
     */
    @Test
    public void testSetAyudanteList() {
        System.out.println("setAyudanteList");
        List<Ayudante> ayudanteList = null;
        Ayudantia instance = new Ayudantia();
        instance.setAyudanteList(ayudanteList);
    }

    /**
     * Test of getClaseList method, of class Ayudantia.
     */
    @Test
    public void testGetClaseList() {
        System.out.println("getClaseList");
        Ayudantia instance = new Ayudantia();
        List expResult = null;
        List result = instance.getClaseList();
        assertEquals(result, expResult);
    }

    /**
     * Test of setClaseList method, of class Ayudantia.
     */
    @Test
    public void testSetClaseList() {
        System.out.println("setClaseList");
        List<Clase> claseList = null;
        Ayudantia instance = new Ayudantia();
        instance.setClaseList(claseList);
    }

    /**
     * Test of getIdsupervisor method, of class Ayudantia.
     */
    @Test
    public void testGetIdsupervisor() {
        System.out.println("getIdsupervisor");
        Ayudantia instance = new Ayudantia();
        Supervisor expResult = null;
        Supervisor result = instance.getIdsupervisor();
        assertEquals(result, expResult);
    }

    /**
     * Test of setIdsupervisor method, of class Ayudantia.
     */
    @Test
    public void testSetIdsupervisor() {
        System.out.println("setIdsupervisor");
        Supervisor idsupervisor = null;
        Ayudantia instance = new Ayudantia();
        instance.setIdsupervisor(idsupervisor);
    }

    /**
     * Test of hashCode method, of class Ayudantia.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Ayudantia instance = new Ayudantia();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
    }

    /**
     * Test of equals method, of class Ayudantia.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Ayudantia instance = new Ayudantia();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
    }

    /**
     * Test of toString method, of class Ayudantia.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ayudantia instance = new Ayudantia();
        String expResult = "";
        String result = instance.toString();
        //assertEquals(result,"[idayudantia="+instance.getIdayudantia()+"]");
        assertTrue(result.endsWith("[ idayudantia="+instance.getIdayudantia()+" ]"));
    }
}