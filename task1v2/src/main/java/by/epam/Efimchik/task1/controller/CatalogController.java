package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.Product;

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
        addToCart();
    }

    public void searchProductByAttribute() {
        super.searchProduct();
    }

    public Product productSelection() {
        System.out.println("Enter the product id to add to cart: ");
        int productId = input.nextInt();

        return null;
    }

    public void addToCart () {
        var selectedProduct = productSelection();
        if (selectedProduct != null) {
            System.out.println("Enter the number of products to add to the cart: ");
            int quantity = input.nextInt();
            cartController.addToCart(selectedProduct, quantity);
        }
    }

    public void printCartMenu() {
        System.out.println("1. Show cart");
        System.out.println("2. Remove cart item");
        System.out.println("3. Clear cart");
        System.out.println("4. Back to catalog");
    }

    public void showCartMenu() throws DAOException, IOException {
        while (true) {
            printCartMenu();
            switch (input.nextInt()){
                case 1:
                    cartController.showCart();
                    break;
                case 2:
                    cartController.removeCartItem();
                    break;
                case 3:
                    cartController.clearCart();
                    break;
                case 4:
                    showCatalogMenu();
                    break;
            }
        }
    }

    public void printCatalogMenu() {
        System.out.println(" - Catalog menu - ");
        System.out.println("1. Show all products");
        System.out.println("2. Search product by attribute");
        System.out.println("3. Show cart menu");
        System.out.println("0. Logout");
    }

    public void logout() throws IOException, DAOException {
        LoginController loginController = new LoginController();
        loginController.logout();
    }

    public void showCatalogMenu() throws IOException, DAOException {
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
                    showCartMenu();
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
