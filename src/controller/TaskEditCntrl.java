/**
 * @name : TableHandleController
 *
 * @author: lenovo
 * @date : 18.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.InterfaceModel;
import view.InterfaceView;

public class TaskEditCntrl
        extends InterfaceController
        implements MouseListener
{
    public TaskEditCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getTblData().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent evt)
    {
        if (evt.getClickCount() > 1)
        {
            int row = view.getTblData().getSelectedRow();

            if (row != -1)
            {
                view.getFrmInputData().setTitle("Task bearbeiten");
                view.getBtnInsert().setText("Bearbeiten");
                view.getTfTaskName().setText(model.getTaskArray().get(row).getName());
                view.getFtfTaskStart().setText(model.getTaskArray().get(row).getStartString());
                view.getFtfTaskEnde().setText(model.getTaskArray().get(row).getEndString());
                view.getFtfTaskDauer().setText(String.valueOf(model.getTaskArray().get(row).getHoursBetween()) + " h");
                view.getFrmInputData().setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}
