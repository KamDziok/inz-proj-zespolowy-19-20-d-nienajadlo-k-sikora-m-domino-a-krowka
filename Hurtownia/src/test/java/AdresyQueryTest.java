/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hurtownia.hibernate.Adresy;
import hurtownia.hibernate.AdresyQuery;
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
public class AdresyQueryTest {
    
    public AdresyQueryTest() {
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
     * Test of dodajAdres method, of class AdresyQuery.
     * @author Karol
     */
    @Test
    public void testDodajAdres() {
        System.out.println("dodajAdres");
        int klientID = 0;
        String kraj = "Polska";
        String miasto = "Rzeszów";
        String ulica = "Cicha";
        String numerBudynku = "2";
        String numerLokalu = "603";
        String email = "email@wp.pl";
        AdresyQuery instance = new AdresyQuery();
        instance.dodajAdres(klientID, kraj, miasto, ulica, numerBudynku, numerLokalu, email);
    }

    /**
     * Test of wyszukanie method, of class AdresyQuery.
     * @author Dawid
     */
    @Test
    public void testWyszukanie() {
        System.out.println("wyszukanie");
        String email = "myHurt@gmail.com";
        AdresyQuery instance = new AdresyQuery();
        Adresy result = instance.wyszukanie(email);
        assertEquals(result.getEmail(), email);
    }

    /**
     * Test of wyswietlAdres method, of class AdresyQuery.
     * @author Dawid
     */
    @Test
    public void testWyswietlAdres() {
        System.out.println("wyswietlAdres");
        int klientID = 2;
        AdresyQuery instance = new AdresyQuery();
        Adresy result = instance.wyswietlAdres(klientID);
        assertEquals("myHurt@gmail.com", result.getEmail());
    }
    
}
