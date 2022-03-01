package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.ProductDAOImpl;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.CartService;
import by.epam.Efimchik.task1.services.ProductService;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductView {
    Scanner input = new Scanner(System.in);
    ProductDAOImpl productDAO = new ProductDAOImpl();
    ProductService productService = new ProductService();
    CartService cartService = new CartService();

    public void showProducts() throws DAOException {
        System.out.println(" - Catalog -\n");
        for (var product : productService.showAllProducts().stream().distinct().collect(Collectors.toList())) {
            System.out.println("Product ID: " + product.getProductId() + "\nArticle: " + product.getArticle() + "\nName: " + product.getName() + "\nSupplier name: " + product.getSupplierName() +
                    "\nPrice(BYN): " + product.getProductPrice() + "\n");
        }
    }

    public void searchProduct() throws DAOException {
        System.out.println("Enter attribute for searching product: ");
        for (Product product : productService.searchProduct(input.next())) {
            System.out.println("Product ID: " + product.getProductId() + "\nArticle: " + product.getArticle() + "\nName: " + product.getName() +
                    "\nSupplier name: " + product.getSupplierName() + "\nPrice (BYN): " + product.getProductPrice() + "\n");
        }
    }

    public void addToCart(User user) throws DAOException {
        showProducts();
        System.out.println("1. Add to cart\n2. Continue");
        var select = input.next();
        if (select.equals("1")){
            System.out.println("Input product ID for added to cart: ");
            var productId = input.nextInt();
            for (var product : productService.showAllProducts()) {
                if (product.getProductId() == productId) {
                    System.out.println("Enter quantity of products: ");
                    var quantity = input.nextInt();
                    cartService.addCart(new CartItem());
                }
            }
        }
    }
}
