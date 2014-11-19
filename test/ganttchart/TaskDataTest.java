/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganttchart;

import java.util.Date;
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
public class TaskDataTest
{
    
    public TaskDataTest()
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
     * Test of getName method, of class TaskData.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        TaskData instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartString method, of class TaskData.
     */
    @Test
    public void testGetStartString()
    {
        System.out.println("getStartString");
        TaskData instance = null;
        String expResult = "";
        String result = instance.getStartString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class TaskData.
     */
    @Test
    public void testGetStartDate()
    {
        System.out.println("getStartDate");
        TaskData instance = null;
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndString method, of class TaskData.
     */
    @Test
    public void testGetEndString()
    {
        System.out.println("getEndString");
        TaskData instance = null;
        String expResult = "";
        String result = instance.getEndString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class TaskData.
     */
    @Test
    public void testGetEndDate()
    {
        System.out.println("getEndDate");
        TaskData instance = null;
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoursBetween method, of class TaskData.
     */
    @Test
    public void testGetHoursBetween()
    {
        System.out.println("getHoursBetween");
        TaskData instance = null;
        long expResult = 0L;
        long result = instance.getHoursBetween();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class TaskData.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "";
        TaskData instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class TaskData.
     */
    @Test
    public void testSetStartDate_String() throws Exception
    {
        System.out.println("setStartDate");
        String startDate = "";
        TaskData instance = null;
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class TaskData.
     */
    @Test
    public void testSetStartDate_Date()
    {
        System.out.println("setStartDate");
        Date startDate = null;
        TaskData instance = null;
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class TaskData.
     */
    @Test
    public void testSetEndDate_String() throws Exception
    {
        System.out.println("setEndDate");
        String endDate = "";
        TaskData instance = null;
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class TaskData.
     */
    @Test
    public void testSetEndDate_Date()
    {
        System.out.println("setEndDate");
        Date endDate = null;
        TaskData instance = null;
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
