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

import model.TaskData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.InterfaceModel;
import util.FileLogger;
import view.InterfaceView;

public class InpModDataCntrl
        extends InterfaceController
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
        view.getFrmInputData().getBtnInsert().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (view.getFrmInputData().getBtnInsert().getText().compareTo("Bearbeiten") == 0)
        {
            modifyTask();
        }
        else
        {
            if (view.getFrmInputData().getBtnInsert().getText().compareTo("Einfügen") == 0)
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
                    if (view.getFrmInputData().getFtfTaskDauer().getText().compareTo("0 h") == 0
                            || view.getFrmInputData().getFtfTaskDauer().getText().compareTo("") == 0)
                    {

                        model.modifyTask(row,
                                         view.getFrmInputData().getTfTaskName().getText(),
                                         view.getFrmInputData().getFtfTaskStart().getText(),
                                         view.getFrmInputData().getFtfTaskEnde().getText());
                    }
                    else
                    {
                        model.modifyTask(row,
                                         view.getFrmInputData().getTfTaskName().getText(),
                                         view.getFrmInputData().getFtfTaskStart().getText(),
                                         Integer.valueOf(view.getFrmInputData().getFtfTaskDauer().getText().replace("h", "").replace(" ", "")));
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
            if (view.getFrmInputData().getFtfTaskDauer().getText().compareTo("0 h") == 0
                    || view.getFrmInputData().getFtfTaskDauer().getText().compareTo("") == 0)
            {
                try
                {
                    model.addTask(new TaskData(view.getFrmInputData().getTfTaskName().getText(),
                                               view.getFrmInputData().getFtfTaskStart().getText(),
                                               view.getFrmInputData().getFtfTaskEnde().getText()));
                    view.getFrmInputData().setVisible(false);
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
                try
                {
                    model.addTask(new TaskData(view.getFrmInputData().getTfTaskName().getText(),
                                               view.getFrmInputData().getFtfTaskStart().getText(),
                                               Integer.valueOf(view.getFrmInputData().getFtfTaskDauer().getText().replace("h", "").replace(" ", ""))));
                    view.getFrmInputData().setVisible(false);
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
        }
    }

    private int checkInpData()
    {
        if (view.getFrmInputData().getTfTaskName().getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(view.getFrmInputData(),
                                          "Bitte geben Sie eine Bezeichnung ein !",
                                          "Fehler !",
                                          JOptionPane.ERROR_MESSAGE);
            view.getFrmInputData().getTfTaskName().grabFocus();
            return -1;
        }

        if (view.getFrmInputData().getFtfTaskStart().getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(view.getFrmInputData(),
                                          "Bitte geben Sie ein Start Datum ein !",
                                          "Fehler !",
                                          JOptionPane.ERROR_MESSAGE);
            view.getFrmInputData().getFtfTaskStart().grabFocus();
            return -1;
        }

        if (view.getFrmInputData().getFtfTaskEnde().getText().compareTo("") == 0
                && (view.getFrmInputData().getFtfTaskDauer().getText().compareTo("") == 0
                    || view.getFrmInputData().getFtfTaskDauer().getText().compareTo("0 h") == 0))
        {
            JOptionPane.showMessageDialog(view.getFrmInputData(),
                                          "Bitte geben Sie entweder ein End-Datum oder eine Zeitdauer ein !",
                                          "Fehler !",
                                          JOptionPane.ERROR_MESSAGE);
            view.getFrmInputData().getFtfTaskEnde().grabFocus();
            return -1;
        }

        return 0;
    }
}
