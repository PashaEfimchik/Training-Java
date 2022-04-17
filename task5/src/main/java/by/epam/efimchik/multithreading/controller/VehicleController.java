package by.epam.efimchik.multithreading.controller;

import by.epam.efimchik.multithreading.entity.Vehicle;
import by.epam.efimchik.multithreading.entity.VehicleType;
import by.epam.efimchik.multithreading.thread.VehicleThread;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static by.epam.efimchik.multithreading.entity.VehicleType.CAR;
import static by.epam.efimchik.multithreading.entity.VehicleType.TRUCK;

public class VehicleController extends DefaultHandler {
    private VehicleType vehicleType;
    private static long id;
    private float weight;
    private float square;
    private String currentElement;
    private List<VehicleThread> vehicleThreadList;

    {
        id = 0;
        vehicleThreadList = new ArrayList<>();
    }

    public List<VehicleThread> getVehicleThreadList() {
        return vehicleThreadList;
    }

    private static long getAutoId() {
        long currentId = id;
        id++;
        return currentId;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (currentElement) {
            case "type":
                if (new String(ch, start, length).equalsIgnoreCase(CAR.toString())) {
                    vehicleType = CAR;
                } else {
                    vehicleType = TRUCK;
                }
                break;
            case "weight":
                weight = Float.parseFloat(new String(ch, start, length));
                break;
            case "square":
                square = Float.parseFloat(new String(ch, start, length));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equals("vehicle")) {
            vehicleThreadList.add(new VehicleThread(new Vehicle(getAutoId(), vehicleType, weight, square)));
        }    }
}
