package by.epam.Efimchik.task1;

import by.epam.Efimchik.task1.controller.LoginController;
import by.epam.Efimchik.task1.controller.ProductController;
import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.view.LoginView;
import by.epam.Efimchik.task1.view.ProductView;

import java.io.IOException;
import java.util.Scanner;

public class StartMenu {
    public void startMenu() throws IOException, DAOException {
        Scanner input = new Scanner(System.in);
        LoginView loginView = new LoginView();
        ProductView productView = new ProductView();

        while (true) {
            System.out.println("1. Show catalog\n2. Search product\n3. Sign in\n4. Sign up\n0. Exit");
            switch (input.nextInt()){
                case 1:
                    productView.showProducts();
                    break;
                case 2:
                    productView.searchProduct();
                    break;
                case 3:
                    loginView.loginUser();
                    break;
                case 4:
                    loginView.registerUser();
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
