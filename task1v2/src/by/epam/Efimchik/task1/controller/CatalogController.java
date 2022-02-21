package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.dao.ProductDAOException;
import by.epam.Efimchik.task1.dao.UserDAOException;

import java.io.IOException;
import java.util.Scanner;

public class CatalogController extends ProductController{
    Scanner input = new Scanner(System.in);
    public CartController cartController;

    public CatalogController () {
        cartController = new CartController();
    }

    public void showAllProducts() {
        super.showAllProducts();
    }

    public void searchProductByAttribute() {
        super.searchProduct();
    }

    public void showCart() {}

    public void printCatalogMenu() {
        System.out.println(" - Catalog menu - ");
        System.out.println("1. Show all products");
        System.out.println("2. Search product by attribute");
        System.out.println("3. Show cart");
        System.out.println("0. Logout");
    }

    public void logout() throws ProductDAOException, IOException, UserDAOException {
        LoginController loginController = new LoginController();
        loginController.logout();
    }

    public void catalogMenu() throws IOException, UserDAOException, ProductDAOException {
        while (true){
            printCatalogMenu();
            switch (input.nextInt()){
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    searchProductByAttribute();
                    break;
                case 3:
                    showCart();
                    break;
                case 0:
                    logout();
                    break;
                default:
                    System.out.println("Wrong item selected. Try again");
            }
        }
    }

}
