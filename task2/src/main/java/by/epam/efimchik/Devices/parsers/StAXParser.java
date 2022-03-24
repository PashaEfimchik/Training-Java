package by.epam.efimchik.Devices.parsers;

import by.epam.efimchik.Devices.entity.ComputerPart;
import by.epam.efimchik.Devices.entity.Group;
import by.epam.efimchik.Devices.entity.Peripheral;
import by.epam.efimchik.Devices.entity.Port;
import lombok.NonNull;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    public List<ComputerPart> readXMLStaxParser (){
        List<ComputerPart> computerParts = new ArrayList<>();
        ComputerPart computerPart = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream("src/main/resources/computers.xml"));

            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    @NonNull StartElement startElement = xmlEvent.asStartElement();
                    if("device".equals(startElement.getName().getLocalPart())) {
                        computerPart = new ComputerPart();
                        computerPart.setId(Integer.parseInt(startElement.getAttributeByName(new QName("id")).getValue()));
                    }
                    else if ("name".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setName(xmlEvent.asCharacters().getData());
                    }
                    else if ("origin".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setOrigin(xmlEvent.asCharacters().getData());
                    }
                    else if ("price".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setPrice(Float.parseFloat(xmlEvent.asCharacters().getData()));
                    }
                    else if ("peripheral".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setPeripheral(Peripheral.valueOf(xmlEvent.asCharacters().getData()));
                    }
                    else if ("powerUsage".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setPowerUsage(Float.parseFloat(xmlEvent.asCharacters().getData()));
                    }
                    else if ("cooler".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setCooler(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                    }
                    else if ("group".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setGroup(Group.valueOf(xmlEvent.asCharacters().getData()));
                    }
                    else if ("port".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setPort(Port.valueOf(xmlEvent.asCharacters().getData()));
                    }
                    else if ("critical".equals(startElement.getName().getLocalPart())) {
                        xmlEvent = xmlEventReader.nextEvent();
                        computerPart.setCritical(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if("device".equals(endElement.getName().getLocalPart())){
                        computerParts.add(computerPart);
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return computerParts;
    }
}
