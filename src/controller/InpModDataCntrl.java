/**
 * @name : InpModDataControlelr
 *
 * @author: lenovo
 * @date : 18.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.InterfaceModel;
import view.InterfaceView;

public class InpModDataCntrl
        extends InterfaceController
        implements ActionListener
{
    public InpModDataCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnInsert().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (view.getBtnInsert().getText().compareTo("Bearbeiten") == 0)
        {
            int row = view.getTblData().getSelectedRow();

            if (row != -1)
            {
                try
                {
                    model.modifyTask(row,
                                     view.getTfTaskName().getText(),
                                     view.getFtfTaskStart().getText(),
                                     view.getFtfTaskEnde().getText());
                    view.getFrmInputData().setVisible(false);
                }
                catch (ParseException exp)
                {
                    JOptionPane.showMessageDialog(view,
                                                  "Task konnte nicht bearbeitet werden !\n" + exp.getLocalizedMessage(),
                                                  "Fehler !",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
        {
            if (view.getBtnInsert().getText().compareTo("Einfügen") == 0)
            {
            }
        }
    }
}
