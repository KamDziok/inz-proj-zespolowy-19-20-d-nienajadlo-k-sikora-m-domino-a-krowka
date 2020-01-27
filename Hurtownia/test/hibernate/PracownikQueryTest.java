/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
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
public class PracownikQueryTest {
    
    public PracownikQueryTest() {
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
     * @author Dawid
     */
    
    @Before
    public void changeTestPasswordToDefaultValue(){
        PracownikQuery instance = new PracownikQuery();
        String login = "kierownik";
        String password = "kierownik";
        instance.changePassword(login, password);
        instance.dodanieDanych("ksiegowa", "ksiegowa", 8);
    }

    /**
     * Test of selecyByLoginandPassword method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testSelecyByLoginandPassword() {
        System.out.println("selecyByLoginandPassword");
        String login = "kierownik";
        String password = "kierownik";
        PracownikQuery instance = new PracownikQuery();
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertTrue(result);
    }

    /**
     * Test of selectByLoginandPassword method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testSelectByLoginandPassword() {
        System.out.println("selectByLoginandPassword");
        String login = "kierownik";
        String password = "kierownik";
        PracownikQuery instance = new PracownikQuery();
        Pracownik expResult = new Pracownik();
        expResult.setLogin(login);
        Pracownik result = instance.selectByLoginandPassword(login, password);
        assertEquals(expResult.getLogin(), result.getLogin());
    }

    /**
     * Test of wyszukiwanie method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testWyszukiwanie() {
        System.out.println("wyszukiwanie");
        String login = "kierownik";
        PracownikQuery instance = new PracownikQuery();
        Pracownik expResult = new Pracownik();
        expResult.setLogin(login);
        Pracownik result = instance.wyszukiwanie(login);
        assertEquals(expResult.getLogin(), result.getLogin());
    }

    /**
     * Test of changePassword method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String login = "kierownik";
        String password = "kierownik1";
        PracownikQuery instance = new PracownikQuery();
        instance.changePassword(login, password);
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertTrue(result);
    }

    /**
     * Test of PracownikSelectAll method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testPracownikSelectAll() {
        System.out.println("PracownikSelectAll");
        PracownikQuery instance = new PracownikQuery();
        List<Pracownik> result = instance.PracownikSelectAll();
        assertNotNull(result);
    }
 
    /**
     * Test of wyszukiwanieID method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testWyszukiwanieID() {
        System.out.println("wyszukiwanieID");
        int id = 3;
        PracownikQuery instance = new PracownikQuery();
        Pracownik result = instance.wyszukiwanieID(id);
        assertNotNull(result);
    }

    /**
     * Test of wyszukanieZatrudnienie method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testWyszukanieZatrudnienie() {
        System.out.println("wyszukanieZatrudnienie");
        String nazwisko = "Jan";
        String imie = "Kowalski";
        PracownikQuery instance = new PracownikQuery();
        Pracownik result = instance.wyszukanieZatrudnienie(nazwisko, imie);
        assertNotNull(result);
    }

    /**
     * Test of dodanieDanych method, of class PracownikQuery.
     * @author Dawid
     */
    @Test
    public void testDodanieDanych() {
        System.out.println("dodanieDanych");
        String login = "test";
        String password = "test";
        int id = 8;
        PracownikQuery instance = new PracownikQuery();
        instance.dodanieDanych(login, password, id);
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertTrue(result);
    }
    
}
