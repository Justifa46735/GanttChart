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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import org.xml.sax.SAXException;
import view.InterfaceView;

public class OpenFileController
        extends InterfaceController
        implements ActionListener
{
    public OpenFileController(InterfaceView view, InterfaceModel model)
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

            int retVal = view.getFileChooser().showOpenDialog(view);

            if (retVal == JFileChooser.APPROVE_OPTION)
            {
                File f = view.getFileChooser().getSelectedFile();
                view.setLastDirectory(f.getAbsolutePath());
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

                try
                {
                    model.openFile(f);
                }
                catch (SAXException | IOException | ParserConfigurationException | ParseException exp)
                {
                    JOptionPane.showMessageDialog(view,
                                                  "Beim öffnen der Datei ist ein Fehler aufgetretten:\n" + exp.getLocalizedMessage(),
                                                  "Fehler !",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}
