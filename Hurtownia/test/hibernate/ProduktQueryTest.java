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
public class ProduktQueryTest {
    
    public ProduktQueryTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdukt method, of class ProduktQuery.
     */
    @Test
    public void testGetProdukt() {
        System.out.println("getProdukt");
        int ProduktID = 0;
        ProduktQuery instance = new ProduktQuery();
        Produkty expResult = null;
        Produkty result = instance.getProdukt(ProduktID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProduktySelectAll method, of class ProduktQuery.
     */
    @Test
    public void testProduktySelectAll() {
        System.out.println("ProduktySelectAll");
        ProduktQuery instance = new ProduktQuery();
        List<Produkty> expResult = null;
        List<Produkty> result = instance.ProduktySelectAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of produktySelectAllOnID method, of class ProduktQuery.
     */
    @Test
    public void testProduktySelectAllOnID() {
        System.out.println("produktySelectAllOnID");
        int id = 0;
        ProduktQuery instance = new ProduktQuery();
        List<Produkty> expResult = null;
        List<Produkty> result = instance.produktySelectAllOnID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
