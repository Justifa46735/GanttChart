/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.IntervalCategoryDataset;
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
public class InterfaceViewTest
{
    
    public InterfaceViewTest()
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
     * Test of getChartPanel method, of class InterfaceView.
     */
    @Test
    public void testGetChartPanel()
    {
        System.out.println("getChartPanel");
        InterfaceView instance = new InterfaceViewImpl();
        ChartPanel expResult = null;
        ChartPanel result = instance.getChartPanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnZoomIn method, of class InterfaceView.
     */
    @Test
    public void testGetBtnZoomIn()
    {
        System.out.println("getBtnZoomIn");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnZoomIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnZoomOut method, of class InterfaceView.
     */
    @Test
    public void testGetBtnZoomOut()
    {
        System.out.println("getBtnZoomOut");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnZoomOut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnZoomNormal method, of class InterfaceView.
     */
    @Test
    public void testGetBtnZoomNormal()
    {
        System.out.println("getBtnZoomNormal");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnZoomNormal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuZoomNormal method, of class InterfaceView.
     */
    @Test
    public void testGetMnuZoomNormal()
    {
        System.out.println("getMnuZoomNormal");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuZoomNormal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuZoomOut method, of class InterfaceView.
     */
    @Test
    public void testGetMnuZoomOut()
    {
        System.out.println("getMnuZoomOut");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuZoomOut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuZoomIn method, of class InterfaceView.
     */
    @Test
    public void testGetMnuZoomIn()
    {
        System.out.println("getMnuZoomIn");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuZoomIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileChooser method, of class InterfaceView.
     */
    @Test
    public void testGetFileChooser()
    {
        System.out.println("getFileChooser");
        InterfaceView instance = new InterfaceViewImpl();
        JFileChooser expResult = null;
        JFileChooser result = instance.getFileChooser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnAbbrechen method, of class InterfaceView.
     */
    @Test
    public void testGetBtnAbbrechen()
    {
        System.out.println("getBtnAbbrechen");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnAbbrechen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnSave method, of class InterfaceView.
     */
    @Test
    public void testGetBtnSave()
    {
        System.out.println("getBtnSave");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnSave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnSaveAs method, of class InterfaceView.
     */
    @Test
    public void testGetBtnSaveAs()
    {
        System.out.println("getBtnSaveAs");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnSaveAs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnInsert method, of class InterfaceView.
     */
    @Test
    public void testGetBtnInsert()
    {
        System.out.println("getBtnInsert");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnInsert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnNew method, of class InterfaceView.
     */
    @Test
    public void testGetBtnNew()
    {
        System.out.println("getBtnNew");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnNew();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnOpen method, of class InterfaceView.
     */
    @Test
    public void testGetBtnOpen()
    {
        System.out.println("getBtnOpen");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtfTaskDauer method, of class InterfaceView.
     */
    @Test
    public void testGetFtfTaskDauer()
    {
        System.out.println("getFtfTaskDauer");
        InterfaceView instance = new InterfaceViewImpl();
        JFormattedTextField expResult = null;
        JFormattedTextField result = instance.getFtfTaskDauer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtfTaskEnde method, of class InterfaceView.
     */
    @Test
    public void testGetFtfTaskEnde()
    {
        System.out.println("getFtfTaskEnde");
        InterfaceView instance = new InterfaceViewImpl();
        JFormattedTextField expResult = null;
        JFormattedTextField result = instance.getFtfTaskEnde();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtfTaskStart method, of class InterfaceView.
     */
    @Test
    public void testGetFtfTaskStart()
    {
        System.out.println("getFtfTaskStart");
        InterfaceView instance = new InterfaceViewImpl();
        JFormattedTextField expResult = null;
        JFormattedTextField result = instance.getFtfTaskStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTfTaskName method, of class InterfaceView.
     */
    @Test
    public void testGetTfTaskName()
    {
        System.out.println("getTfTaskName");
        InterfaceView instance = new InterfaceViewImpl();
        JTextField expResult = null;
        JTextField result = instance.getTfTaskName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLblFile method, of class InterfaceView.
     */
    @Test
    public void testGetLblFile()
    {
        System.out.println("getLblFile");
        InterfaceView instance = new InterfaceViewImpl();
        JLabel expResult = null;
        JLabel result = instance.getLblFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuInfo method, of class InterfaceView.
     */
    @Test
    public void testGetMnuInfo()
    {
        System.out.println("getMnuInfo");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuNew method, of class InterfaceView.
     */
    @Test
    public void testGetMnuNew()
    {
        System.out.println("getMnuNew");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuNew();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuOpen method, of class InterfaceView.
     */
    @Test
    public void testGetMnuOpen()
    {
        System.out.println("getMnuOpen");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuSave method, of class InterfaceView.
     */
    @Test
    public void testGetMnuSave()
    {
        System.out.println("getMnuSave");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuSave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuSaveAs method, of class InterfaceView.
     */
    @Test
    public void testGetMnuSaveAs()
    {
        System.out.println("getMnuSaveAs");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuSaveAs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuExit method, of class InterfaceView.
     */
    @Test
    public void testGetMnuExit()
    {
        System.out.println("getMnuExit");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuExit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTblData method, of class InterfaceView.
     */
    @Test
    public void testGetTblData()
    {
        System.out.println("getTblData");
        InterfaceView instance = new InterfaceViewImpl();
        JTable expResult = null;
        JTable result = instance.getTblData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnInsertTask method, of class InterfaceView.
     */
    @Test
    public void testGetBtnInsertTask()
    {
        System.out.println("getBtnInsertTask");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnInsertTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnDeleteTask method, of class InterfaceView.
     */
    @Test
    public void testGetBtnDeleteTask()
    {
        System.out.println("getBtnDeleteTask");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnDeleteTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastDirectory method, of class InterfaceView.
     */
    @Test
    public void testSetLastDirectory()
    {
        System.out.println("setLastDirectory");
        String path = "";
        InterfaceView instance = new InterfaceViewImpl();
        instance.setLastDirectory(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuInsertTask method, of class InterfaceView.
     */
    @Test
    public void testGetMnuInsertTask()
    {
        System.out.println("getMnuInsertTask");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuInsertTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuDeleteTask method, of class InterfaceView.
     */
    @Test
    public void testGetMnuDeleteTask()
    {
        System.out.println("getMnuDeleteTask");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuDeleteTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrmInputData method, of class InterfaceView.
     */
    @Test
    public void testGetFrmInputData()
    {
        System.out.println("getFrmInputData");
        InterfaceView instance = new InterfaceViewImpl();
        JFrame expResult = null;
        JFrame result = instance.getFrmInputData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMnuProperties method, of class InterfaceView.
     */
    @Test
    public void testGetMnuProperties()
    {
        System.out.println("getMnuProperties");
        InterfaceView instance = new InterfaceViewImpl();
        JMenuItem expResult = null;
        JMenuItem result = instance.getMnuProperties();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrmProperties method, of class InterfaceView.
     */
    @Test
    public void testGetFrmProperties()
    {
        System.out.println("getFrmProperties");
        InterfaceView instance = new InterfaceViewImpl();
        JFrame expResult = null;
        JFrame result = instance.getFrmProperties();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnPropAbbrechen method, of class InterfaceView.
     */
    @Test
    public void testGetBtnPropAbbrechen()
    {
        System.out.println("getBtnPropAbbrechen");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnPropAbbrechen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnPropBestaetigen method, of class InterfaceView.
     */
    @Test
    public void testGetBtnPropBestaetigen()
    {
        System.out.println("getBtnPropBestaetigen");
        InterfaceView instance = new InterfaceViewImpl();
        JButton expResult = null;
        JButton result = instance.getBtnPropBestaetigen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTfPropProjektName method, of class InterfaceView.
     */
    @Test
    public void testGetTfPropProjektName()
    {
        System.out.println("getTfPropProjektName");
        InterfaceView instance = new InterfaceViewImpl();
        JTextField expResult = null;
        JTextField result = instance.getTfPropProjektName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScrPnlMainFrmRight method, of class InterfaceView.
     */
    @Test
    public void testGetScrPnlMainFrmRight()
    {
        System.out.println("getScrPnlMainFrmRight");
        InterfaceView instance = new InterfaceViewImpl();
        JScrollPane expResult = null;
        JScrollPane result = instance.getScrPnlMainFrmRight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateChart method, of class InterfaceView.
     */
    @Test
    public void testUpdateChart()
    {
        System.out.println("updateChart");
        IntervalCategoryDataset dataset = null;
        String title = "";
        InterfaceView instance = new InterfaceViewImpl();
        instance.updateChart(dataset, title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InterfaceViewImpl
            extends InterfaceView
    {
        public void updateChart(IntervalCategoryDataset dataset, String title)
        {
        }
    }
    
}
