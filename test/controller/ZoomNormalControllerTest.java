/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class ZoomNormalControllerTest
{
    
    public ZoomNormalControllerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of registerEvents method, of class ZoomNormalController.
     */
    @Test
    public void testRegisterEvents()
    {
        System.out.println("registerEvents");
        ZoomNormalController instance = null;
        instance.registerEvents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class ZoomNormalController.
     */
    @Test
    public void testActionPerformed()
    {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ZoomNormalController instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}