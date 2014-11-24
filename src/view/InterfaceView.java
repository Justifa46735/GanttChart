/**
 * @name : InterfaceView
 *
 * @author: lenovo
 * @date : 17.11.2014
 *
 * @brief :
 *
 */
package view;

import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;

public interface InterfaceView
{
    public void addFensterListener(WindowListener obj);

    public void showErrorMsg(String msg);

    public void showInfoMsg(String msg);

    public int showOptionDialog(String title, String msg);

    public void visible(boolean state);

    public abstract ChartPanel getChartPanel();

    public abstract JButton getBtnZoomIn();

    public abstract JButton getBtnZoomOut();

    public abstract JButton getBtnZoomNormal();

    public abstract JMenuItem getMnuZoomNormal();

    public abstract JMenuItem getMnuZoomOut();

    public abstract JMenuItem getMnuZoomIn();

    public abstract JFileChooser getFileChooser();

    public abstract JButton getBtnSave();

    public abstract JButton getBtnSaveAs();

    public abstract JButton getBtnNew();

    public abstract JButton getBtnOpen();

    public abstract JLabel getLblFile();

    public abstract JMenuItem getMnuInfo();

    public abstract JMenuItem getMnuNew();

    public abstract JMenuItem getMnuOpen();

    public abstract JMenuItem getMnuSave();

    public abstract JMenuItem getMnuSaveAs();

    public abstract JMenuItem getMnuExit();

    public abstract JTable getTblData();

    public abstract JButton getBtnInsertTask();

    public abstract JButton getBtnDeleteTask();

    public abstract void setLastDirectory(String path);

    public abstract JMenuItem getMnuInsertTask();

    public abstract JMenuItem getMnuDeleteTask();

    public abstract InputDataframe getFrmInputData();

    public abstract JMenuItem getMnuProperties();

    public JFrame getFrmProperties();

    public JButton getBtnPropAbbrechen();

    public JButton getBtnPropBestaetigen();

    public JTextField getTfPropProjektName();

    public JScrollPane getScrPnlMainFrmRight();

    public abstract String getVersion();
}
