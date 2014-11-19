/**
 * @name : InsertNewTaskController
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

public class ShowInpTaskCntrl
        extends InterfaceController
        implements ActionListener
{
    public ShowInpTaskCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
    }

    @Override
    public void registerEvents()
    {
        view.getBtnInsertTask().addActionListener(this);
        view.getMnuInsertTask().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        view.getTfTaskName().setText("Task Bezeichnung");
        view.getBtnInsert().setText("Einfügen");
        view.getFrmInputData().setTitle("neue Aufgabe hinzufügen");
        view.getFrmInputData().setVisible(true);
        view.getTfTaskName().grabFocus();
        view.getTfTaskName().selectAll();
    }
}
