package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.StartMenu;
import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.UserService;

import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class UserView {
    final Logger logger = Logger.getLogger(UserView.class);
    UserService userService = new UserService();
    OrderView orderView = new OrderView();
    CartView cartView = new CartView();
    ProductView productView = new ProductView();
    Scanner input = new Scanner(System.in);
    StartMenu startMenu = new StartMenu();

    public UserView() throws IOException, ClassNotFoundException {
    }

    public void accountDetail(User user) throws DAOException, IOException, ClassNotFoundException {
        logger.info(" - My Account -\n");

        logger.info("E-mail: " + user.getEmail());
        logger.info("Username: " + user.getUsername());
        logger.info("Password: " + user.getPassword() + "\n");

        logger.info("1. Change data");
        logger.info("2. Back");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                logger.info("Input new E-mail: ");
                String email = input.next();
                logger.info("Input new username: ");
                String username = input.next();
                logger.info("Input new password: ");
                String password = input.next();
                userService.updateUser(user, new String[]{String.valueOf(user.getUserId()), email, username, password});
                break;
            case 2:
                userMenu(user);
                break;
        }
    }

    public void showUserMenu() {
        logger.info("1. My account");
        logger.info("2. My orders");
        logger.info("3. My cart");
        logger.info("4. All products");
        logger.info("5. LogOut");
    }

    public void userMenu(User user) throws DAOException, IOException, ClassNotFoundException {
        while (true){
            showUserMenu();
            switch (Integer.parseInt(input.next())) {
                case 1:
                    accountDetail(user);
                    break;
                case 2:
                    orderView.showOrder(user);
                    break;
                case 3:
                    cartView.showUserCart(user);
                    break;
                case 4:
                    productView.showUserProducts(user);
                    break;
                case 5:
                    user.setUserSession(false);
                    startMenu.startMenu();
                    break;
                default:
                    logger.info("Wrong choice");
            }
        }
    }
}
