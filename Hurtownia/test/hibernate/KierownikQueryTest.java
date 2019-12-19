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
        fail("The test case is a prototype.");
    }
    
}
