package by.epam.efimchik.Information_handling;

import by.epam.efimchik.Information_handling.exception.CompositeException;
import by.epam.efimchik.Information_handling.view.Application;

public class Main {

    public static void main(String[] args) throws CompositeException {
        Application application = new Application();
        application.Start();
    }
}
