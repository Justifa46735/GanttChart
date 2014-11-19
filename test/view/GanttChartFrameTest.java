/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
public class GanttChartFrameTest
{
    
    public GanttChartFrameTest()
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
     * Test of updateChart method, of class GanttChartFrame.
     */
    @Test
    public void testUpdateChart()
    {
        System.out.println("updateChart");
        IntervalCategoryDataset dataset = null;
        String title = "";
        GanttChartFrame instance = new GanttChartFrame();
        instance.updateChart(dataset, title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
