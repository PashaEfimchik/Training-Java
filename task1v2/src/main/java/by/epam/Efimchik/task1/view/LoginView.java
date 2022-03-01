package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.UserDAOImpl;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.UserService;

import java.io.IOException;
import java.util.Scanner;

public class LoginView {
    UserService userService = new UserService();
    UserDAOImpl userDAO = new UserDAOImpl();
    UserView userView = new UserView();
    Scanner input = new Scanner(System.in);

    public void registerUser() throws DAOException, IOException {
        System.out.println(" - Register new User -");
        while (true) {
            User user = new User();
            System.out.println("\nInput id: ");
            user.setUserId(input.nextInt());
            System.out.println("\nInput e-mail: ");
            String email = input.next();
            if (userService.isValidEmail(email) && !userDAO.isEmailExist(email)) {
                user.setEmail(email);
            }
            else {
                System.out.println("User with this email already exists.");
            }
            System.out.println("\nInput username: ");
            String username = input.next();
            if (userService.isValidUsername(username) && !userDAO.isUsernameExist(username)) {
                user.setUsername(username);
            }
            else {
                System.out.println("User with this username already exists.");
            }
            System.out.println("\nInput password: ");
            String password = input.next();
            if (userService.isValidPassword(password)) {
                user.setPassword(password);
            }

            userService.addUser(user);

            System.out.println("Add more [y/n] ?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
            if (userService.showAllUsers().contains(user)) {
                user.setUserSession(true);
                userView.userMenu(user);
            }
        }
    }

    public void loginUser() throws DAOException, IOException {
        System.out.println("Enter username: ");
        String username = input.next();
        if (userDAO.isUsernameExist(username)) {
            System.out.println("Enter password: ");
            String password = input.next();
            if (userDAO.isPasswordExist(username, password)){
                System.out.println("User successfully logged in");
                User user = userService.searchUser(username, password);
                if (userService.showAllUsers().contains(user)) {
                    user.setUserSession(true);
                    userView.userMenu(user);
                }
            }
        }
    }
}
