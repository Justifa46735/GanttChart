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

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Observer;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public interface InterfaceModel
{
    public abstract void addBeobachter(Observer obj);

    public abstract void setProjektName(String projektName);

    public abstract String getProjektName();

    public abstract boolean isDataSaved();

    public abstract void addTask(TaskData new_task);

    public abstract void removeTask(TaskData old_task);
    
    public abstract void clearData();

    public abstract void modifyTask(int index, String name, Date start, Date end);

    public abstract void modifyTask(int index, String name, String start, String end) throws ParseException;

    public abstract void modifyTask(int index, String name, Date start, int dauer);

    public abstract void modifyTask(int index, String name, String start, int dauer) throws ParseException;

    public abstract List<TaskData> getTaskArray();

    public abstract void saveFile(File xmlFile) throws ParserConfigurationException, TransformerException;

    public abstract void openFile(File xmlFile) throws SAXException, IOException, ParserConfigurationException, ParseException;

    public abstract String getVersion();
}
