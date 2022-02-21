package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.dao.ProductDAOException;
import by.epam.Efimchik.task1.dao.UserDAOException;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.UserDAOImpl;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserController {
    private Scanner input = new Scanner(System.in);
    private static UserDAOImpl userDAO = new UserDAOImpl();

    private void addUser() throws UserDAOException {
        while (true) {
            User user = new User();
            System.out.println("\nInput id: ");
            user.setId(input.nextInt());
            System.out.println("\nInput e-mail: ");
            user.setEmail(input.next());
            System.out.println("\nInput username: ");
            user.setUsername(input.next());
            System.out.println("\nInput password: ");
            user.setPassword(input.next());

            userDAO.add(user);

            System.out.println("Add more [y/n] ?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void userById () {
        System.out.println("Input id for searching user: ");
        User user = userDAO.userById(input.nextInt());
        System.out.println(user.getId() + "\n" + user.getEmail() + "\n" + user.getUsername() + "\n" + user.getPassword() + "\n");
    }

    private void showAllUsers() {
        System.out.println("\n\t - Users - \n");
        for (User user : userDAO.allUsers().stream().distinct().collect(Collectors.toList())){
            System.out.println("id: " + user.getId() + "\nE-mail: " + user.getEmail() + "\nUsername: " + user.getUsername() +
                    "\nPassword: " + user.getPassword() + "\n");
        }
    }

    private void removeUser(){
        showAllUsers();
        System.out.println("Enter user id for deleted: ");
        userDAO.remove(input.nextInt());
    }

    public void backToMenu () throws ProductDAOException, IOException, UserDAOException {
        AdminController adminController = new AdminController();
        adminController.menu();
    }

    private void adminUserMenu() {
        System.out.println("1. Add user");
        System.out.println("2. Remove user");
        System.out.println("3. Get user by id");
        System.out.println("4. Show all users");
        System.out.println("0. Back to menu");
    }

    public void adminUserProcess() throws UserDAOException, ProductDAOException, IOException {
        while (true) {
            adminUserMenu();
            switch (input.nextInt()){
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    userById();
                    break;
                case 4:
                    showAllUsers();
                    break;
                case 0:
                    backToMenu();
                    break;
            }
        }
    }
}
