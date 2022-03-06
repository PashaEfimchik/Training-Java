package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.UserDAOImpl;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.UserService;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class LoginView {
    final Logger logger = Logger.getLogger(LoginView.class);
    private UserService userService = new UserService();
    private UserDAOImpl userDAO = new UserDAOImpl();
    private ValidData validData = new ValidData();
    private UserView userView = new UserView();
    private Scanner input = new Scanner(System.in);

    public LoginView() throws IOException, ClassNotFoundException {
    }

    public void registerUser() throws DAOException, IOException, ClassNotFoundException {
        logger.info(" - Sign up new User - ");
        User user = new User();

        logger.info("Enter id: ");
        user.setUserId(validData.isValidInteger(input.next()));

        logger.info("Enter e-mail: ");
        user.setEmail(validData.isValidEmail(input.next()));

        logger.info("Enter username: ");
        user.setUsername(validData.isValidUsername(input.next()));

        logger.info("Enter password: ");
        user.setPassword(validData.isValidPassword(input.next()));

        userService.addUser(user);

        if (userService.showAllUsers().contains(user)) {
            user.setUserSession(true);
            userView.userMenu(user);
        }
    }



    public void loginUser() throws DAOException, IOException, ClassNotFoundException {
        logger.info("Enter username: ");
        String username = input.next();
        if (userDAO.isUsernameExist(username) && !userDAO.isAdminUsername(username)) {
            logger.info("Enter password: ");
            String password = input.next();
            if (userDAO.isPasswordExist(username, password)) {
                logger.info("User - " + username + " - successfully logged in\n");
                User user = userService.searchUser(username, password);
                if (userService.showAllUsers().contains(user)) {
                    user.setUserSession(true);
                    userView.userMenu(user);
                }
            }
        }
        if (userDAO.isAdminUsername(username)) {
            logger.info("Enter password: ");
            String password = input.next();
            if (userDAO.isAdminPassword(password)) {
                logger.info("Admin successfully logged in\n");
                EmployeeMenuView employeeMenuView = new EmployeeMenuView();
                employeeMenuView.adminMenu();
            }
        }
    }
}
