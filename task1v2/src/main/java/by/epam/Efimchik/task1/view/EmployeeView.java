package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.Order;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.ProductService;
import by.epam.Efimchik.task1.services.UserService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeView {
    final Logger logger = Logger.getLogger(UserView.class);
    private Scanner input = new Scanner(System.in);

    private ValidData validData = new ValidData();
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();
    private List<User> userList = userService.showAllUsers();
    private List<Product> productList = productService.showAllProducts();


    public EmployeeView() throws DAOException, IOException, ClassNotFoundException {
    }

    public void allUsersAdmin() {
        logger.info(" - All users -");
        for (var user : userList.stream().distinct().collect(Collectors.toList())) {
            logger.info("User id: " + user.getUserId());
            logger.info("E-mail: " + user.getEmail());
            logger.info("Username: " + user.getUsername());
            logger.info("Password: " + user.getPassword() + "\n");
        }
    }

    public void addUserAdmin() throws DAOException {
        logger.info(" - Add User - ");
        User user = new User();
        logger.info("Enter User id: ");
        user.setUserId(validData.isValidInteger(input.next()));

        logger.info("Enter e-mail: ");
        user.setEmail(validData.isValidEmail(input.next()));

        logger.info("Enter username: ");
        user.setUsername(validData.isValidUsername(input.next()));

        logger.info("Enter password: ");
        user.setPassword(validData.isValidPassword(input.next()));

        userService.addUser(user);
    }

    public void updateUserAdmin() throws DAOException {
        logger.info(" - Update user -");
        allUsersAdmin();
        logger.info("");
        logger.info("Enter user id to change: ");
        int choice = validData.isValidInteger(input.next());

        for (var user : userList.stream().distinct().collect(Collectors.toList())) {
            if (user.getUserId() == choice) {
                logger.info("Enter new user id :");
                int newId = validData.isValidInteger(input.next());
                logger.info("Enter new E-mail: ");
                String newEmail = validData.isValidEmail(input.next());
                logger.info("Enter new username: ");
                String newUsername = validData.isValidUsername(input.next());
                logger.info("Enter new password: ");
                String newPassword = validData.isValidPassword(input.next());

                userService.updateUser(user, new String[]{String.valueOf(newId), newEmail, newUsername, newPassword});
            }
        }
    }

    public void searchUserAdmin() throws DAOException {
        logger.info(" - Search User -");
        logger.info("Enter params to searching User: ");
        List<User> searchListUser = userService.searchUserByParam(input.next()); //userDAO.search(param);
        for (var user : searchListUser) {
            logger.info("User id: " + user.getUserId());
            logger.info("User E-mail" + user.getEmail());
            logger.info("Username: " + user.getUsername());
            logger.info("Password: " + user.getPassword() + "\n");
        }
    }

    public void userByIdAdmin() throws DAOException {
        logger.info(" - User by id -");
        logger.info("Enter user id to search: ");
        User user = userService.userById(validData.isValidInteger(input.next()));
        logger.info("User id: " + user.getUserId());
        logger.info("User email: " + user.getEmail());
        logger.info("Username: " + user.getUsername());
        logger.info("Password: " + user.getPassword());
    }

    public void removeUserAdmin() throws DAOException {
        logger.info(" - Remove user -");
        allUsersAdmin();
        int beforeSize = userService.showAllUsers().size(); //userDAO.allUsers().size();
        logger.info("Enter user id to remove: ");
        userService.removeUser(validData.isValidInteger(input.next()));
        //userDAO.remove(validData.isValidInteger(input.next()));
        int afterSize = userService.showAllUsers().size(); //userDAO.allUsers().size();

        if (beforeSize > afterSize) {
            logger.info("Successfully removed.");
        }
    }


    public void allProductsAdmin() {
        logger.info(" - All products -");
        for (var product : productList.stream().distinct().collect(Collectors.toList())) {
            logger.info("Product id: " + product.getProductId());
            logger.info("Article: " + product.getArticle());
            logger.info("Name: " + product.getName());
            logger.info("Supplier name: " + product.getSupplierName());
            logger.info("Price (BYN): " + product.getProductPrice() + "\n");
        }
    }

    public void addProductUser() throws DAOException {
        logger.info(" - Add Product - ");
        Product product = new Product();

        logger.info("Enter product id: ");
        product.setProductId(validData.isValidInteger(input.next()));

        logger.info("Enter article: ");
        product.setArticle(input.next());

        logger.info("Enter name: ");
        product.setName(input.next());

        logger.info("Enter supplier name: ");
        product.setSupplierName(input.next());

        logger.info("Enter price (BYN): ");
        product.setProductPrice(input.nextFloat());

        productService.addProduct(product);
    }

    public void updateProductAdmin() throws DAOException {
        logger.info(" - Update product -");
        allProductsAdmin();
        logger.info("");
        logger.info("Enter product id to change: ");
        int choice = validData.isValidInteger(input.next());

        for (var product : productList.stream().distinct().collect(Collectors.toList())) {
            if (product.getProductId() == choice) {
                logger.info("Enter new product id :");
                int newId = validData.isValidInteger(input.next());
                logger.info("Enter new article: ");
                String newArticle = input.next();
                logger.info("Enter new name: ");
                String newName = input.next();
                logger.info("Enter new supplier name: ");
                String newSupplierName = input.next();
                logger.info("Enter new product price (BYN): ");
                float newProductPrice = input.nextFloat();

                productService.updateProduct(product, new String[]{String.valueOf(newId), newArticle, newName, newSupplierName, String.valueOf(newProductPrice)});
            }
        }
    }

    public void searchProductAdmin() throws DAOException {
        logger.info(" - Search product -");
        logger.info("Enter params to searching product: ");
        List<Product> searchProductList = productService.searchProduct(input.next());
        for (var product : searchProductList) {
            logger.info("Product id: " + product.getProductId());
            logger.info("Article: " + product.getArticle());
            logger.info("Name: " + product.getName());
            logger.info("Supplier name: " + product.getSupplierName());
            logger.info("Product price (BYN): " + product.getProductPrice() + "\n");
        }
    }

    public void productByIdAdmin() throws DAOException {
        logger.info(" - Product by id -");
        logger.info("Enter product id to search: ");
        Product product = productService.productById(validData.isValidInteger(input.next()));
        logger.info("Product id: " + product.getProductId());
        logger.info("Article: " + product.getArticle());
        logger.info("Name: " + product.getName());
        logger.info("Supplier name: " + product.getSupplierName());
        logger.info("Product price (BYN): " + product.getProductPrice() + "\n");
    }

    public void removeProductAdmin() throws DAOException {
        logger.info(" - Remove product -");
        allProductsAdmin();
        int beforeSize = productService.showAllProducts().size();
        logger.info("Enter product id to remove: ");
        productService.removeProduct(validData.isValidInteger(input.next()));
        int afterSize = productService.showAllProducts().size();

        if (beforeSize > afterSize) {
            logger.info("Successfully removed.");
        }
    }

    public void adminMenu() throws DAOException, IOException {
        while (true) {
            switch (Integer.parseInt(input.next())) {
                case 5:
                    User user = new User();
                    Product product = new Product();
                    CartItem cartItem = new CartItem();
                    Order order = new Order();


                    logger.info("Product objects: ");
                    logger.info("Cart item objects: ");
                    logger.info("Order objects: ");

                    break;
                case 6:
                    //startMenu.startMenu();
                    break;
                default:
                    logger.info("Wrong choice");
            }
        }
    }
}
