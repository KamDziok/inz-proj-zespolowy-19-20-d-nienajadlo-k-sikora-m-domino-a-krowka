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
 * @author Karol
 */
public class KlientQueryTest {
    
    public KlientQueryTest() {
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
     * Test of selecyByLoginandPassword method, of class KlientQuery.
     */
    @Test
    public void testSelecyByLoginandPassword() {
        System.out.println("selecyByLoginandPassword");
        String login = "";
        String password = "";
        KlientQuery instance = new KlientQuery();
        boolean expResult = false;
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectByLoginandPassword method, of class KlientQuery.
     */
    @Test
    public void testSelectByLoginandPassword() {
        System.out.println("selectByLoginandPassword");
        String login = "";
        String password = "";
        KlientQuery instance = new KlientQuery();
        Klient expResult = null;
        Klient result = instance.selectByLoginandPassword(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rejestracja method, of class KlientQuery.
     */
    @Test
    public void testRejestracja() {
        System.out.println("rejestracja");
        String imie = "";
        String nazwisko = "";
        long telefon = 0L;
        String login = "";
        String haslo = "";
        KlientQuery instance = new KlientQuery();
        instance.rejestracja(imie, nazwisko, telefon, login, haslo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class KlientQuery.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String login = "";
        String password = "";
        KlientQuery instance = new KlientQuery();
        instance.changePassword(login, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wyszukiwanie method, of class KlientQuery.
     */
    @Test
    public void testWyszukiwanie() {
        System.out.println("wyszukiwanie");
        String login = "";
        KlientQuery instance = new KlientQuery();
        Klient expResult = null;
        Klient result = instance.wyszukiwanie(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeAddress method, of class KlientQuery.
     */
    @Test
    public void testChangeAddress() throws Exception {
        System.out.println("changeAddress");
        Klient client = null;
        String country = "";
        String city = "";
        String street = "";
        String buildingNr = "";
        String localNumber = "";
        String email = "";
        KlientQuery instance = new KlientQuery();
        instance.changeAddress(client, country, city, street, buildingNr, localNumber, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
