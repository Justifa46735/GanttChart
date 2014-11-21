/**
 * @name : ExitController
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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;

public class ExitAppCntrl
        extends InterfaceController
        implements WindowListener, ActionListener
{
    private static Logger log = FileLogger.getLogger();

    public ExitAppCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.addFensterListener(this);
        view.getMnuExit().addActionListener(this);
    }

    private void closeApplication()
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
            System.exit(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        closeApplication();
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        closeApplication();
    }
}
