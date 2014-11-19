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
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
        extends InterfaceModel
{
    public DataModel()
    {
        super();
    }

    @Override
    public void addTask(TaskData new_task)
    {
        daten.add(new_task);
        super.dataChanged();
    }

    @Override
    public void removeTask(TaskData old_task)
    {
        daten.remove(old_task);
        super.dataChanged();
    }

    @Override
    public void modifyTask(int index, String name, Date start, Date end)
    {
        daten.get(index).setName(name);
        daten.get(index).setStartDate(start);
        daten.get(index).setEndDate(end);
        super.dataChanged();
    }

    @Override
    public void modifyTask(int index, String name, String start, String end) throws ParseException
    {
        daten.get(index).setName(name);
        daten.get(index).setStartDate(start);
        daten.get(index).setEndDate(end);
        super.dataChanged();
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

        Element rootElement = doc.createElement(super.getProjektName().replace(" ", "_"));
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
        super.setDataSaved();
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
        super.setProjektName(docElement.getNodeName().replace("_", " "));

        if (nodeList != null && nodeList.getLength() > 0)
        {
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Element element = (Element) nodeList.item(i);
                saveElements(element);
            }
        }

        super.dataChanged();
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
}