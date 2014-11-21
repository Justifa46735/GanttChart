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
import java.text.SimpleDateFormat;
import java.util.Date;
import model.InterfaceModel;
import view.InterfaceView;

public class ShowInpTaskCntrl
        extends InterfaceController
        implements ActionListener
{
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

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
        view.getFrmInputData().setTitle("neue Aufgabe hinzufügen");
        view.getTfTaskName().setText("Task Bezeichnung");
        view.getBtnInsert().setText("Einfügen");
        view.getFtfTaskStart().setText(dateFormat.format(new Date()));
        view.getFtfTaskEnde().setText(dateFormat.format(new Date()));
        view.getTfTaskName().grabFocus();
        view.getTfTaskName().selectAll();
        view.getFrmInputData().setVisible(true);
    }
}
