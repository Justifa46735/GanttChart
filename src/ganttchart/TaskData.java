/**
 * @name : TaskData
 *
 * @author: lenovo
 * @date : 11.11.2014
 *
 * @brief :
 *
 */
package ganttchart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskData
{
    private String bezeichnung;
    private Date startDate;
    private Date endDate;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public TaskData(String bezeichnung, Date startDate, Date endDate)
    {
        this.bezeichnung = bezeichnung;
        this.startDate = (startDate == null) ? (new Date()) : startDate;
        this.endDate = (endDate == null) ? (new Date()) : endDate;
    }

    public TaskData(String bezeichnung, String startDate, String endDate) throws ParseException
    {
        this.bezeichnung = bezeichnung;
        this.startDate = (startDate == null) ? (new Date()) : stringToDate(startDate);
        this.endDate = (endDate == null) ? (new Date()) : stringToDate(endDate);
    }

    public TaskData(String bezeichnung, Date startDate, int dauer)
    {
        this.bezeichnung = bezeichnung;
        this.startDate = (startDate == null) ? (new Date()) : startDate;
        this.endDate = new Date(this.startDate.getTime() + (long) (60.0 * 60.0 * 1000.0 * dauer));
    }

    public TaskData(String bezeichnung, String startDate, int dauer) throws ParseException
    {
        this.bezeichnung = bezeichnung;
        this.startDate = (startDate == null) ? (new Date()) : stringToDate(startDate);
        this.endDate = new Date(this.startDate.getTime() + (long) (60.0 * 60.0 * 1000.0 * dauer));
    }

    private Date stringToDate(String date) throws ParseException
    {
        return dateFormat.parse(date);
    }

    public String getName()
    {
        return bezeichnung;
    }

    public String getStartString()
    {
        return dateFormat.format(startDate);
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public String getEndString()
    {
        return dateFormat.format(endDate);
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public long getHoursBetween()
    {
        long time_ms = endDate.getTime() - startDate.getTime();
        long hours = Math.round((double) time_ms / (60. * 60. * 1000.));

        return hours;
    }

    public void setName(String name)
    {
        this.bezeichnung = name;
    }

    public void setStartDate(String startDate) throws ParseException
    {
        this.startDate = stringToDate(startDate);
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) throws ParseException
    {
        this.endDate = stringToDate(endDate);
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
}
