/**
 * @name : InterfaceModel
 *
 * @author: lenovo
 * @date : 17.11.2014
 *
 * @brief :
 *
 */
package model;

import ganttchart.TaskData;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public abstract class InterfaceModel
        extends Observable
{
    protected List<TaskData> daten;
    protected final List<String> elementName;
    private String projektName;
    private boolean dataSaved;
    protected String version;

    public InterfaceModel()
    {
        daten = new ArrayList<>();
        elementName = new ArrayList<>();
        elementName.add("Bezeichnung");
        elementName.add("Start_Date");
        elementName.add("End_Date");
        elementName.add("Hours_Between");

        projektName = "";
    }

    public void setProjektName(String projektName)
    {
        this.projektName = projektName;
        dataChanged();
    }

    public String getProjektName()
    {
        return projektName;
    }

    public boolean isDataSaved()
    {
        return dataSaved;
    }

    protected void setDataSaved()
    {
        this.dataSaved = true;
    }

    protected void dataChanged()
    {
        this.dataSaved = false;
        this.setChanged();
        this.notifyObservers();
    }

    public abstract void addTask(TaskData new_task);

    public abstract void removeTask(TaskData old_task);

    public abstract void modifyTask(int index, String name, Date start, Date end);

    public abstract void modifyTask(int index, String name, String start, String end) throws ParseException;

    public abstract List<TaskData> getTaskArray();

    public abstract void saveFile(File xmlFile) throws ParserConfigurationException, TransformerException;

    public abstract void openFile(File xmlFile) throws SAXException, IOException, ParserConfigurationException, ParseException;
    
    public abstract String getVersion();
}
