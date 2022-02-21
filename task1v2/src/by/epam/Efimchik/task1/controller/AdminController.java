package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.dao.ProductDAOException;
import by.epam.Efimchik.task1.dao.UserDAOException;

import java.io.IOException;
import java.util.Scanner;

public class AdminController {
    private Scanner input = new Scanner(System.in);
    private ProductController productController = new ProductController();
    private UserController userController = new UserController();

    private void logout() throws ProductDAOException, IOException, UserDAOException {
        LoginController loginController = new LoginController();
        loginController.logout();
    }

    public void menu() throws UserDAOException, ProductDAOException, IOException {
        while (true){
            System.out.println("1. User menu\n2. Product menu\n3. Logout");
            switch (input.nextInt()){
                case 1:
                    userController.adminUserProcess();
                    break;
                case 2:
                    productController.adminProductProcess();
                    break;
                case 3:
                    logout();
                    break;
            }
        }
    }
}