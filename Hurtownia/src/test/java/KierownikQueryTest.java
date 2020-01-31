/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hurtownia.hibernate.KierownikQuery;
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
public class KierownikQueryTest {
    
    public KierownikQueryTest() {
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
     * Test of dodajPracownika method, of class KierownikQuery.
     */
    @Test
    public void testDodajPracownika() {
        System.out.println("dodajPracownika");
        String imie = "";
        String nazwisko = "";
        float placa = 0.0F;
        String stanowisko = "";
        KierownikQuery instance = new KierownikQuery();
        instance.dodajPracownika(imie, nazwisko, placa, stanowisko);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of zwolnijPracownika method, of class KierownikQuery.
     */
    @Test
    public void testZwolnijPracownika() {
        System.out.println("zwolnijPracownika");
        Integer pracownikId = null;
        KierownikQuery instance = new KierownikQuery();
        instance.zwolnijPracownika(pracownikId);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of dodajProdukt method, of class KierownikQuery.
     */
    @Test
    public void testDodajProdukt() {
        System.out.println("dodajProdukt");
        String Nazwa = "";
        float Cena = 0.0F;
        String Opis = "";
        int Kategoria = 0;
        KierownikQuery instance = new KierownikQuery();
        instance.dodajProdukt(Nazwa, Cena, Opis, Kategoria);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of dodajProduktNaMagazyn method, of class KierownikQuery.
     */
    @Test
    public void testDodajProduktNaMagazyn() {
        System.out.println("dodajProduktNaMagazyn");
        int ilosc = 0;
        float Cena = 0.0F;
        int ProduktID = 0;
        KierownikQuery instance = new KierownikQuery();
        instance.dodajProduktNaMagazyn(ilosc, Cena, ProduktID);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
