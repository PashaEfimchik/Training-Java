package com.company.controller;

import com.company.entities.Product;
import com.company.services.ProductDAOImpl;
import com.company.utils.InitializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogController {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    Scanner input = new Scanner(System.in);
    public CartController cartController;
    InitializationUtil initialize = new InitializationUtil();
    List<Product> productList = new ArrayList<>();

    public CatalogController () {
        cartController = new CartController();
    }

    public void showAllProducts() {
        initialize.uploadProducts(productList);
        productDAO.selectAllProduct(productList);
    }

    public void addToCart() {}

    public void searchProductByAttribute() {
        System.out.println("Enter attribute for searching product: ");
        String attribute = (new Scanner(System.in).nextLine());
        productDAO.searchProduct(attribute);
    }

    public void showCart() {}

    public void logout() {}

    public void printCatalogMenu() {
        System.out.println(" - Catalog menu - ");
        System.out.println("1. Show all products");
        System.out.println("2. Search product by attribute");
        System.out.println("3. Show cart");
        System.out.println("0. Logout");
    }

    public void catalogMenu() {
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
                    break;
                default:
                    System.out.println("Wrong item selected. Try again");
            }
        }
    }

}
