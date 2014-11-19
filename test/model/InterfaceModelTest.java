/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ganttchart.TaskData;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
public class InterfaceModelTest
{
    
    public InterfaceModelTest()
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
     * Test of setProjektName method, of class InterfaceModel.
     */
    @Test
    public void testSetProjektName()
    {
        System.out.println("setProjektName");
        String projektName = "";
        InterfaceModel instance = new InterfaceModelImpl();
        instance.setProjektName(projektName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjektName method, of class InterfaceModel.
     */
    @Test
    public void testGetProjektName()
    {
        System.out.println("getProjektName");
        InterfaceModel instance = new InterfaceModelImpl();
        String expResult = "";
        String result = instance.getProjektName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDataSaved method, of class InterfaceModel.
     */
    @Test
    public void testIsDataSaved()
    {
        System.out.println("isDataSaved");
        InterfaceModel instance = new InterfaceModelImpl();
        boolean expResult = false;
        boolean result = instance.isDataSaved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataSaved method, of class InterfaceModel.
     */
    @Test
    public void testSetDataSaved()
    {
        System.out.println("setDataSaved");
        InterfaceModel instance = new InterfaceModelImpl();
        instance.setDataSaved();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataChanged method, of class InterfaceModel.
     */
    @Test
    public void testDataChanged()
    {
        System.out.println("dataChanged");
        InterfaceModel instance = new InterfaceModelImpl();
        instance.dataChanged();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class InterfaceModel.
     */
    @Test
    public void testAddTask()
    {
        System.out.println("addTask");
        TaskData new_task = null;
        InterfaceModel instance = new InterfaceModelImpl();
        instance.addTask(new_task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class InterfaceModel.
     */
    @Test
    public void testRemoveTask()
    {
        System.out.println("removeTask");
        TaskData old_task = null;
        InterfaceModel instance = new InterfaceModelImpl();
        instance.removeTask(old_task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyTask method, of class InterfaceModel.
     */
    @Test
    public void testModifyTask_4args_1()
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "";
        Date start = null;
        Date end = null;
        InterfaceModel instance = new InterfaceModelImpl();
        instance.modifyTask(index, name, start, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyTask method, of class InterfaceModel.
     */
    @Test
    public void testModifyTask_4args_2() throws Exception
    {
        System.out.println("modifyTask");
        int index = 0;
        String name = "";
        String start = "";
        String end = "";
        InterfaceModel instance = new InterfaceModelImpl();
        instance.modifyTask(index, name, start, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskArray method, of class InterfaceModel.
     */
    @Test
    public void testGetTaskArray()
    {
        System.out.println("getTaskArray");
        InterfaceModel instance = new InterfaceModelImpl();
        List<TaskData> expResult = null;
        List<TaskData> result = instance.getTaskArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFile method, of class InterfaceModel.
     */
    @Test
    public void testSaveFile() throws Exception
    {
        System.out.println("saveFile");
        File xmlFile = null;
        InterfaceModel instance = new InterfaceModelImpl();
        instance.saveFile(xmlFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openFile method, of class InterfaceModel.
     */
    @Test
    public void testOpenFile() throws Exception
    {
        System.out.println("openFile");
        File xmlFile = null;
        InterfaceModel instance = new InterfaceModelImpl();
        instance.openFile(xmlFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InterfaceModelImpl
            extends InterfaceModel
    {
        public void addTask(TaskData new_task)
        {
        }

        public void removeTask(TaskData old_task)
        {
        }

        public void modifyTask(int index, String name, Date start, Date end)
        {
        }

        public void modifyTask(int index, String name, String start, String end) throws ParseException
        {
        }

        public List<TaskData> getTaskArray()
        {
            return null;
        }

        public void saveFile(File xmlFile) throws ParserConfigurationException, TransformerException
        {
        }

        public void openFile(File xmlFile) throws SAXException, IOException, ParserConfigurationException, ParseException
        {
        }

        @Override
        public String getVersion()
        {
            return "1.0.0";
        }
    }
    
}
