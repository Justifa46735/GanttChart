/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ganttchart.TaskData;
import java.io.File;
import java.util.Date;
import java.util.List;
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
public class DataModelTest
{
    
    public DataModelTest()
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
     * Test of addTask method, of class DataModel.
     */
    @Test
    public void testAddTask()
    {
        System.out.println("addTask");
        TaskData new_task = null;
        DataModel instance = new DataModel();
        instance.addTask(new_task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class DataModel.
     */
    @Test
    public void testRemoveTask()
    {
        System.out.println("removeTask");
        TaskData old_task = null;
        DataModel instance = new DataModel();
        instance.removeTask(old_task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyTask method, of class DataModel.
     */
    @Test
    public void testModifyTask_4args_1()
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "";
        Date start = null;
        Date end = null;
        DataModel instance = new DataModel();
        instance.modifyTask(index, name, start, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyTask method, of class DataModel.
     */
    @Test
    public void testModifyTask_4args_2() throws Exception
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "";
        String start = "";
        String end = "";
        DataModel instance = new DataModel();
        instance.modifyTask(index, name, start, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskArray method, of class DataModel.
     */
    @Test
    public void testGetTaskArray()
    {
        System.out.println("getTaskArray");
        DataModel instance = new DataModel();
        List<TaskData> expResult = null;
        List<TaskData> result = instance.getTaskArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFile method, of class DataModel.
     */
    @Test
    public void testSaveFile() throws Exception
    {
        System.out.println("saveFile");
        File xmlFile = null;
        DataModel instance = new DataModel();
        instance.saveFile(xmlFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openFile method, of class DataModel.
     */
    @Test
    public void testOpenFile() throws Exception
    {
        System.out.println("openFile");
        File xmlFile = null;
        DataModel instance = new DataModel();
        instance.openFile(xmlFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
