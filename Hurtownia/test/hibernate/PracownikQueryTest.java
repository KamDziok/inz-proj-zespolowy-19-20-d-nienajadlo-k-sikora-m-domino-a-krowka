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
     * Test of selecyByLoginandPassword method, of class PracownikQuery.
     */
    @Test
    public void testSelecyByLoginandPassword() {
        System.out.println("selecyByLoginandPassword");
        String login = "";
        String password = "";
        PracownikQuery instance = new PracownikQuery();
        boolean expResult = false;
        boolean result = instance.selecyByLoginandPassword(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectByLoginandPassword method, of class PracownikQuery.
     */
    @Test
    public void testSelectByLoginandPassword() {
        System.out.println("selectByLoginandPassword");
        String login = "";
        String password = "";
        PracownikQuery instance = new PracownikQuery();
        Pracownik expResult = null;
        Pracownik result = instance.selectByLoginandPassword(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wyszukiwanie method, of class PracownikQuery.
     */
    @Test
    public void testWyszukiwanie() {
        System.out.println("wyszukiwanie");
        String login = "";
        PracownikQuery instance = new PracownikQuery();
        Pracownik expResult = null;
        Pracownik result = instance.wyszukiwanie(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class PracownikQuery.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String login = "";
        String password = "";
        PracownikQuery instance = new PracownikQuery();
        instance.changePassword(login, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PracownikSelectAll method, of class PracownikQuery.
     */
    @Test
    public void testPracownikSelectAll() {
        System.out.println("PracownikSelectAll");
        PracownikQuery instance = new PracownikQuery();
        List<Pracownik> expResult = null;
        List<Pracownik> result = instance.PracownikSelectAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeProductQuantity method, of class PracownikQuery.
     */
    @Test
    public void testChangeProductQuantity() throws Exception {
        System.out.println("changeProductQuantity");
        int storageId = 0;
        int quantity = 0;
        int productId = 0;
        int wholesaleId = 0;
        PracownikQuery instance = new PracownikQuery();
        instance.changeProductQuantity(storageId, quantity, productId, wholesaleId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewProduct method, of class PracownikQuery.
     */
    @Test
    public void testAddNewProduct() throws Exception {
        System.out.println("addNewProduct");
        int productID = 0;
        String productName = "";
        double productPrice = 0.0;
        String productDescription = "";
        int categoryID = 0;
        PracownikQuery instance = new PracownikQuery();
        instance.addNewProduct(productID, productName, productPrice, productDescription, categoryID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewAdvert method, of class PracownikQuery.
     */
    @Test
    public void testAddNewAdvert() throws Exception {
        System.out.println("addNewAdvert");
        int ReklamaID = 0;
        String tytul = "";
        String data = "";
        String opis = "";
        String grafikaURL = "";
        PracownikQuery instance = new PracownikQuery();
        int ProduktID = 0;
        instance.addNewAdvert(ReklamaID,ProduktID, tytul, data, opis, grafikaURL);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAdvert method, of class PracownikQuery.
     */
    @Test
    public void testRemoveAdvert() throws Exception {
        System.out.println("removeAdvert");
        int ReklamaID = 0;
        PracownikQuery instance = new PracownikQuery();
        instance.removeAdvert(ReklamaID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
