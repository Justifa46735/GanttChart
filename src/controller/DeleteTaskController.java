/**
 * @name : DeleteTaskController
 *
 * @author: lenovo
 * @date : 16.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InterfaceModel;
import view.InterfaceView;

public class DeleteTaskController
        extends InterfaceController
        implements ActionListener
{
    public DeleteTaskController(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnDeleteTask().addActionListener(this);
        view.getMnuDeleteTask().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int row = view.getTblData().getSelectedRow();

        if (row != -1)
        {
            model.removeTask(model.getTaskArray().get(row));

            if (row != 0)
            {
                view.getTblData().setRowSelectionInterval(row - 1, row - 1);
            }
            else
            {
                if (view.getTblData().getRowCount() > 0)
                {
                    view.getTblData().setRowSelectionInterval(row, row);
                }
            }
        }
    }
}
