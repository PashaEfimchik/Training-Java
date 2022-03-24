package by.epam.efimchik.Devices.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ValidData {
    final Logger logger = LogManager.getLogger(ValidData.class);
    private Scanner input = new Scanner(System.in);

    public ValidData(){}

    public int isValidInteger(String integer) {
        while (true) {
            if(integer.matches("[+-]?\\d++")) {
                return Integer.parseInt(integer);
            }
            else {
                logger.warn("Wrong input. Value must be an integer! Try again. . .");
                integer = input.next();
            }
        }
    }
}
