package by.epam.efimchik.Devices.view;

import by.epam.efimchik.Devices.parsers.DOMParser;
import by.epam.efimchik.Devices.parsers.SAXParser;
import by.epam.efimchik.Devices.parsers.StAXParser;
import by.epam.efimchik.Devices.utils.ValidData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static Logger logger = LogManager.getLogger();
    private Scanner input = new Scanner(System.in);
    private ValidData validData = new ValidData();

    public void mainMenu() throws ParserConfigurationException, IOException, SAXException {
        while (true){
            logger.info("1. DOM parser");
            logger.info("2. SAX parser");
            logger.info("3. StAX parser");
            logger.info("0. Exit");
            switch (validData.isValidInteger(input.next())) {
                case 1:
                    DOMParserMenu();
                    break;
                case 2:
                    SAXParserMenu();
                    break;
                case 3:
                    StAXParserMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    logger.warn("Wrong choice. Try again. . .\n");
            }
        }
    }

    public void DOMParserMenu() throws ParserConfigurationException, IOException, SAXException {
        while (true) {
            logger.info("1. Read XML file");
            logger.info("2. Back");
            switch (validData.isValidInteger(input.next())) {
                case 1:
                    DOMParser domParser = new DOMParser();
                    ShowData showData = new ShowData();
                    showData.showParserData(domParser.readXmlDomParser());
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    logger.warn("Wrong choice. Try again. . .\n");
            }
        }
    }

    public void SAXParserMenu() throws ParserConfigurationException, IOException, SAXException {
        while (true) {
            logger.info("1. Read XML file");
            logger.info("2. Back");
            switch (validData.isValidInteger(input.next())) {
                case 1:
                    SAXParser saxParser = new SAXParser();
                    saxParser.readXMLSaxParser();
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    logger.warn("Wrong choice. Try again. . .");
            }
        }
    }

    public void StAXParserMenu() throws ParserConfigurationException, IOException, SAXException {
        while (true) {
            logger.info("1. Read XML file");
            logger.info("2. Back");
            switch (validData.isValidInteger(input.next())) {
                case 1:
                    StAXParser stAXParser = new StAXParser();
                    ShowData showData = new ShowData();
                    showData.showParserData(stAXParser.readXMLStaxParser());
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    logger.warn("Wrong choice. Try again. . .");
            }
        }
    }

}
