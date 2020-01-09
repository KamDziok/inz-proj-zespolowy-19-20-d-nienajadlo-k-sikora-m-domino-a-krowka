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
public class KlientTest {
    
    public KlientTest() {
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
     * Test of getKlientId method, of class Klient.
     */
    @Test
    public void testGetKlientId() {
        System.out.println("getKlientId");
        Klient instance = new Klient();
        Integer expResult = null;
        Integer result = instance.getKlientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKlientId method, of class Klient.
     */
    @Test
    public void testSetKlientId() {
        System.out.println("setKlientId");
        Integer klientId = null;
        Klient instance = new Klient();
        instance.setKlientId(klientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImie method, of class Klient.
     */
    @Test
    public void testGetImie() {
        System.out.println("getImie");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getImie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImie method, of class Klient.
     */
    @Test
    public void testSetImie() {
        System.out.println("setImie");
        String imie = "";
        Klient instance = new Klient();
        instance.setImie(imie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwisko method, of class Klient.
     */
    @Test
    public void testGetNazwisko() {
        System.out.println("getNazwisko");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getNazwisko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwisko method, of class Klient.
     */
    @Test
    public void testSetNazwisko() {
        System.out.println("setNazwisko");
        String nazwisko = "";
        Klient instance = new Klient();
        instance.setNazwisko(nazwisko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefon method, of class Klient.
     */
    @Test
    public void testGetTelefon() {
        System.out.println("getTelefon");
        Klient instance = new Klient();
        long expResult = 0L;
        long result = instance.getTelefon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefon method, of class Klient.
     */
    @Test
    public void testSetTelefon() {
        System.out.println("setTelefon");
        long telefon = 0L;
        Klient instance = new Klient();
        instance.setTelefon(telefon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class Klient.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class Klient.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        Klient instance = new Klient();
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Klient.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Klient instance = new Klient();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Klient.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Klient instance = new Klient();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdresies method, of class Klient.
     */
    @Test
    public void testGetAdresies() {
        System.out.println("getAdresies");
        Klient instance = new Klient();
        Set expResult = null;
        Set result = instance.getAdresies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdresies method, of class Klient.
     */
    @Test
    public void testSetAdresies() {
        System.out.println("setAdresies");
        Set adresies = null;
        Klient instance = new Klient();
        instance.setAdresies(adresies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
