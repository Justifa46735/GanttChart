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

import controller.UpdateDataCntrl;
import controller.DeleteTaskCntrl;
import controller.ExitAppCntrl;
import controller.InpModDataCntrl;
import controller.ShowInpTaskCntrl;
import controller.InterfaceController;
import controller.NewProjCntrl;
import controller.OpenFileCntrl;
import controller.OpenInfoFrmCntrl;
import controller.PropAbortCntrl;
import controller.PropConfirmCntrl;
import controller.OpenPropFrmCntrl;
import controller.SaveAsCntrl;
import controller.SaveFileCntrl;
import controller.TaskEditCntrl;
import controller.TaskInpAbortCntrl;
import controller.ZoomInCntrl;
import controller.ZoomNormalCntrl;
import controller.ZoomOutCntrl;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.DataModel;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;
import view.GanttChartFrame;

public class GanttChart
{
    private static Logger log = FileLogger.getLogger();

    public GanttChart()
    {
        log.info("init components");
        InterfaceView frmMainFrame = new GanttChartFrame();
        InterfaceModel mdlDataHandle = new DataModel();

        InterfaceController cntlOpenFile     = new OpenFileCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlSaveFile     = new SaveFileCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlSaveAs       = new SaveAsCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlZoomNormal   = new ZoomNormalCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlZoomIn       = new ZoomInCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlZoomOut      = new ZoomOutCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlChart        = new UpdateDataCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlExit         = new ExitAppCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlNewProjekt   = new NewProjCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlShowInpTask  = new ShowInpTaskCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlDeleteTask   = new DeleteTaskCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlProperties   = new OpenPropFrmCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlPropAbbr     = new PropAbortCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlPropBest     = new PropConfirmCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlTable        = new TaskEditCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlInpModData   = new InpModDataCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlInpTaskAbort = new TaskInpAbortCntrl(frmMainFrame, mdlDataHandle);
        InterfaceController cntlShowInfoFrm  = new OpenInfoFrmCntrl(frmMainFrame, mdlDataHandle);

        cntlOpenFile.registerEvents();
        cntlSaveFile.registerEvents();
        cntlSaveAs.registerEvents();
        cntlZoomNormal.registerEvents();
        cntlZoomIn.registerEvents();
        cntlZoomOut.registerEvents();
        cntlChart.registerEvents();
        cntlExit.registerEvents();
        cntlNewProjekt.registerEvents();
        cntlShowInpTask.registerEvents();
        cntlDeleteTask.registerEvents();
        cntlProperties.registerEvents();
        cntlPropAbbr.registerEvents();
        cntlPropBest.registerEvents();
        cntlTable.registerEvents();
        cntlInpModData.registerEvents();
        cntlInpTaskAbort.registerEvents();
        cntlShowInfoFrm.registerEvents();

        frmMainFrame.visible(true);
        log.info("init components done");
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
