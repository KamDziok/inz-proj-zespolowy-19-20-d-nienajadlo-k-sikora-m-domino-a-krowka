/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Date;
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
public class WyplatyTest {
    
    public WyplatyTest() {
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
     * Test of getWyplataId method, of class Wyplaty.
     */
    @Test
    public void testGetWyplataId() {
        System.out.println("getWyplataId");
        Wyplaty instance = new Wyplaty();
        Integer expResult = null;
        Integer result = instance.getWyplataId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWyplataId method, of class Wyplaty.
     */
    @Test
    public void testSetWyplataId() {
        System.out.println("setWyplataId");
        Integer wyplataId = null;
        Wyplaty instance = new Wyplaty();
        instance.setWyplataId(wyplataId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPracownik method, of class Wyplaty.
     */
    @Test
    public void testGetPracownik() {
        System.out.println("getPracownik");
        Wyplaty instance = new Wyplaty();
        Pracownik expResult = null;
        Pracownik result = instance.getPracownik();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPracownik method, of class Wyplaty.
     */
    @Test
    public void testSetPracownik() {
        System.out.println("setPracownik");
        Pracownik pracownik = null;
        Wyplaty instance = new Wyplaty();
        instance.setPracownik(pracownik);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Wyplaty.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Wyplaty instance = new Wyplaty();
        Date expResult = null;
        Date result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Wyplaty.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        Wyplaty instance = new Wyplaty();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKwota method, of class Wyplaty.
     */
    @Test
    public void testGetKwota() {
        System.out.println("getKwota");
        Wyplaty instance = new Wyplaty();
        float expResult = 0.0F;
        float result = instance.getKwota();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKwota method, of class Wyplaty.
     */
    @Test
    public void testSetKwota() {
        System.out.println("setKwota");
        float kwota = 0.0F;
        Wyplaty instance = new Wyplaty();
        instance.setKwota(kwota);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
