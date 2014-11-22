/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.UpdateDataCntrl;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observer;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;

/**
 *
 * @author lenovo
 */
public class DataModelTest
{
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

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
        TaskData new_task = new TaskData(null, new Date(), null);
        DataModel instance = new DataModel();
        instance.addTask(new_task);
    }

    /**
     * Test of removeTask method, of class DataModel.
     */
    @Test
    public void testRemoveTask()
    {
        System.out.println("removeTask");
        TaskData old_task = new TaskData(null, new Date(), null);
        DataModel instance = new DataModel();
        instance.addTask(old_task);
        instance.removeTask(old_task);
    }

    /**
     * Test of modifyTask method, of class DataModel.
     */
    @Test
    public void testModifyTask_4args_1()
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "project name";
        Date start = new Date();
        Date end = new Date(start.getTime() + 1000);
        DataModel instance = new DataModel();
        instance.addTask(new TaskData("", new Date(), null));
        instance.modifyTask(index, name, start, end);
        assertEquals(instance.getTaskArray().get(index).getName(), name);
        assertEquals(instance.getTaskArray().get(index).getStartDate(), start);
        assertEquals(instance.getTaskArray().get(index).getEndDate(), end);
    }

    /**
     * Test of modifyTask method, of class DataModel.
     */
    @Test
    public void testModifyTask_4args_2()
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "project name";
        String start = "10.10.2010";
        String end = "12.12.2012";
        DataModel instance = new DataModel();
        instance.addTask(new TaskData(null, new Date(), null));
        try
        {
            instance.modifyTask(index, name, start, end);
            assertEquals(instance.getTaskArray().get(index).getName(), name);
            assertEquals(instance.getTaskArray().get(index).getStartString(), start);
            assertEquals(instance.getTaskArray().get(index).getEndString(), end);
        }
        catch (ParseException exp)
        {
            fail("could not modify task: " + exp.toString());
        }
    }

    /**
     * Test of modifyTask method, of class DataModel.
     */
    @Test
    public void testModifyTask_4args_3()
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "new project";
        Date start = new Date();
        int dauer = 1000;
        DataModel instance = new DataModel();
        instance.addTask(new TaskData(null, new Date(), null));
        instance.modifyTask(index, name, start, dauer);
        assertEquals(instance.getTaskArray().get(index).getName(), name);
        assertEquals(instance.getTaskArray().get(index).getStartDate(), start);
        assertEquals(instance.getTaskArray().get(index).getEndDate().getTime(), start.getTime() + (long) (60.0 * 60.0 * 1000.0 * dauer));
    }

    /**
     * Test of modifyTask method, of class DataModel.
     */
    @Test
    public void testModifyTask_4args_4()
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "new project";
        String start = "10.10.2012";
        int dauer = 1000;
        DataModel instance = new DataModel();
        instance.addTask(new TaskData(null, new Date(), null));
        try
        {
            instance.modifyTask(index, name, start, dauer);
            assertEquals(instance.getTaskArray().get(index).getName(), name);
            assertEquals(instance.getTaskArray().get(index).getStartString(), start);
            String end = dateFormat.format(new Date(instance.getTaskArray().get(index).getStartDate().getTime() + (long) (60.0 * 60.0 * 1000.0 * dauer)));
            assertEquals(instance.getTaskArray().get(index).getEndString(), end);
        }
        catch (ParseException exp)
        {
            fail("coul not modify task " + exp.toString());
        }
    }

    /**
     * Test of getTaskArray method, of class DataModel.
     */
    @Test
    public void testGetTaskArray()
    {
        TaskData tsk = new TaskData(null, new Date(), null);
        System.out.println("getTaskArray");
        DataModel instance = new DataModel();
        List<TaskData> expResult = new ArrayList<>();
        instance.addTask(tsk);
        expResult.add(tsk);
        List<TaskData> result = instance.getTaskArray();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveFile method, of class DataModel.
     */
    @Test
    public void testSaveFile()
    {
        System.out.println("saveFile");
        File xmlFile = new File(System.getProperty("user.dir") + "/test.xml");
        DataModel instance = new DataModel();
        instance.addTask(new TaskData("task description one", new Date(), null));
        instance.addTask(new TaskData("task description two", new Date(), null));
        instance.addTask(new TaskData("task description three", new Date(), null));
        try
        {
            instance.saveFile(xmlFile);
        }
        catch (ParserConfigurationException | TransformerException exp)
        {
            fail("could not save xml file: " + exp.toString());
        }
    }

    /**
     * Test of openFile method, of class DataModel.
     */
    @Test
    public void testOpenFile()
    {
        System.out.println("openFile");
        File xmlFile = new File(System.getProperty("user.dir") + "/test.xml");
        DataModel instance = new DataModel();
        try
        {
            instance.openFile(xmlFile);
        }
        catch (SAXException | IOException | ParserConfigurationException | ParseException exp)
        {
            fail("could not parse xml file: " + exp.toString());
        }
    }

    /**
     * Test of getVersion method, of class DataModel.
     */
    @Test
    public void testGetVersion()
    {
        System.out.println("getVersion");
        DataModel instance = new DataModel();
        String expResult = "1.0.0";
        String result = instance.getVersion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjektName method, of class DataModel.
     */
    @Test
    public void testSetProjektName()
    {
        System.out.println("setProjectName");
        DataModel instance = new DataModel();
        String expResult = "no project name added";

        instance.setProjektName(null);
        String result = instance.getProjektName();
        assertEquals(expResult, result);

        instance.setProjektName("");
        result = instance.getProjektName();
        assertEquals(expResult, result);

        expResult = "mein new project";
        instance.setProjektName(expResult);
        result = instance.getProjektName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjektName method, of class DataModel.
     */
    @Test
    public void testGetProjektName()
    {
        System.out.println("getProjectName");
        DataModel instance = new DataModel();
        String expResult = "no project name added";
        String result = instance.getProjektName();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDataSaved method, of class DataModel.
     */
    @Test
    public void testIsDataSaved()
    {
        System.out.println("isDataSaved");
        DataModel instance = new DataModel();
        boolean expResult = false;
        boolean result = instance.isDataSaved();
        assertEquals(expResult, result);
    }

    /**
     * Test of clearData method, of class DataModel.
     */
    @Test
    public void testClearData()
    {
        System.out.println("clearData");
        DataModel instance = new DataModel();
        instance.addTask(new TaskData(null, new Date(), null));
        instance.addTask(new TaskData(null, new Date(), null));
        instance.addTask(new TaskData(null, null, new Date()));
        instance.addTask(new TaskData(null, null, new Date()));

        instance.clearData();
    }

    /**
     * Test of addBeobachter method, of class DataModel.
     */
    @Test
    public void testAddBeobachter()
    {
        System.out.println("addBeobachter");
        Observer obj = null;
        DataModel instance = new DataModel();
        instance.addBeobachter(obj);

        obj = new UpdateDataCntrl(null, instance);
        instance.addBeobachter(obj);
    }
}
