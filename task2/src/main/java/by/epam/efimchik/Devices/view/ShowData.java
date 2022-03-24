package by.epam.efimchik.Devices.view;

import by.epam.efimchik.Devices.entity.ComputerPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShowData {
    final Logger logger = LogManager.getLogger();

    public void showParserData(List<ComputerPart> computerParts) {
        if (!computerParts.isEmpty()) {
            for (var device : computerParts) {
                logger.info("Device id: " + device.getId());
                logger.info("Device name: " + device.getName());
                logger.info("Device origin: " + device.getOrigin());
                logger.info("Device price: " + device.getPrice());
                logger.info("Device type:");
                logger.info("\tDevice peripheral: " + device.getPeripheral());
                logger.info("\tDevice power usage: " + device.getPowerUsage());
                logger.info("\tDevice cooler: " + device.isCooler());
                logger.info("\tDevice group: " + device.getGroup());
                logger.info("\tDevice port: " + device.getPort());
                logger.info("Device critical: " + device.isCritical() + "\n");
            }
        }
        else{
            logger.warn("List is empty");
        }
    }
}
