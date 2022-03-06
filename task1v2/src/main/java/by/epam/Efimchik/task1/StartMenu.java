package by.epam.Efimchik.task1;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.view.LoginView;
import by.epam.Efimchik.task1.view.ProductView;

import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class StartMenu {
    /**
     * @throws IOException
     * @throws DAOException
     * @throws ClassNotFoundException
     */
    public void startMenu() throws IOException, DAOException, ClassNotFoundException {
        final Logger logger = Logger.getLogger(StartMenu.class);
        Scanner input = new Scanner(System.in);
        LoginView loginView = new LoginView();
        ProductView productView = new ProductView();

        logger.info(" - Auto parts store -\n");
        while (true) {
            logger.info("1. Show catalog");
            logger.info("2. Search product");
            logger.info("3. Sign in");
            logger.info("4. Sign up");
            logger.info("0. Exit");
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
                    logger.info(" - Register new User -\n");
                    loginView.registerUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    logger.info("Wrong item selected. Try again\n");
            }
        }
    }
}
