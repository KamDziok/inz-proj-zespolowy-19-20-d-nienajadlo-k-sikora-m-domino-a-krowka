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
public class TowaryzamowienieTest {
    
    public TowaryzamowienieTest() {
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
     * Test of getTowaryZamowienieId method, of class Towaryzamowienie.
     */
    @Test
    public void testGetTowaryZamowienieId() {
        System.out.println("getTowaryZamowienieId");
        Towaryzamowienie instance = new Towaryzamowienie();
        Integer expResult = null;
        Integer result = instance.getTowaryZamowienieId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTowaryZamowienieId method, of class Towaryzamowienie.
     */
    @Test
    public void testSetTowaryZamowienieId() {
        System.out.println("setTowaryZamowienieId");
        Integer towaryZamowienieId = null;
        Towaryzamowienie instance = new Towaryzamowienie();
        instance.setTowaryZamowienieId(towaryZamowienieId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdukty method, of class Towaryzamowienie.
     */
    @Test
    public void testGetProdukty() {
        System.out.println("getProdukty");
        Towaryzamowienie instance = new Towaryzamowienie();
        Produkty expResult = null;
        Produkty result = instance.getProdukty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProdukty method, of class Towaryzamowienie.
     */
    @Test
    public void testSetProdukty() {
        System.out.println("setProdukty");
        Produkty produkty = null;
        Towaryzamowienie instance = new Towaryzamowienie();
        instance.setProdukty(produkty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZamowienie method, of class Towaryzamowienie.
     */
    @Test
    public void testGetZamowienie() {
        System.out.println("getZamowienie");
        Towaryzamowienie instance = new Towaryzamowienie();
        Zamowienie expResult = null;
        Zamowienie result = instance.getZamowienie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZamowienie method, of class Towaryzamowienie.
     */
    @Test
    public void testSetZamowienie() {
        System.out.println("setZamowienie");
        Zamowienie zamowienie = null;
        Towaryzamowienie instance = new Towaryzamowienie();
        instance.setZamowienie(zamowienie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIlosc method, of class Towaryzamowienie.
     */
    @Test
    public void testGetIlosc() {
        System.out.println("getIlosc");
        Towaryzamowienie instance = new Towaryzamowienie();
        int expResult = 0;
        int result = instance.getIlosc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIlosc method, of class Towaryzamowienie.
     */
    @Test
    public void testSetIlosc() {
        System.out.println("setIlosc");
        int ilosc = 0;
        Towaryzamowienie instance = new Towaryzamowienie();
        instance.setIlosc(ilosc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     /**
     * Test of getKoszt method, of class Zamowienie.
     */
    @Test
    public void testGetKoszt() {
        System.out.println("getKoszt");
        Towaryzamowienie instance = new Towaryzamowienie();
        float expResult = 0.0F;
        float result = instance.getKoszt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKoszt method, of class Zamowienie.
     */
    @Test
    public void testSetKoszt() {
        System.out.println("setKoszt");
        float koszt = 0.0F;
        Towaryzamowienie instance = new Towaryzamowienie();
        instance.setKoszt(koszt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
