/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.TaskData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

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
        TaskData instance = new TaskData("project title", new Date(), new Date());
        String expResult = "project title";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartString method, of class TaskData.
     */
    @Test
    public void testGetStartString()
    {
        Date d1 = new Date();
        System.out.println("getStartString");
        TaskData instance = new TaskData("", d1, new Date());
        String expResult = dateFormat.format(d1);
        String result = instance.getStartString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class TaskData.
     */
    @Test
    public void testGetStartDate()
    {
        Date d1 = new Date();
        System.out.println("getStartDate");
        TaskData instance = new TaskData("", d1, new Date());
        Date expResult = d1;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndString method, of class TaskData.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetEndString() throws ParseException
    {
        System.out.println("getEndString");
        TaskData instance = new TaskData(null, null, "10.10.2012");
        String expResult = "10.10.2012";
        String result = instance.getEndString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndDate method, of class TaskData.
     */
    @Test
    public void testGetEndDate()
    {
        Date d1 = new Date();
        System.out.println("getEndDate");
        TaskData instance = new TaskData("", new Date(), d1);
        Date expResult = d1;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHoursBetween method, of class TaskData.
     */
    @Test
    public void testGetHoursBetween()
    {
        System.out.println("getHoursBetween");
        TaskData instance = new TaskData("", new Date(), new Date());
        long expResult = 0L;
        long result = instance.getHoursBetween();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class TaskData.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "project name";
        TaskData instance = new TaskData(name, new Date(), null);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of setStartDate method, of class TaskData.
     */
    @Test
    public void testSetStartDate_String()
    {
        System.out.println("setStartDate");
        String startDate = "10.10.2010";
        TaskData instance;
        try
        {
            instance = new TaskData("", startDate, null);
            instance.setStartDate(startDate);
        }
        catch (ParseException exp)
        {
            fail("unable to set start date as string -> exception: " + exp.toString());
        }
    }

    /**
     * Test of setStartDate method, of class TaskData.
     */
    @Test
    public void testSetStartDate_Date()
    {
        System.out.println("setStartDate");
        Date startDate = new Date();
        TaskData instance = new TaskData("", startDate, null);
        instance.setStartDate(startDate);
        assertEquals(startDate, instance.getStartDate());
    }

    /**
     * Test of setEndDate method, of class TaskData.
     */
    @Test
    public void testSetEndDate_String()
    {
        try
        {
            System.out.println("setEndDate");
            String endDate = "10.10.2012";
            TaskData instance = new TaskData("", null, endDate);
            instance.setEndDate(endDate);
            instance = new TaskData("", endDate, null);
            instance.setStartDate(endDate);
        }
        catch (ParseException exp)
        {
            fail("unable to set start date as string -> exception: " + exp.toString());
        }
    }

    /**
     * Test of setEndDate method, of class TaskData.
     */
    @Test
    public void testSetEndDate_Date()
    {
        System.out.println("setEndDate");
        Date endDate = new Date();
        TaskData instance = new TaskData("", null, endDate);
        instance.setEndDate(endDate);
        assertEquals(endDate, instance.getStartDate());
    }

}
