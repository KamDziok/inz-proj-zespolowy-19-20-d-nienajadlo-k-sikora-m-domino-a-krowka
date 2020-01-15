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
public class AdresyTest {
    
    public AdresyTest() {
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
     * Test of getAdresId method, of class Adresy.
     */
    @Test
    public void testGetAdresId() {
        System.out.println("getAdresId");
        Adresy instance = new Adresy();
        Integer expResult = null;
        Integer result = instance.getAdresId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdresId method, of class Adresy.
     */
    @Test
    public void testSetAdresId() {
        System.out.println("setAdresId");
        Integer adresId = null;
        Adresy instance = new Adresy();
        instance.setAdresId(adresId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKlient method, of class Adresy.
     */
    @Test
    public void testGetKlient() {
        System.out.println("getKlient");
        Adresy instance = new Adresy();
        Klient expResult = null;
        Klient result = instance.getKlient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKlient method, of class Adresy.
     */
    @Test
    public void testSetKlient() {
        System.out.println("setKlient");
        Klient klient = null;
        Adresy instance = new Adresy();
        instance.setKlient(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKraj method, of class Adresy.
     */
    @Test
    public void testGetKraj() {
        System.out.println("getKraj");
        Adresy instance = new Adresy();
        String expResult = "";
        String result = instance.getKraj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKraj method, of class Adresy.
     */
    @Test
    public void testSetKraj() {
        System.out.println("setKraj");
        String kraj = "";
        Adresy instance = new Adresy();
        instance.setKraj(kraj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMiasto method, of class Adresy.
     */
    @Test
    public void testGetMiasto() {
        System.out.println("getMiasto");
        Adresy instance = new Adresy();
        String expResult = "";
        String result = instance.getMiasto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMiasto method, of class Adresy.
     */
    @Test
    public void testSetMiasto() {
        System.out.println("setMiasto");
        String miasto = "";
        Adresy instance = new Adresy();
        instance.setMiasto(miasto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUlica method, of class Adresy.
     */
    @Test
    public void testGetUlica() {
        System.out.println("getUlica");
        Adresy instance = new Adresy();
        String expResult = "";
        String result = instance.getUlica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUlica method, of class Adresy.
     */
    @Test
    public void testSetUlica() {
        System.out.println("setUlica");
        String ulica = "";
        Adresy instance = new Adresy();
        instance.setUlica(ulica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumerBudynku method, of class Adresy.
     */
    @Test
    public void testGetNumerBudynku() {
        System.out.println("getNumerBudynku");
        Adresy instance = new Adresy();
        String expResult = "";
        String result = instance.getNumerBudynku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumerBudynku method, of class Adresy.
     */
    @Test
    public void testSetNumerBudynku() {
        System.out.println("setNumerBudynku");
        String numerBudynku = "";
        Adresy instance = new Adresy();
        instance.setNumerBudynku(numerBudynku);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumerLokalu method, of class Adresy.
     */
    @Test
    public void testGetNumerLokalu() {
        System.out.println("getNumerLokalu");
        Adresy instance = new Adresy();
        int expResult = 0;
        int result = instance.getNumerLokalu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumerLokalu method, of class Adresy.
     */
    @Test
    public void testSetNumerLokalu() {
        System.out.println("setNumerLokalu");
        int numerLokalu = 0;
        Adresy instance = new Adresy();
        instance.setNumerLokalu(numerLokalu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Adresy.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Adresy instance = new Adresy();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Adresy.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Adresy instance = new Adresy();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHurtownias method, of class Adresy.
     */
    @Test
    public void testGetHurtownias() {
        System.out.println("getHurtownias");
        Adresy instance = new Adresy();
        Set expResult = null;
        Set result = instance.getHurtownias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHurtownias method, of class Adresy.
     */
    @Test
    public void testSetHurtownias() {
        System.out.println("setHurtownias");
        Set hurtownias = null;
        Adresy instance = new Adresy();
        instance.setHurtownias(hurtownias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
