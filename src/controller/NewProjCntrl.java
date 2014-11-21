/**
 * @name : NewProjectController
 *
 * @author: lenovo
 * @date : 15.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;

public class NewProjCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    private static Logger log = FileLogger.getLogger();

    public NewProjCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnNew().addActionListener(this);
        view.getMnuNew().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int retValJOption = JOptionPane.YES_OPTION;
        int retValFileChooser = JFileChooser.APPROVE_OPTION;

        if ((!model.isDataSaved()) && model.getProjektName().compareTo("no project name added") != 0)
        {
            retValJOption = view.showOptionDialog("Speichern ?", "Wollen Sie das Projekt speichern ?");

            if (retValJOption == JOptionPane.YES_OPTION)
            {
                retValFileChooser = view.getFileChooser().showSaveDialog((Component) view);

                if (retValFileChooser == JFileChooser.APPROVE_OPTION)
                {
                    File f = view.getFileChooser().getSelectedFile();
                    view.setLastDirectory(f.getAbsolutePath());

                    try
                    {
                        model.saveFile(f);
                    }
                    catch (ParserConfigurationException | TransformerException exp)
                    {
                        view.showErrorMsg("Beim Speichern der Datei ist ein Fehler aufgetretten!");
                        log.severe("could not save file ! " + exp.getLocalizedMessage());

                    }
                }
            }
        }

        if (retValJOption != JOptionPane.CANCEL_OPTION && retValJOption != JOptionPane.CLOSED_OPTION
                && retValFileChooser != JFileChooser.CANCEL_OPTION)
        {
            String retVal = JOptionPane.showInputDialog("Projektname:");

            if (retVal != null)
            {
                model.setProjektName(retVal);
                view.getLblFile().setText("File");
                view.getBtnSave().setEnabled(true);
                view.getMnuSave().setEnabled(true);
                view.getBtnSaveAs().setEnabled(false);
                view.getMnuSaveAs().setEnabled(false);
                view.getBtnInsertTask().setEnabled(true);
                view.getBtnDeleteTask().setEnabled(true);
                view.getMnuInsertTask().setEnabled(true);
                view.getMnuDeleteTask().setEnabled(true);
                view.getMnuProperties().setEnabled(true);
                model.clearData();
                view.getTblData().setFillsViewportHeight(true);
            }
        }
    }
}
