package com.company.controller;

import com.company.dao.ProductDAO;
import com.company.dao.ProductDAOException;
import com.company.entities.Product;
import com.company.services.ProductDAOImpl;

import java.util.List;
import java.util.Scanner;

public abstract class ProductController {
    private Scanner input;
    public List<Product> productList;
    private ProductDAOImpl productDAO;

    private void addProduct() {
        while (true) {
            Product product = new Product();

            System.out.println("\nInput id: ");
            product.setId(input.nextInt());
            System.out.println("\nInput quantity: ");
            product.setQuantity(input.nextInt());
            System.out.println("\nInput supplier name: ");
            product.setSupplierName(input.nextLine());
            System.out.println("\nInput article: ");
            product.setArticle(input.nextLine());
            System.out.println("\nInput name: ");
            product.setName(input.nextLine());
            System.out.println("\nInput price: ");
            product.setPrice(input.nextFloat());

            productDAO.addProduct(product);

            System.out.println("Add more [y/n] ?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAllProducts() {
        System.out.println("\n\t - Catalog - \n");
        System.out.println("id\t\t" + "Article\t\t" + "Name\t\t" + "Supplier name\t\t" + "Price($)\t\t" + "Quantity\t\t");
        for (Product p : productDAO.selectAllProduct(productList)) {
            System.out.println(p.getId() + "\t\t" + p.getArticle() + "\t\t" + p.getName() + "\t\t" + p.getSupplierName() + "\t\t" +
            p.getPrice() + "\t\t" + p.getQuantity());
        }
    }

    private void productById () {
        System.out.println("Input id for searching product: ");
        Product p = productDAO.productById(input.nextInt());
        System.out.println(p.getId() + "\t" + p.getArticle() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getQuantity());
    }

    private void removeProduct () {
        showAllProducts();
        System.out.println("Enter product id for delete: ");
        productDAO.removeProductById(input.nextInt());
    }

    public void searchProduct() {
        System.out.println("Enter attribute for searching: ");
        for (Product p : productDAO.searchProduct(input.next())){
            System.out.println(p.getId() + "\t" + p.getArticle() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getQuantity());
        }
    }

    private void productMenu(){
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Get product by id");
        System.out.println("4. Show all products");
        System.out.println("5. Search products by attributes");
        System.out.println("6. Upload product data");
        System.out.println("7. Exit");
    }

    public void productProcess() throws ProductDAOException {
        while (true) {
            productMenu();
            switch (input.nextInt()){
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    productById();
                    break;
                case 4:
                    showAllProducts();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
