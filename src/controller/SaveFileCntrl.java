/**
 * @name : SaveController
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
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;

public class SaveFileCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    private static Logger log = FileLogger.getLogger();

    public SaveFileCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnSave().addActionListener(this);
        view.getMnuSave().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        File f = null;

        if (view.getLblFile().getText().compareTo("File") == 0)
        {
            int retVal = view.getFileChooser().showSaveDialog((Component) view);

            if (retVal == JFileChooser.APPROVE_OPTION)
            {
                f = view.getFileChooser().getSelectedFile();
                view.setLastDirectory(f.getAbsolutePath());
                view.getLblFile().setText(f.getAbsolutePath());
                view.getBtnSaveAs().setEnabled(true);
                view.getMnuSaveAs().setEnabled(true);
            }
        }
        else
        {
            f = new File(view.getLblFile().getText());
        }

        if (f != null)
        {
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
