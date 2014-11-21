/**
 * @name : OpenFileController
 *
 * @author: lenovo
 * @date : 11.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import org.xml.sax.SAXException;
import util.FileLogger;
import view.InterfaceView;

public class OpenFileCntrl
        extends InterfaceController
        implements ActionListener
{
    private static Logger log = FileLogger.getLogger();

    public OpenFileCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnOpen().addActionListener(this);
        view.getMnuOpen().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt)
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
                        view.showErrorMsg("Beim Speichern der Datei ist ein Fehler aufgetretten !");
                        log.severe("could not save file ! " + exp.getLocalizedMessage());

                    }
                }
            }
        }

        if (retValJOption != JOptionPane.CANCEL_OPTION
                && retValJOption != JOptionPane.CLOSED_OPTION
                && retValFileChooser != JFileChooser.CANCEL_OPTION)
        {

            int retVal = view.getFileChooser().showOpenDialog((Component) view);

            if (retVal == JFileChooser.APPROVE_OPTION)
            {
                File f = view.getFileChooser().getSelectedFile();
                view.setLastDirectory(f.getAbsolutePath());

                try
                {
                    model.openFile(f);

                    view.getLblFile().setText(f.getAbsolutePath());
                    view.getBtnSave().setEnabled(true);
                    view.getMnuSave().setEnabled(true);
                    view.getBtnSaveAs().setEnabled(true);
                    view.getMnuSaveAs().setEnabled(true);
                    view.getMnuProperties().setEnabled(true);
                    view.getMnuInsertTask().setEnabled(true);
                    view.getMnuDeleteTask().setEnabled(true);
                    view.getBtnInsertTask().setEnabled(true);
                    view.getBtnDeleteTask().setEnabled(true);
                    view.getTblData().setFillsViewportHeight(true);
                }
                catch (SAXException | IOException | ParserConfigurationException | ParseException exp)
                {
                    view.showErrorMsg("Beim öffnen der Datei ist ein Fehler aufgetretten !");
                    log.severe("could not open file ! " + exp.toString());
                }
            }
        }

    }
}
