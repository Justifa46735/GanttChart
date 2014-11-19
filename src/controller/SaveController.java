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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import view.InterfaceView;

public class SaveController
        extends InterfaceController
        implements ActionListener
{
    public SaveController(InterfaceView view, InterfaceModel model)
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
            int retVal = view.getFileChooser().showSaveDialog(view);

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
                JOptionPane.showMessageDialog(view,
                                              "Beim Speichern der Datei ist ein Fehler aufgetretten:\n" + exp.getLocalizedMessage(),
                                              "Fehler !",
                                              JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
