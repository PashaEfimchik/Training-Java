package by.epam.efimchik.Devices.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParser {
    final Logger logger = LogManager.getLogger();

    public void readXMLSaxParser() {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler defaultHandler = new MySAXHandler();

            File file = new File("src/main/resources/computers.xml");
            saxParser.parse(file, defaultHandler);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
