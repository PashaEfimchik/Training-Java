package by.epam.efimchik.Devices;

import by.epam.efimchik.Devices.parsers.DOMParser;
import by.epam.efimchik.Devices.view.Menu;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Menu menu = new Menu();

        menu.mainMenu();
    }
}
