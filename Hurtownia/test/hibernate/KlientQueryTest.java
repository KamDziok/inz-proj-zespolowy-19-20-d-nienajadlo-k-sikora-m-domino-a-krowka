/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
     * Setup before tests
     * 
     * @author Dawid
     * 
     */
   
    @Before
    public void changeTestPasswordToDefaultValue(){
        KlientQuery instance = new KlientQuery();
        String login = "jankowalski";
        String password = "jankowalski";
        instance.changePassword(login, password);
    }
    
    /**
     * @author Dawid
     * 
     * This method remove useless test user from database created in rejestracja test
     * 
     */
    
    @After
    public void cleanDatabaseAfterTesting() throws Exception{
          
        Session session = null;
        
        String query = "DELETE FROM `klient` WHERE `Imie` = \"Test\" "
                + "AND `Nazwisko` = \"Test\"";
        session = HibernateUtil.getSessionFactory().openSession();
          
          try {
              session.getTransaction().begin();
              session.createSQLQuery(query).executeUpdate();
              session.getTransaction().commit();
              session.close();
          } catch (HibernateException error) {
              session.getTransaction().rollback();
              session.close();
          }
          
          KlientQuery k = new KlientQuery();
          k.changeAddress(1, "PL", "Rzeszów", "Pigonia", "1", "1", "ur@stud.pl");
    }
    
     /**
     * Test of selecyByLoginandPassword method, of class KlientQuery.
     * @author Dawid
     */
    
    
    @Test
    public void testSelecyByLoginandPassword() {
        System.out.println("selecyByLoginandPassword");
        String login = "jankowalski";
        String password = "jankowalski";
        KlientQuery instance = new KlientQuery();
        boolean expResult = true;
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectByLoginandPassword method, of class KlientQuery.
     * @author Dawid
     */
    @Test
    public void testSelectByLoginandPassword() {
        System.out.println("selectByLoginandPassword");
        
        Klient k = new Klient();
        k.setLogin("jankowalski");
        k.setPassword("jankowalski");
        
        String login = "jankowalski";
        String password = "jankowalski";
        
        KlientQuery instance = new KlientQuery();
        Klient expResult = k;
        Klient result = instance.selectByLoginandPassword(login, password);
        assertEquals(expResult.getLogin(), result.getLogin());
    }

    /**
     * Test of rejestracja method, of class KlientQuery.
     * @author Dawid
     */
    @Test
    public void testRejestracja() {
        System.out.println("rejestracja");
        KlientQuery instance = new KlientQuery();
        String imie = "Test";
        String nazwisko = "Test";
        long telefon = 0L;
        String login = "testuser";
        String haslo = "testuser";
        instance.rejestracja(imie, nazwisko, telefon, login, haslo);
        boolean result = instance.selecyByLoginandPassword(login, haslo);
        assertTrue(result);
    }

    /**
     * Test of changePassword method, of class KlientQuery.
     * @author Dawid
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String login = "jankowalski";
        String password = "jankowalski1";
        KlientQuery instance = new KlientQuery();
        instance.changePassword(login, password);
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertTrue(result);
    }

    /**
     * Test of wyszukiwanie method, of class KlientQuery.
     * @author Dawid
     */
    @Test
    public void testWyszukiwanie() {
        System.out.println("wyszukiwanie");
        String login = "jankowalski";
        KlientQuery instance = new KlientQuery();
        Klient result = instance.wyszukiwanie(login);
        assertEquals(instance.wyszukiwanie(login).getLogin(), login);
    }

    /**
     * Test of changeAddress method, of class KlientQuery.
     * @author Dawid
     */
    @Test
    public void testChangeAddress() throws Exception {
        System.out.println("changeAddress");
        int id = 1;
        String country = "Russia";
        String city = "Novosybirsk";
        String street = "Gogol Street";
        String buildingNr = "1";
        String localNumber = "2";
        String email = "test@test.com";
        KlientQuery instance = new KlientQuery();
        instance.changeAddress(id, country, city, street, buildingNr, localNumber, email);
        AdresyQuery a = new AdresyQuery();
        String addressFromDB = a.wyswietlAdres(id).getKraj() + "," 
                + a.wyswietlAdres(id).getMiasto();
        String testAddress = country + "," + city;
        
        assertEquals(addressFromDB, testAddress);
    }
    
}
