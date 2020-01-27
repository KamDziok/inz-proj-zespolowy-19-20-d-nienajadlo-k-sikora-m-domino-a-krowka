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
 * @author karol
 */
public class WyplatyQueryTest {
    
    public WyplatyQueryTest() {
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
     * Test of WyplatySelectAll method, of class WyplatyQuery.
     * @author Dawid
     */
    @Test
    public void testWyplatySelectAll() {
        System.out.println("WyplatySelectAll");
        WyplatyQuery instance = new WyplatyQuery();
        List<Wyplaty> result = instance.WyplatySelectAll();
        assertNull(result);
    }
    
}
