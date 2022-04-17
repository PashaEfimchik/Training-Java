package by.epam.efimchik.multithreading.utils;

import by.epam.efimchik.multithreading.controller.VehicleController;
import by.epam.efimchik.multithreading.exception.MyException;
import by.epam.efimchik.multithreading.thread.VehicleThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.List;

public class InitializeVehicle {
    private final Logger logger = LogManager.getLogger();

    public List<VehicleThread> vehicleList (String filename) throws MyException {
        VehicleController vehicleController = new VehicleController();
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(vehicleController);
            xmlReader.parse(ClassLoader.getSystemResource(filename).getFile());
        } catch (ParserConfigurationException e) {
            logger.error("Vehicle | Parsing failure.");
            throw new MyException("Vehicle | Parsing failure.", e);
        } catch (IOException ioException) {
            logger.error("Vehicle | Wrong filename/filepath.");
            throw new MyException("Vehicle | Wrong filename/filepath", ioException);
        } catch (SAXException e) {
            logger.error("Vehicle | SAX Parsing failure.");
            throw new MyException("Vehicle | SAX Parsing failure.", e);
        }
        catch (Exception e){
            throw new MyException("Vehicle | Unexpected error with path: " + filename, e);
        }
        logger.info("Vehicle | Vehicles parsed successfully");
        return vehicleController.getVehicleThreadList();
    }
}
