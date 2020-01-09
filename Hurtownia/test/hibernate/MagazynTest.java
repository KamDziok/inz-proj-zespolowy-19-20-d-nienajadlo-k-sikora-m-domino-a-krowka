/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

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
public class MagazynTest {
    
    public MagazynTest() {
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
     * Test of getMagazynId method, of class Magazyn.
     */
    @Test
    public void testGetMagazynId() {
        System.out.println("getMagazynId");
        Magazyn instance = new Magazyn();
        Integer expResult = null;
        Integer result = instance.getMagazynId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMagazynId method, of class Magazyn.
     */
    @Test
    public void testSetMagazynId() {
        System.out.println("setMagazynId");
        Integer magazynId = null;
        Magazyn instance = new Magazyn();
        instance.setMagazynId(magazynId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHurtownia method, of class Magazyn.
     */
    @Test
    public void testGetHurtownia() {
        System.out.println("getHurtownia");
        Magazyn instance = new Magazyn();
        Hurtownia expResult = null;
        Hurtownia result = instance.getHurtownia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHurtownia method, of class Magazyn.
     */
    @Test
    public void testSetHurtownia() {
        System.out.println("setHurtownia");
        Hurtownia hurtownia = null;
        Magazyn instance = new Magazyn();
        instance.setHurtownia(hurtownia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdukty method, of class Magazyn.
     */
    @Test
    public void testGetProdukty() {
        System.out.println("getProdukty");
        Magazyn instance = new Magazyn();
        Produkty expResult = null;
        Produkty result = instance.getProdukty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProdukty method, of class Magazyn.
     */
    @Test
    public void testSetProdukty() {
        System.out.println("setProdukty");
        Produkty produkty = null;
        Magazyn instance = new Magazyn();
        instance.setProdukty(produkty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIlosc method, of class Magazyn.
     */
    @Test
    public void testGetIlosc() {
        System.out.println("getIlosc");
        Magazyn instance = new Magazyn();
        int expResult = 0;
        int result = instance.getIlosc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIlosc method, of class Magazyn.
     */
    @Test
    public void testSetIlosc() {
        System.out.println("setIlosc");
        int ilosc = 0;
        Magazyn instance = new Magazyn();
        instance.setIlosc(ilosc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCenaSprzedazy method, of class Magazyn.
     */
    @Test
    public void testGetCenaSprzedazy() {
        System.out.println("getCenaSprzedazy");
        Magazyn instance = new Magazyn();
        float expResult = 0.0F;
        float result = instance.getCenaSprzedazy();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCenaSprzedazy method, of class Magazyn.
     */
    @Test
    public void testSetCenaSprzedazy() {
        System.out.println("setCenaSprzedazy");
        float cenaSprzedazy = 0.0F;
        Magazyn instance = new Magazyn();
        instance.setCenaSprzedazy(cenaSprzedazy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
