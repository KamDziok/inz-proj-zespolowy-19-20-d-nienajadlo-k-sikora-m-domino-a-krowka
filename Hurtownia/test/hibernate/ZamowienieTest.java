/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Date;
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
public class ZamowienieTest {
    
    public ZamowienieTest() {
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
     * Test of getZamowienieId method, of class Zamowienie.
     */
    @Test
    public void testGetZamowienieId() {
        System.out.println("getZamowienieId");
        Zamowienie instance = new Zamowienie();
        Integer expResult = null;
        Integer result = instance.getZamowienieId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZamowienieId method, of class Zamowienie.
     */
    @Test
    public void testSetZamowienieId() {
        System.out.println("setZamowienieId");
        Integer zamowienieId = null;
        Zamowienie instance = new Zamowienie();
        instance.setZamowienieId(zamowienieId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatusZaplaty method, of class Zamowienie.
     */
    @Test
    public void testGetStatusZaplaty() {
        System.out.println("getStatusZaplaty");
        Zamowienie instance = new Zamowienie();
        String expResult = "";
        String result = instance.getStatusZaplaty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusZaplaty method, of class Zamowienie.
     */
    @Test
    public void testSetStatusZaplaty() {
        System.out.println("setStatusZaplaty");
        String statusZaplaty = "";
        Zamowienie instance = new Zamowienie();
        instance.setStatusZaplaty(statusZaplaty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatusTransportu method, of class Zamowienie.
     */
    @Test
    public void testGetStatusTransportu() {
        System.out.println("getStatusTransportu");
        Zamowienie instance = new Zamowienie();
        String expResult = "";
        String result = instance.getStatusTransportu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusTransportu method, of class Zamowienie.
     */
    @Test
    public void testSetStatusTransportu() {
        System.out.println("setStatusTransportu");
        String statusTransportu = "";
        Zamowienie instance = new Zamowienie();
        instance.setStatusTransportu(statusTransportu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Zamowienie.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Zamowienie instance = new Zamowienie();
        Date expResult = null;
        Date result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Zamowienie.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        Zamowienie instance = new Zamowienie();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKoszt method, of class Zamowienie.
     */
    @Test
    public void testGetKoszt() {
        System.out.println("getKoszt");
        Zamowienie instance = new Zamowienie();
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
        Zamowienie instance = new Zamowienie();
        instance.setKoszt(koszt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTowaryzamowienies method, of class Zamowienie.
     */
    @Test
    public void testGetTowaryzamowienies() {
        System.out.println("getTowaryzamowienies");
        Zamowienie instance = new Zamowienie();
        Set expResult = null;
        Set result = instance.getTowaryzamowienies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTowaryzamowienies method, of class Zamowienie.
     */
    @Test
    public void testSetTowaryzamowienies() {
        System.out.println("setTowaryzamowienies");
        Set towaryzamowienies = null;
        Zamowienie instance = new Zamowienie();
        instance.setTowaryzamowienies(towaryzamowienies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
