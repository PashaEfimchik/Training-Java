package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.ProductService;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

public class ProductView {
    final Logger logger = Logger.getLogger(ProductView.class);
    Scanner input = new Scanner(System.in);
    ProductService productService = new ProductService();
    CartView cartView = new CartView();

    public ProductView() throws IOException, ClassNotFoundException {
    }

    public void showProducts() throws DAOException {
        logger.info(" - Catalog -\n");
        for (var product : productService.showAllProducts().stream().distinct().collect(Collectors.toList())) {
            logger.info("Product ID: " + product.getProductId());
            logger.info("Article: " + product.getArticle());
            logger.info("Name: " + product.getName());
            logger.info("Supplier name: " + product.getSupplierName());
            logger.info("Price(BYN): " + product.getProductPrice() + "\n");
        }
    }

    public void showUserProducts(User user) throws DAOException, IOException, ClassNotFoundException {
        if (user.isUserSession()) {
            addProductToCart(user);
        }
        else {
            logger.info("Login to continue");
        }
    }

    public void searchProduct() throws DAOException {
        logger.info("Enter attribute for searching product: ");
        for (var product : productService.searchProduct(input.next())) {
            logger.info("Product ID: " + product.getProductId());
            logger.info("Article: " + product.getArticle());
            logger.info("Name: " + product.getName());
            logger.info("Supplier name: " + product.getSupplierName());
            logger.info("Price(BYN): " + product.getProductPrice() + "\n");
        }
    }

    public void addProductToCart(User user) throws DAOException, IOException, ClassNotFoundException {
        showProducts();
        logger.info("1. Add to cart");
        logger.info("2. Back");
        int select = input.nextInt();
        switch (select) {
            case 1:
                logger.info("Input product ID for added to cart: ");
                var productId = input.nextInt();
                for (var product : productService.showAllProducts()) {
                    if (product.getProductId() == productId) {
                        logger.info("Enter quantity of products: ");
                        var quantity = input.nextInt();
                        if (quantity > 0) {
                            cartView.addProductToCart(quantity, user, product);
                        } else {
                            logger.info("Quantity product items must be greater than 0");
                        }
                        break;
                    }
                }
                break;
            case 2:
                UserView userView = new UserView();
                userView.userMenu(user);
                break;
        }
    }
}
