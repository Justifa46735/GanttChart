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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import view.InterfaceView;

public class ExitAppCntrl
        extends InterfaceController
        implements WindowListener, ActionListener
{

    public ExitAppCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.addWindowListener(this);
        view.getMnuExit().addActionListener(this);
    }

    private void closeApplication()
    {
        int retValJOption = JOptionPane.YES_OPTION;
        int retValFileChooser = JFileChooser.APPROVE_OPTION;

        if ((!model.isDataSaved()) && model.getProjektName().compareTo("") != 0)
        {
            retValJOption = JOptionPane.showConfirmDialog(view,
                                                          "Wollen Sie das Projekt speichern ?",
                                                          "Speichern ?",
                                                          JOptionPane.YES_NO_CANCEL_OPTION);

            if (retValJOption == JOptionPane.YES_OPTION)
            {
                retValFileChooser = view.getFileChooser().showSaveDialog(view);

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
                        JOptionPane.showMessageDialog(view,
                                                      "Beim Speichern der Datei ist ein Fehler aufgetretten:\n" + exp.getLocalizedMessage(),
                                                      "Fehler !",
                                                      JOptionPane.ERROR_MESSAGE);

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
