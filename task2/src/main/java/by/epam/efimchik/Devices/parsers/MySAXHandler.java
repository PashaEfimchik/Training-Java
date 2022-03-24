package by.epam.efimchik.Devices.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandler extends DefaultHandler {
    final Logger logger = LogManager.getLogger();
    private boolean foundId = false;
    private boolean foundName = false;
    private boolean foundOrigin = false;
    private boolean foundPrice = false;
    private boolean foundPeripheral = false;
    private boolean foundPowerUsage = false;
    private boolean foundCooler = false;
    private boolean foundGroup = false;
    private boolean foundPort = false;
    private boolean foundCritical = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        logger.info("Start - " + qName);

        if ("id".equals(qName)) {
            foundId = true;
        }

        if ("name".equals(qName)) {
            foundName = true;
        }

        if ("origin".equals(qName)) {
            foundOrigin = true;
        }

        if ("price".equals(qName)) {
            foundPrice = true;
        }

        if ("peripheral".equals(qName)) {
            foundPeripheral = true;
        }

        if ("powerUsage".equals(qName)) {
            foundPowerUsage = true;
        }

        if ("cooler".equals(qName)) {
            foundCooler = true;
        }

        if ("group".equals(qName)) {
            foundGroup = true;
        }

        if ("port".equals(qName)) {
            foundPort = true;
        }

        if ("critical".equals(qName)) {
            foundCritical = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        logger.info("End - " + qName + "\n");
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if(foundId){
            logger.info("id: " + new String(ch, start, length));
            foundId = false;
        }
        if(foundName){
            logger.info("name: " + new String(ch, start, length));
            foundName = false;
        }
        if(foundOrigin){
            logger.info("origin: " + new String(ch, start, length));
            foundOrigin = false;
        }
        if(foundPrice){
            logger.info("price: " + new String(ch, start, length));
            foundPrice = false;
        }
        if(foundPeripheral){
            logger.info("peripheral: " + new String(ch, start, length));
            foundPeripheral = false;
        }
        if(foundPowerUsage){
            logger.info("power usage: " + new String(ch, start, length));
            foundPowerUsage = false;
        }
        if(foundCooler){
            logger.info("cooler: " + new String(ch, start, length));
            foundCooler = false;
        }
        if(foundGroup){
            logger.info("group: " + new String(ch, start, length));
            foundGroup = false;
        }
        if(foundPort){
            logger.info("port: " + new String(ch, start, length));
            foundPort = false;
        }
        if(foundCritical){
            logger.info("critical: " + new String(ch, start, length));
            foundCritical = false;
        }

    }
}
