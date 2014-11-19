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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.InterfaceModel;
import view.InterfaceView;

public class SaveAsController
        extends InterfaceController
        implements ActionListener
{
    public SaveAsController(InterfaceView view, InterfaceModel model)
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
        int retVal = view.getFileChooser().showSaveDialog(view);

        if (retVal == JFileChooser.APPROVE_OPTION)
        {
            File f = view.getFileChooser().getSelectedFile();
            view.setLastDirectory(f.getAbsolutePath());
            view.getLblFile().setText(f.getAbsolutePath());

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
