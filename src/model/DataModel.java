/**
 * @name : DataHandleModel
 *
 * @author: lenovo
 * @date : 11.11.2014
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
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataModel
        extends Observable
        implements InterfaceModel
{
    protected List<TaskData> daten;
    protected final List<String> elementName;
    private String projektName;
    private boolean dataSaved;

    private final String version = "1.0.0";

    public DataModel()
    {
        daten = new ArrayList<>();
        elementName = new ArrayList<>();
        elementName.add("Bezeichnung");
        elementName.add("Start_Date");
        elementName.add("End_Date");
        elementName.add("Hours_Between");

        projektName = "no project name added";
    }

    private void setDataSaved()
    {
        this.dataSaved = true;
    }

    private void dataChanged()
    {
        this.dataSaved = false;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void setProjektName(String projektName)
    {
        if (projektName == null || projektName.compareTo("") == 0)
        {
            this.projektName = "no project name added";
        }
        else
        {
            this.projektName = projektName;
        }
        dataChanged();
    }

    @Override
    public String getProjektName()
    {
        return projektName;
    }

    @Override
    public boolean isDataSaved()
    {
        return dataSaved;
    }

    @Override
    public void addTask(TaskData new_task)
    {
        if (new_task != null)
        {
            daten.add(new_task);
            dataChanged();
        }
    }

    @Override
    public void removeTask(TaskData old_task)
    {
        if (old_task != null)
        {
            daten.remove(old_task);
            dataChanged();
        }
    }

    @Override
    public void clearData()
    {
        daten.clear();
        dataChanged();
    }

    @Override
    public void modifyTask(int index, String name, Date start, Date end)
    {
        if (name != null)
        {
            daten.get(index).setName(name);
        }
        if (start != null)
        {
            daten.get(index).setStartDate(start);
        }
        if (end != null)
        {
            daten.get(index).setEndDate(end);
        }
        dataChanged();
    }

    @Override
    public void modifyTask(int index, String name, String start, String end) throws ParseException
    {
        if (name != null)
        {
            daten.get(index).setName(name);
        }
        if (start != null)
        {
            daten.get(index).setStartDate(start);
        }
        if (end != null)
        {
            daten.get(index).setEndDate(end);
        }
        dataChanged();
    }

    @Override
    public void modifyTask(int index, String name, Date start, int dauer)
    {
        if (name != null)
        {
            daten.get(index).setName(name);
        }
        if (start != null)
        {
            daten.get(index).setStartDate(start);
        }
        if (dauer >= 0)
        {
            daten.get(index).getEndDate().setTime(daten.get(index).getStartDate().getTime() + (long)(60.0 * 60.0 * 1000.0 * dauer));
        }
        dataChanged();
    }

    @Override
    public void modifyTask(int index, String name, String start, int dauer) throws ParseException
    {
        if (name != null)
        {
            daten.get(index).setName(name);
        }
        if (start != null)
        {
            daten.get(index).setStartDate(start);
        }
        if (dauer >= 0)
        {
            daten.get(index).getEndDate().setTime(daten.get(index).getStartDate().getTime() + (long)(60.0 * 60.0 * 1000.0 * dauer));
        }
        dataChanged();
    }

    @Override
    public List<TaskData> getTaskArray()
    {
        return Collections.unmodifiableList(daten);
    }

    @Override
    public void saveFile(File xmlFile) throws ParserConfigurationException, TransformerException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element rootElement = doc.createElement(getProjektName().replace(" ", "_"));
        doc.appendChild(rootElement);

        for (int i = 0; i < daten.size(); i++)
        {
            Element taskElement = doc.createElement("Task");
            rootElement.appendChild(taskElement);
            taskElement.setAttribute("id", String.valueOf(i));

            Element taskName = doc.createElement(elementName.get(0));
            taskName.appendChild(doc.createTextNode(daten.get(i).getName()));
            taskElement.appendChild(taskName);

            Element taskStart = doc.createElement(elementName.get(1));
            taskStart.appendChild(doc.createTextNode(daten.get(i).getStartString()));
            taskElement.appendChild(taskStart);

            Element taskEnde = doc.createElement(elementName.get(2));
            taskEnde.appendChild(doc.createTextNode(daten.get(i).getEndString()));
            taskElement.appendChild(taskEnde);

            Element taskDauer = doc.createElement(elementName.get(3));
            taskDauer.appendChild(doc.createTextNode(String.valueOf(daten.get(i).getHoursBetween())));
            taskElement.appendChild(taskDauer);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);

        transformer.transform(source, result);
        setDataSaved();
    }

    @Override
    public void openFile(File xmlFile) throws SAXException, IOException, ParserConfigurationException, ParseException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        daten.clear();

        Element docElement = document.getDocumentElement();
        NodeList nodeList = docElement.getElementsByTagName("Task");
        setProjektName(docElement.getNodeName().replace("_", " "));

        if (nodeList != null && nodeList.getLength() > 0)
        {
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Element element = (Element) nodeList.item(i);
                saveElements(element);
            }
        }

        dataChanged();
    }

    private void saveElements(Element element) throws ParseException
    {
        String[] values = new String[4];
        NodeList nodeList = null;

        for (int i = 0; i < elementName.size(); i++)
        {
            nodeList = element.getElementsByTagName(elementName.get(i));
            if (nodeList != null && nodeList.getLength() > 0)
            {
                Element nxtElement = (Element) nodeList.item(0);
                values[i] = nxtElement.getFirstChild().getNodeValue();
            }
        }

        if (nodeList != null && nodeList.getLength() > 0)
        {
            daten.add(new TaskData(values[0], values[1], values[2]));
        }
    }

    @Override
    public String getVersion()
    {
        return version;
    }

    @Override
    public void addBeobachter(Observer obj)
    {
        this.addObserver(obj);
    }
}
