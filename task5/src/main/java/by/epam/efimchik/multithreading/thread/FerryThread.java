package by.epam.efimchik.multithreading.thread;

import by.epam.efimchik.multithreading.entity.Ferry;
import by.epam.efimchik.multithreading.entity.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class FerryThread implements Runnable{
    private final Logger logger = LogManager.getLogger();
    private static FerryThread instance;
    private static AtomicBoolean isCreated = new AtomicBoolean();
    private static ReentrantLock lock = new ReentrantLock();
    private Ferry ferry;
    private CopyOnWriteArrayList<VehicleThread> newVehicles = new CopyOnWriteArrayList<>();

    public Ferry getFerry() {
        return ferry;
    }

    public FerryThread(Ferry ferry) {
        this.ferry = ferry;
    }

    public void newVehicleWait (VehicleThread vehicleThread) {
        newVehicles.add(vehicleThread);
        while (vehicleThread.getVehicle().getState() != State.TRANSPORTED) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                logger.error(e);
                e.printStackTrace();
            }
        }
        for (VehicleThread vehicle : newVehicles) {
            if (vehicle.getVehicle().getState() == State.TRANSPORTED) {
                newVehicles.remove(vehicle);
            }
        }
    }

    public static FerryThread getInstance(float platformLoadCapacity, float platformArea) {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if(instance==null){
                    instance=new FerryThread(new Ferry(platformLoadCapacity, platformArea));
                    isCreated.set(true);
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    @Override
    public void run() {
        while (newVehicles.size() > 0) {
            float currentLoadCapacity = ferry.getPlatformLoadCapacity();
            float currentArea = ferry.getPlatformArea();
            int loadedCarsIndex = 0;
            while (true) {
                for (VehicleThread vehicleThread : newVehicles) {
                    if (vehicleThread.getVehicle().getState() == State.LOADED) {
                        continue;
                    }
                    if (currentLoadCapacity >= vehicleThread.getVehicle().getWeight() && currentArea >= vehicleThread.getVehicle().getSquare()) {
                        vehicleThread.getVehicle().setState(State.LOADED);
                        logger.info("Vehicle №" + vehicleThread.getVehicle().getId() + " - was loaded on a ferry.");
                        currentLoadCapacity -= vehicleThread.getVehicle().getWeight();
                        currentArea -= vehicleThread.getVehicle().getSquare();
                    } else {
                        logger.info("Vehicle №" + vehicleThread.getVehicle().getId() + " - not suitable on a ferry.");
                    }
                }
                int currentLoadedCarsIndex = 0;
                for (VehicleThread vehicle : newVehicles) {
                    if (vehicle.getVehicle().getState() == State.LOADED)
                        currentLoadedCarsIndex++;
                }
                if (loadedCarsIndex == currentLoadedCarsIndex) {
                    break;
                } else {
                    loadedCarsIndex = currentLoadedCarsIndex;
                }
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    logger.error(e);
                }
            }
            logger.info("The ferry set off!");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                logger.error(e);
                e.printStackTrace();
            }
            logger.info("The ferry is on the other side!");
            for (VehicleThread vehicleThread : newVehicles) {
                if (vehicleThread.getVehicle().getState() == State.LOADED) {
                    vehicleThread.getVehicle().setState(State.TRANSPORTED);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                logger.error(e);
            }
            logger.info("The ferry is back and ready for loading!");
        }
    }
}
