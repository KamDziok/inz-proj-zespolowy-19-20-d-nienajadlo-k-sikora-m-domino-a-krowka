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
public class KsiegowoscTest {
    
    public KsiegowoscTest() {
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
     * Test of getKsiegowoscId method, of class Ksiegowosc.
     */
    @Test
    public void testGetKsiegowoscId() {
        System.out.println("getKsiegowoscId");
        Ksiegowosc instance = new Ksiegowosc();
        Integer expResult = null;
        Integer result = instance.getKsiegowoscId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKsiegowoscId method, of class Ksiegowosc.
     */
    @Test
    public void testSetKsiegowoscId() {
        System.out.println("setKsiegowoscId");
        Integer ksiegowoscId = null;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setKsiegowoscId(ksiegowoscId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHurtownia method, of class Ksiegowosc.
     */
    @Test
    public void testGetHurtownia() {
        System.out.println("getHurtownia");
        Ksiegowosc instance = new Ksiegowosc();
        Hurtownia expResult = null;
        Hurtownia result = instance.getHurtownia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHurtownia method, of class Ksiegowosc.
     */
    @Test
    public void testSetHurtownia() {
        System.out.println("setHurtownia");
        Hurtownia hurtownia = null;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setHurtownia(hurtownia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Ksiegowosc.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Ksiegowosc instance = new Ksiegowosc();
        Date expResult = null;
        Date result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Ksiegowosc.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrzychody method, of class Ksiegowosc.
     */
    @Test
    public void testGetPrzychody() {
        System.out.println("getPrzychody");
        Ksiegowosc instance = new Ksiegowosc();
        float expResult = 0.0F;
        float result = instance.getPrzychody();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrzychody method, of class Ksiegowosc.
     */
    @Test
    public void testSetPrzychody() {
        System.out.println("setPrzychody");
        float przychody = 0.0F;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setPrzychody(przychody);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKoszty method, of class Ksiegowosc.
     */
    @Test
    public void testGetKoszty() {
        System.out.println("getKoszty");
        Ksiegowosc instance = new Ksiegowosc();
        float expResult = 0.0F;
        float result = instance.getKoszty();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKoszty method, of class Ksiegowosc.
     */
    @Test
    public void testSetKoszty() {
        System.out.println("setKoszty");
        float koszty = 0.0F;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setKoszty(koszty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAktywa method, of class Ksiegowosc.
     */
    @Test
    public void testGetAktywa() {
        System.out.println("getAktywa");
        Ksiegowosc instance = new Ksiegowosc();
        float expResult = 0.0F;
        float result = instance.getAktywa();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAktywa method, of class Ksiegowosc.
     */
    @Test
    public void testSetAktywa() {
        System.out.println("setAktywa");
        float aktywa = 0.0F;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setAktywa(aktywa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasywa method, of class Ksiegowosc.
     */
    @Test
    public void testGetPasywa() {
        System.out.println("getPasywa");
        Ksiegowosc instance = new Ksiegowosc();
        float expResult = 0.0F;
        float result = instance.getPasywa();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPasywa method, of class Ksiegowosc.
     */
    @Test
    public void testSetPasywa() {
        System.out.println("setPasywa");
        float pasywa = 0.0F;
        Ksiegowosc instance = new Ksiegowosc();
        instance.setPasywa(pasywa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
