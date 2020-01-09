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
public class ProduktyTest {
    
    public ProduktyTest() {
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
     * Test of getProduktId method, of class Produkty.
     */
    @Test
    public void testGetProduktId() {
        System.out.println("getProduktId");
        Produkty instance = new Produkty();
        Integer expResult = null;
        Integer result = instance.getProduktId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProduktId method, of class Produkty.
     */
    @Test
    public void testSetProduktId() {
        System.out.println("setProduktId");
        Integer produktId = null;
        Produkty instance = new Produkty();
        instance.setProduktId(produktId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKategorie method, of class Produkty.
     */
    @Test
    public void testGetKategorie() {
        System.out.println("getKategorie");
        Produkty instance = new Produkty();
        Kategorie expResult = null;
        Kategorie result = instance.getKategorie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKategorie method, of class Produkty.
     */
    @Test
    public void testSetKategorie() {
        System.out.println("setKategorie");
        Kategorie kategorie = null;
        Produkty instance = new Produkty();
        instance.setKategorie(kategorie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwa method, of class Produkty.
     */
    @Test
    public void testGetNazwa() {
        System.out.println("getNazwa");
        Produkty instance = new Produkty();
        String expResult = "";
        String result = instance.getNazwa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwa method, of class Produkty.
     */
    @Test
    public void testSetNazwa() {
        System.out.println("setNazwa");
        String nazwa = "";
        Produkty instance = new Produkty();
        instance.setNazwa(nazwa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCenaKupna method, of class Produkty.
     */
    @Test
    public void testGetCenaKupna() {
        System.out.println("getCenaKupna");
        Produkty instance = new Produkty();
        float expResult = 0.0F;
        float result = instance.getCenaKupna();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCenaKupna method, of class Produkty.
     */
    @Test
    public void testSetCenaKupna() {
        System.out.println("setCenaKupna");
        float cenaKupna = 0.0F;
        Produkty instance = new Produkty();
        instance.setCenaKupna(cenaKupna);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpis method, of class Produkty.
     */
    @Test
    public void testGetOpis() {
        System.out.println("getOpis");
        Produkty instance = new Produkty();
        String expResult = "";
        String result = instance.getOpis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOpis method, of class Produkty.
     */
    @Test
    public void testSetOpis() {
        System.out.println("setOpis");
        String opis = "";
        Produkty instance = new Produkty();
        instance.setOpis(opis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMagazyns method, of class Produkty.
     */
    @Test
    public void testGetMagazyns() {
        System.out.println("getMagazyns");
        Produkty instance = new Produkty();
        Set expResult = null;
        Set result = instance.getMagazyns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMagazyns method, of class Produkty.
     */
    @Test
    public void testSetMagazyns() {
        System.out.println("setMagazyns");
        Set magazyns = null;
        Produkty instance = new Produkty();
        instance.setMagazyns(magazyns);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTowaryzamowienies method, of class Produkty.
     */
    @Test
    public void testGetTowaryzamowienies() {
        System.out.println("getTowaryzamowienies");
        Produkty instance = new Produkty();
        Set expResult = null;
        Set result = instance.getTowaryzamowienies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTowaryzamowienies method, of class Produkty.
     */
    @Test
    public void testSetTowaryzamowienies() {
        System.out.println("setTowaryzamowienies");
        Set towaryzamowienies = null;
        Produkty instance = new Produkty();
        instance.setTowaryzamowienies(towaryzamowienies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
