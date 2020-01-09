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
public class PracownikTest {
    
    public PracownikTest() {
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
     * Test of getPracownikId method, of class Pracownik.
     */
    @Test
    public void testGetPracownikId() {
        System.out.println("getPracownikId");
        Pracownik instance = new Pracownik();
        Integer expResult = null;
        Integer result = instance.getPracownikId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPracownikId method, of class Pracownik.
     */
    @Test
    public void testSetPracownikId() {
        System.out.println("setPracownikId");
        Integer pracownikId = null;
        Pracownik instance = new Pracownik();
        instance.setPracownikId(pracownikId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImie method, of class Pracownik.
     */
    @Test
    public void testGetImie() {
        System.out.println("getImie");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getImie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImie method, of class Pracownik.
     */
    @Test
    public void testSetImie() {
        System.out.println("setImie");
        String imie = "";
        Pracownik instance = new Pracownik();
        instance.setImie(imie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwisko method, of class Pracownik.
     */
    @Test
    public void testGetNazwisko() {
        System.out.println("getNazwisko");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getNazwisko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwisko method, of class Pracownik.
     */
    @Test
    public void testSetNazwisko() {
        System.out.println("setNazwisko");
        String nazwisko = "";
        Pracownik instance = new Pracownik();
        instance.setNazwisko(nazwisko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlaca method, of class Pracownik.
     */
    @Test
    public void testGetPlaca() {
        System.out.println("getPlaca");
        Pracownik instance = new Pracownik();
        float expResult = 0.0F;
        float result = instance.getPlaca();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlaca method, of class Pracownik.
     */
    @Test
    public void testSetPlaca() {
        System.out.println("setPlaca");
        float placa = 0.0F;
        Pracownik instance = new Pracownik();
        instance.setPlaca(placa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStanowisko method, of class Pracownik.
     */
    @Test
    public void testGetStanowisko() {
        System.out.println("getStanowisko");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getStanowisko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStanowisko method, of class Pracownik.
     */
    @Test
    public void testSetStanowisko() {
        System.out.println("setStanowisko");
        String stanowisko = "";
        Pracownik instance = new Pracownik();
        instance.setStanowisko(stanowisko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class Pracownik.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class Pracownik.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        Pracownik instance = new Pracownik();
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Pracownik.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Pracownik instance = new Pracownik();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Pracownik.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Pracownik instance = new Pracownik();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWyplaties method, of class Pracownik.
     */
    @Test
    public void testGetWyplaties() {
        System.out.println("getWyplaties");
        Pracownik instance = new Pracownik();
        Set expResult = null;
        Set result = instance.getWyplaties();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWyplaties method, of class Pracownik.
     */
    @Test
    public void testSetWyplaties() {
        System.out.println("setWyplaties");
        Set wyplaties = null;
        Pracownik instance = new Pracownik();
        instance.setWyplaties(wyplaties);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
