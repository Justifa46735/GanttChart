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

import ganttchart.TaskData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;

public class InpModDataCntrl
        extends InterfaceClassCntrl
        implements ActionListener
{
    private static Logger log = FileLogger.getLogger();

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
            modifyTask();
        }
        else
        {
            if (view.getBtnInsert().getText().compareTo("Einfügen") == 0)
            {
                insertNewTask();
            }
        }
    }

    private void modifyTask()
    {
        int row = view.getTblData().getSelectedRow();

        if (row != -1)
        {
            try
            {
                if (checkInpData() != -1)
                {
                    if (view.getFtfTaskDauer().getText().compareTo("0 h") == 0
                            || view.getFtfTaskDauer().getText().compareTo("") == 0)
                    {

                        model.modifyTask(row,
                                         view.getTfTaskName().getText(),
                                         view.getFtfTaskStart().getText(),
                                         view.getFtfTaskEnde().getText());
                    }
                    else
                    {
                        model.modifyTask(row,
                                         view.getTfTaskName().getText(),
                                         view.getFtfTaskStart().getText(),
                                         Integer.valueOf(view.getFtfTaskDauer().getText().replace("h", "").replace(" ", "")));
                    }

                    view.getFrmInputData().setVisible(false);
                }
            }
            catch (ParseException exp)
            {
                view.showErrorMsg("Task konnte nicht bearbeitet werden !");
                log.severe("task could not be modified ! " + exp.toString());
            }
        }
    }

    private void insertNewTask()
    {
        if (checkInpData() != -1)
        {
            if (view.getFtfTaskDauer().getText().compareTo("0 h") == 0
                    || view.getFtfTaskDauer().getText().compareTo("") == 0)
            {
                try
                {
                    model.addTask(new TaskData(view.getTfTaskName().getText(),
                                               view.getFtfTaskStart().getText(),
                                               view.getFtfTaskEnde().getText()));
                }
                catch (ParseException exp)
                {
                    JOptionPane.showMessageDialog(view.getFrmInputData(),
                                                  "Task konnte nicht hinzugefügt werden !\n" + exp.getLocalizedMessage(),
                                                  "Fehler !",
                                                  JOptionPane.ERROR_MESSAGE);
                    log.severe("task could not be added ! " + exp.toString());
                }
            }
            else
            {
            }
        }
    }

    private int checkInpData()
    {
        if (view.getTfTaskName().getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(view.getFrmInputData(),
                                          "Bitte geben Sie eine Bezeichnung ein !",
                                          "Fehler !",
                                          JOptionPane.ERROR_MESSAGE);
            view.getTfTaskName().grabFocus();
            return -1;
        }

        if (view.getFtfTaskStart().getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(view.getFrmInputData(),
                                          "Bitte geben Sie ein Start Datum ein !",
                                          "Fehler !",
                                          JOptionPane.ERROR_MESSAGE);
            view.getFtfTaskStart().grabFocus();
            return -1;
        }

        if (view.getFtfTaskEnde().getText().compareTo("") == 0
                && view.getFtfTaskDauer().getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(view.getFrmInputData(),
                                          "Bitte geben Sie entweder ein End Datum oder ein Zeitddauer ein !",
                                          "Fehler !",
                                          JOptionPane.ERROR_MESSAGE);
            view.getFtfTaskEnde().grabFocus();
            return -1;
        }

        return 0;
    }
}
