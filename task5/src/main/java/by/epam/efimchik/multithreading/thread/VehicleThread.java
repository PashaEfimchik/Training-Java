package by.epam.efimchik.multithreading.thread;

import by.epam.efimchik.multithreading.entity.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VehicleThread implements Runnable{
    private final Logger logger = LogManager.getLogger();
    private Vehicle vehicle;

    public VehicleThread(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        logger.info("Vehicle №" + vehicle.getId() + " - drove up to the Ferry");
        FerryThread.getInstance(8000, 60).newVehicleWait(this);
        logger.info("Vehicle №" + vehicle.getId() + " - was transported.");
    }
}
