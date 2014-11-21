/**
 * @name : TaskInpAbortCntrl
 *
 * @author: lenovo
 * @date : 19.11.2014
 *
 * @brief :
 *
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InterfaceModel;
import view.InterfaceView;

public class TaskInpAbortCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    public TaskInpAbortCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnAbbrechen().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.getFrmInputData().setVisible(false);
    }
}
