package by.epam.efimchik.multithreading.controller;

import by.epam.efimchik.multithreading.thread.FerryThread;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FerryController extends DefaultHandler {
    private float platformLoadCapacity;
    private float platformArea;
    private String currentElement;
    private FerryThread ferryThread;

    public FerryController() {
    }

    public FerryThread getFerryThread() {
        return ferryThread;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("platformLoadCapacity")) {
            platformLoadCapacity = Float.parseFloat(new String(ch, start, length));
        } else if (currentElement.equals("platformArea")) {
            platformArea = Float.parseFloat(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equals("ferry")) {
            ferryThread = FerryThread.getInstance(platformLoadCapacity, platformArea);
        }
    }
}
