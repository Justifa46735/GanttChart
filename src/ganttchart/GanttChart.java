/**
 * @name : Start
 *
 * @author: lenovo
 * @date : 10.11.2014
 *
 * @brief :
 *
 */
package ganttchart;

import controller.DataUpdateController;
import controller.DeleteTaskController;
import controller.ExitController;
import controller.InpModDataController;
import controller.InsertTaskController;
import controller.InterfaceController;
import controller.NewProjectController;
import controller.OpenFileController;
import controller.PropAbbrController;
import controller.PropBestController;
import controller.PropFrmController;
import controller.SaveAsController;
import controller.SaveController;
import controller.TaskEditController;
import controller.ZoomInController;
import controller.ZoomNormalController;
import controller.ZoomOutController;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.DataModel;
import model.InterfaceModel;
import view.InterfaceView;
import view.GanttChartFrame;

public class GanttChart
{
    public GanttChart()
    {
        InterfaceView frmMainFrame = new GanttChartFrame();
        InterfaceModel mdlDataHandle = new DataModel();

        InterfaceController cntlOpenFile   = new OpenFileController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlSaveFile   = new SaveController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlSaveAs     = new SaveAsController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlZoomNormal = new ZoomNormalController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlZoomIn     = new ZoomInController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlZoomOut    = new ZoomOutController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlChart      = new DataUpdateController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlExit       = new ExitController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlNewProjekt = new NewProjectController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlInsertTask = new InsertTaskController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlDeleteTask = new DeleteTaskController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlProperties = new PropFrmController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlPropAbbr   = new PropAbbrController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlPropBest   = new PropBestController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlTable      = new TaskEditController(frmMainFrame, mdlDataHandle);
        InterfaceController cntlInpModData = new InpModDataController(frmMainFrame, mdlDataHandle);

        cntlOpenFile.registerEvents();
        cntlSaveFile.registerEvents();
        cntlSaveAs.registerEvents();
        cntlZoomNormal.registerEvents();
        cntlZoomIn.registerEvents();
        cntlZoomOut.registerEvents();
        cntlChart.registerEvents();
        cntlExit.registerEvents();
        cntlNewProjekt.registerEvents();
        cntlInsertTask.registerEvents();
        cntlDeleteTask.registerEvents();
        cntlProperties.registerEvents();
        cntlPropAbbr.registerEvents();
        cntlPropBest.registerEvents();
        cntlTable.registerEvents();
        cntlInpModData.registerEvents();

        frmMainFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
        
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            JOptionPane.showConfirmDialog(null, e.toString());
        }

        new GanttChart();
    }
}
