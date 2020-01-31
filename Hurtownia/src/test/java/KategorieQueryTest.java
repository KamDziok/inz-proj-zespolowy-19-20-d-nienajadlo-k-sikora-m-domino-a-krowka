/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hurtownia.hibernate.Kategorie;
import hurtownia.hibernate.KategorieQuery;
import java.util.List;
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
public class KategorieQueryTest {
    
    public KategorieQueryTest() {
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
     * Test of KategorieSelectAll method, of class KategorieQuery.
     * @author Dawid
     */
    @Test
    public void testKategorieSelectAll() {
        System.out.println("KategorieSelectAll");
        KategorieQuery instance = new KategorieQuery();
        List<Kategorie> result = instance.KategorieSelectAll();
        assertNotNull(result);
    }
    
}
