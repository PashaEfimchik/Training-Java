package by.epam.efimchik.Devices.parsers;

import by.epam.efimchik.Devices.entity.ComputerPart;
import by.epam.efimchik.Devices.entity.Group;
import by.epam.efimchik.Devices.entity.Peripheral;
import by.epam.efimchik.Devices.entity.Port;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    public List<ComputerPart> readXmlDomParser() throws ParserConfigurationException, IOException, SAXException {
        List<ComputerPart> computerParts = new ArrayList<>();
        ComputerPart computerPart;

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File("src/main/resources/computers.xml"));
        document.getDocumentElement().normalize();

        NodeList deviceList = document.getElementsByTagName("device");

        for (int i = 0; i < deviceList.getLength(); i++) {
            Node device = deviceList.item(i);

            if (device.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) device;

                computerPart = new ComputerPart();

                computerPart.setId(Integer.parseInt(element.getAttribute("id")));
                computerPart.setName(element.getElementsByTagName("name").item(0).getTextContent());
                computerPart.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
                computerPart.setPrice(Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent()));
                computerPart.setPeripheral(Peripheral.valueOf(element.getElementsByTagName("peripheral").item(0).getTextContent()));
                computerPart.setPowerUsage(Float.parseFloat(element.getElementsByTagName("powerUsage").item(0).getTextContent()));
                computerPart.setCooler(Boolean.parseBoolean(element.getElementsByTagName("cooler").item(0).getTextContent()));
                computerPart.setGroup(Group.valueOf(element.getElementsByTagName("group").item(0).getTextContent()));
                computerPart.setPort(Port.valueOf(element.getElementsByTagName("port").item(0).getTextContent()));
                computerPart.setCritical(Boolean.parseBoolean(element.getElementsByTagName("critical").item(0).getTextContent()));

                computerParts.add(computerPart);
            }
        }
        return computerParts;
    }
}
