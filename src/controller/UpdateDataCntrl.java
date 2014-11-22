/**
 * @name : ChartHandleController
 *
 * @author: lenovo
 * @date : 14.11.2014
 *
 * @brief :
 *
 */
package controller;

import model.TaskData;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import model.InterfaceModel;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import view.InterfaceView;

public class UpdateDataCntrl
        extends InterfaceController
        implements Observer
{
    private final String[] columnNames;

    public UpdateDataCntrl(InterfaceView view, InterfaceModel model)
    {
        super(view, model);
        //view.getTblData().setModel(new DefaultTableModel(model.getTaskArray().toArray(),4));

        columnNames = new String[4];
        columnNames[0] = "Task Bezeichnung";
        columnNames[1] = "Start";
        columnNames[2] = "Ende";
        columnNames[3] = "Dauer";
    }

    @Override
    public void registerEvents()
    {
        model.addBeobachter(this);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        updateTable();
        updateChart();
    }

    private void updateChart()
    {
        if (!model.getTaskArray().isEmpty())
        {
            //TaskSeries s1 = new TaskSeries("Scheduled");
            TaskSeries s1 = null;
            TaskSeriesCollection collection = new TaskSeriesCollection();
            int i = 1;

            for (TaskData tsk : model.getTaskArray())
            {
                s1 = new TaskSeries("Task" + i++);
                s1.add(new Task(tsk.getName(), new SimpleTimePeriod(tsk.getStartDate(), tsk.getEndDate())));
                collection.add(s1);
                //s1.add(new Task(tsk.getName(), new SimpleTimePeriod(tsk.getStartDate(), tsk.getEndDate())));
            }

            //collection.add(s1);
            //collection.add(s1);
            view.updateChart(collection, model.getProjektName());
        }
        else
        {
            view.updateChart(null, model.getProjektName());
        }
    }

    private void updateTable()
    {
        String[][] tmp = new String[model.getTaskArray().size()][4];

        for (int i = 0; i < model.getTaskArray().size(); i++)
        {
            tmp[i][0] = model.getTaskArray().get(i).getName();
            tmp[i][1] = model.getTaskArray().get(i).getStartString();
            tmp[i][2] = model.getTaskArray().get(i).getEndString();
            tmp[i][3] = String.valueOf(model.getTaskArray().get(i).getHoursBetween()) + " h";
        }

        DefaultTableModel newTabelModel = new DefaultTableModel(tmp, columnNames)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        view.getTblData().setModel(newTabelModel);
    }
}
