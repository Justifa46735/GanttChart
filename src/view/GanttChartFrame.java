package view;

import java.io.File;
import java.util.prefs.Preferences;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;

public class GanttChartFrame
        extends InterfaceView
{
    private JFreeChart chart;
    private final String[] columnNames;

    public GanttChartFrame()
    {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        columnNames = new String[4];
        columnNames[0] = "Task Bezeichnung";
        columnNames[1] = "Start";
        columnNames[2] = "Ende";
        columnNames[3] = "Dauer";

        pref = Preferences.userRoot();
        super.getFileChooser().setCurrentDirectory(new File(pref.get("LAST_DIRECTORY", "")));

        init();
    }

    private void init()
    {
        chart = null;
        chart = ChartFactory.createGanttChart("Gantt Chart", "Tasks", "Datum", null, true, false, false);
        super.pnlChartPanel = new ChartPanel(chart);
        super.getScrPnlMainFrmRight().setViewportView(pnlChartPanel);
    }

    @Override
    public void updateChart(IntervalCategoryDataset dataset, String title)
    {
        super.getChartPanel().removeAll();
        super.getChartPanel().revalidate();
        chart = ChartFactory.createGanttChart(title, "Tasks", "Date", dataset, true, true, false);
        pnlChartPanel = new ChartPanel(chart);
        chart.setAntiAlias(true);
        chart.setTextAntiAlias(true);
        super.getScrPnlMainFrmRight().setViewportView(pnlChartPanel);
        super.getScrPnlMainFrmRight().repaint();
    }
}
