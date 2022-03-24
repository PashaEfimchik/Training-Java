package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.UserDAOImpl;
import by.epam.Efimchik.task1.services.UserService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class ValidData {
    final Logger logger = Logger.getLogger(UserView.class);
    private UserService userService = new UserService();
    private UserDAOImpl userDAO = new UserDAOImpl();
    private Scanner input = new Scanner(System.in);

    public ValidData() throws IOException, ClassNotFoundException {
    }

    public int isValidInteger(String id) {
        while (true) {
            if (id.matches("[-+]?\\d++")) {
                return Integer.parseInt(id);
            }
            else {
                logger.info("Wrong input. Value must be an integer! Try again. . .");
                id = input.next();
            }
        }
    }

    public int isValidUserId(int id) throws DAOException {
        while (true) {
            if (!userService.isValidId(id)) {
                return id;
            }
            else {
                logger.info("User with this ID already exists.");
                logger.info("Enter ID again: ");
                id = isValidInteger(input.next());
            }
        }
    }

    public String isValidEmail(String email) throws DAOException {
        while (true) {
            if (userService.isValidEmail(email)) {
                if (!userDAO.isEmailExist(email)) {
                    return email;
                }
                else {
                    logger.info("User with this E-mail already exists.");
                    logger.info("Enter E-mail again: ");
                    email = input.next();
                }
            } else {
                logger.info("E-mail entered incorrectly.");
                logger.info("Enter E-mail again: ");
                email = input.next();
            }
        }
    }

    public String isValidUsername(String username) throws DAOException {
        while (true) {
            if (userService.isValidUsername(username)) {
                if (!userDAO.isUsernameExist(username)) {
                    return username;
                }
                else {
                    logger.info("User with this username already exists.");
                    logger.info("Enter username again: ");
                    username = input.next();
                }
            } else {
                logger.info("Username entered incorrectly");
                logger.info("Username must be 6 characters or more.");
                logger.info("Enter username again: ");
                username = input.next();
            }
        }
    }

    public String isValidPassword(String password) throws DAOException {
        while (true) {
            if (userService.isValidPassword(password)) {
                return password;
            }
            else {
                logger.info("Password entered incorrectly.");
                logger.info("Password must contain at least 8 and no more than 20 upper and lower case characters and numbers");
                logger.info("Enter password again");
                password = input.next();
            }
        }
    }
}
