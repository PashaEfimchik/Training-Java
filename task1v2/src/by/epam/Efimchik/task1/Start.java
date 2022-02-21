package by.epam.Efimchik.task1;

import by.epam.Efimchik.task1.controller.LoginController;
import by.epam.Efimchik.task1.controller.ProductController;
import by.epam.Efimchik.task1.dao.ProductDAOException;
import by.epam.Efimchik.task1.dao.UserDAOException;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public void startMenu() throws IOException, UserDAOException, ProductDAOException {
        Scanner input = new Scanner(System.in);
        LoginController login = new LoginController();
        ProductController productController = new ProductController();

        while (true) {
            System.out.println("1. Show catalog\n2. Search product\n3. Sign in\n4. Sign up\n0. Exit");
            switch (input.nextInt()){
                case 1:
                    productController.showAllProducts();
                    break;
                case 2:
                    productController.searchProduct();
                    break;
                case 3:
                    login.login();
                    break;
                case 4:
                    login.register();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong item selected. Try again");
            }
        }
    }
}
