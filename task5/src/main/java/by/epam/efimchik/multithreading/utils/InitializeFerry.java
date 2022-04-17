package by.epam.efimchik.multithreading.utils;

import by.epam.efimchik.multithreading.controller.FerryController;
import by.epam.efimchik.multithreading.controller.VehicleController;
import by.epam.efimchik.multithreading.entity.Ferry;
import by.epam.efimchik.multithreading.exception.MyException;
import by.epam.efimchik.multithreading.thread.FerryThread;
import by.epam.efimchik.multithreading.thread.VehicleThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class InitializeFerry {
    private final Logger logger = LogManager.getLogger();

    public FerryThread ferryInit (String filename) throws MyException {
        FerryController ferryController = new FerryController();
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(ferryController);
            xmlReader.parse(ClassLoader.getSystemResource(filename).getFile());
        } catch (ParserConfigurationException e) {
            logger.error("Ferry | Parsing failure.");
            throw new MyException("Ferry | Parsing failure.", e);
        } catch (IOException ioException) {
            logger.error("Ferry | Wrong filename/filepath.");
            throw new MyException("Ferry | Wrong filename/filepath", ioException);
        } catch (SAXException e) {
            logger.error("Ferry | SAX Parsing failure.");
            throw new MyException("Ferry | SAX Parsing failure.", e);
        }
        catch (Exception e){
            throw new MyException("Ferry | Unexpected error with path: " + filename, e);
        }
        logger.info("Ferry | Ferry parsed successfully");
        return ferryController.getFerryThread();
    }
}
