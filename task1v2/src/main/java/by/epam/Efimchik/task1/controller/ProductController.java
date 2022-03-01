package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.ProductDAOImpl;
import by.epam.Efimchik.task1.entities.Product;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private Scanner input = new Scanner(System.in);
    public ProductDAOImpl productDAO = new ProductDAOImpl();

    private void addProduct() {
        while (true) {
            Product product = new Product();

            System.out.println("\nInput id: ");
            product.setProductId(input.nextInt());
            System.out.println("Input supplier name: ");
            product.setSupplierName(input.next());
            System.out.println("Input article: ");
            product.setArticle(input.next());
            System.out.println("Input name: ");
            product.setName(input.next());
            System.out.println("Input price: ");
            product.setProductPrice(input.nextFloat());

            productDAO.add(product);

            System.out.println("Add more [y/n] ?");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void updateProduct() throws DAOException {
        showAllProducts();
        System.out.println("Select product id to update: ");
        int id = input.nextInt();
        System.out.println("\nInput new id: ");
        int updateId = input.nextInt();
        System.out.println("Input new article: ");
        String updateArticle = input.next();
        System.out.println("Input new name: ");
        String updateName = input.next();
        System.out.println("Input supplier name: ");
        String updateSupplierName = input.next();
        System.out.println("Input new quantity: ");
        int updateQuantity = input.nextInt();
        System.out.println("Input new price: ");
        float updatePrice = input.nextFloat();

        /*for (Product product : productDAO.allProducts()) {
            if (product.getId() == id) {
                productDAO.update(product, new String[]{String.valueOf(updateId), updateArticle,
                        updateName, updateSupplierName, String.valueOf(updateQuantity), String.valueOf(updatePrice)});
            }
        }*/
    }

    public void showAllProducts() {
        System.out.println("\n\t - Catalog - \n");
        /*for (Product p : productDAO.allProducts().stream().distinct().collect(Collectors.toList())) {
            System.out.println("Article: " + p.getArticle() + "\nName: " + p.getName() + "\nSupplier name: " + p.getSupplierName() +
                    "\nPrice($): " + p.getPrice() + "\nQuantity: " + p.getQuantity() + "\n");
        }*/
    }

    private void productById() {
        System.out.println("Input id for searching product: ");
        //Product p = productDAO.productById(input.nextInt());
        //System.out.println(p.getId() + "\n" + p.getArticle() + "\n" + p.getName() + "\n" + p.getSupplierName() + "\n" + p.getPrice() + "\n" + p.getQuantity() + "\n");
    }

    private void removeProduct() {
        showAllProducts();
        System.out.println("Enter product id for delete: ");
        //productDAO.(input.nextInt());
    }

    public void backToMenu() throws DAOException, IOException {
        AdminController adminController = new AdminController();
        adminController.menu();
    }

    public void searchProduct() {
        System.out.println("Enter attribute for searching: ");
        for (Product p : productDAO.search(input.next())) {
            System.out.println(p.getArticle() + "\n" + p.getName() + "\n" + p.getSupplierName() + "\n" + p.getProductPrice() + "\n");
        }
    }

    private void productMenu() {
        System.out.println("1. Add product");
        System.out.println("2. Update product");
        System.out.println("3. Remove product");
        System.out.println("4. Show all products");
        System.out.println("5. Get product by id");
        System.out.println("6. Search products by attributes");
        System.out.println("0. Back to menu");
    }

    public void adminProductProcess() throws DAOException, IOException {
        while (true) {
            productMenu();
            switch (input.nextInt()) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    showAllProducts();
                    break;
                case 5:
                    productById();
                    break;
                case 6:
                    searchProduct();
                    break;
                case 0:
                    backToMenu();
                    break;
            }
        }
    }
}
