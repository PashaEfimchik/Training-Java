package by.epam.efimchik.multithreading;

import by.epam.efimchik.multithreading.entity.Ferry;
import by.epam.efimchik.multithreading.exception.MyException;
import by.epam.efimchik.multithreading.thread.FerryThread;
import by.epam.efimchik.multithreading.thread.VehicleThread;
import by.epam.efimchik.multithreading.utils.InitializeFerry;
import by.epam.efimchik.multithreading.utils.InitializeVehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static List<VehicleThread> vehicleThreadList;
    private static FerryThread ferryThread;
    private static float platformLoadCapacity;
    private static float platformArea;

    {
        platformLoadCapacity = 8000;
        platformArea = 60;
    }

    public static void main(String[] args) {
        InitializeVehicle initializeVehicle = new InitializeVehicle();
        InitializeFerry initializeFerry = new InitializeFerry();
        try {
            vehicleThreadList = initializeVehicle.vehicleList("files/vehicle.xml");
            ferryThread = initializeFerry.ferryInit("files/ferry.xml");
        } catch (MyException e) {
            logger.error(e);
            e.printStackTrace();
        }
        ExecutorService vehicleService = Executors.newCachedThreadPool();
        if (vehicleThreadList != null) {
            for (VehicleThread vehicle : vehicleThreadList) {
                vehicleService.submit(vehicle);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    logger.error(e);
                    e.printStackTrace();
                }
            }
        }
        if (ferryThread != null) {
            Ferry ferry = ferryThread.getFerry();
            platformLoadCapacity = ferry.getPlatformLoadCapacity();
            platformArea = ferry.getPlatformArea();
        }
        ExecutorService ferryService = Executors.newCachedThreadPool();
        ferryService.submit(FerryThread.getInstance(platformLoadCapacity, platformArea));
        ferryService.shutdown();
        vehicleService.shutdown();
    }
}
