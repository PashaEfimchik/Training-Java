package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.StartMenu;
import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.UserDAOImpl;
import by.epam.Efimchik.task1.entities.User;

import java.io.IOException;
import java.util.Scanner;

public class LoginController extends User {
    private String username;
    private String password;

    UserDAOImpl userDAO = new UserDAOImpl();
    CatalogController catalogController = new CatalogController();
    AdminController adminController = new AdminController();

    public void login() throws DAOException, IOException {
        System.out.println("Enter username: ");
        username = (new Scanner(System.in)).nextLine();
        System.out.println("Enter password: ");
        password = (new Scanner((System.in))).nextLine();


        if (!username.equals("") && !password.equals("")) {
            if (username.equals("admin") && password.equals("admin")) {
                adminController.menu();
            }

            for (User user : userDAO.allUsers()) {
                if (user.getUsername().contains(username) && user.getPassword().contains(password)) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        System.out.println("Successfully logged in!");
                        catalogController.showCatalogMenu();
                    }
                }
            }
        }
    }

    public void register() throws IOException, DAOException {
        User user = new User();
        System.out.println("Enter id: ");
        user.setUserId((new Scanner(System.in)).nextInt());
        System.out.println("Enter E-mail: ");
        user.setEmail((new Scanner(System.in)).next());
        System.out.println("Enter username: ");
        user.setUsername((new Scanner(System.in)).next());
        System.out.println("Enter password: ");
        user.setPassword((new Scanner(System.in)).next());

        userDAO.add(user);

        if (userDAO.allUsers().contains(user)) {
            System.out.println("User successfully registered");
            catalogController.showCatalogMenu();
        } else {
            System.out.println("User does not registered");
        }
    }

    public void logout() throws IOException, DAOException {
        StartMenu logout = new StartMenu();
        logout.startMenu();
    }
}
