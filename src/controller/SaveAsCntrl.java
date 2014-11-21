/**
 * @name : SaveAsController
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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;

public class SaveAsCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    private static Logger log = FileLogger.getLogger();

    public SaveAsCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnSaveAs().addActionListener(this);
        view.getMnuSaveAs().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int retVal = view.getFileChooser().showSaveDialog((Component) view);

        if (retVal == JFileChooser.APPROVE_OPTION)
        {
            File f = view.getFileChooser().getSelectedFile();
            view.setLastDirectory(f.getAbsolutePath());

            try
            {
                model.saveFile(f);
                view.getLblFile().setText(f.getAbsolutePath());
            }
            catch (ParserConfigurationException | TransformerException exp)
            {
                view.showErrorMsg("Beim Speichern der Datei ist ein Fehler aufgetretten !");
                log.severe("could not save file ! " + exp.getLocalizedMessage());
            }
        }
    }
}
