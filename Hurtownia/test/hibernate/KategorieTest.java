/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karol
 */
public class KategorieTest {
    
    public KategorieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKategoriaId method, of class Kategorie.
     */
    @Test
    public void testGetKategoriaId() {
        System.out.println("getKategoriaId");
        Kategorie instance = new Kategorie();
        Integer expResult = null;
        Integer result = instance.getKategoriaId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKategoriaId method, of class Kategorie.
     */
    @Test
    public void testSetKategoriaId() {
        System.out.println("setKategoriaId");
        Integer kategoriaId = null;
        Kategorie instance = new Kategorie();
        instance.setKategoriaId(kategoriaId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwa method, of class Kategorie.
     */
    @Test
    public void testGetNazwa() {
        System.out.println("getNazwa");
        Kategorie instance = new Kategorie();
        String expResult = "";
        String result = instance.getNazwa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwa method, of class Kategorie.
     */
    @Test
    public void testSetNazwa() {
        System.out.println("setNazwa");
        String nazwa = "";
        Kategorie instance = new Kategorie();
        instance.setNazwa(nazwa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpis method, of class Kategorie.
     */
    @Test
    public void testGetOpis() {
        System.out.println("getOpis");
        Kategorie instance = new Kategorie();
        String expResult = "";
        String result = instance.getOpis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOpis method, of class Kategorie.
     */
    @Test
    public void testSetOpis() {
        System.out.println("setOpis");
        String opis = "";
        Kategorie instance = new Kategorie();
        instance.setOpis(opis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdukties method, of class Kategorie.
     */
    @Test
    public void testGetProdukties() {
        System.out.println("getProdukties");
        Kategorie instance = new Kategorie();
        Set expResult = null;
        Set result = instance.getProdukties();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProdukties method, of class Kategorie.
     */
    @Test
    public void testSetProdukties() {
        System.out.println("setProdukties");
        Set produkties = null;
        Kategorie instance = new Kategorie();
        instance.setProdukties(produkties);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
