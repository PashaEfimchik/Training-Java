package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.StartMenu;
import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeMenuView {
    final Logger logger = Logger.getLogger(UserView.class);
    private EmployeeView employeeView = new EmployeeView();
    private ValidData validData = new ValidData();
    private Scanner input = new Scanner(System.in);

    public EmployeeMenuView() throws DAOException, IOException, ClassNotFoundException {
    }

    private void showAdminUserMenu() {
        logger.info(" - Admin user menu - \n");
        logger.info("1. All users");
        logger.info("2. Add user");
        logger.info("3. Update user");
        logger.info("4. Remove user");
        logger.info("5. Search user");
        logger.info("6. User by id");
        logger.info("7. Back");
    }

    private void adminUserMenu() throws DAOException, IOException, ClassNotFoundException {
        while (true){
            showAdminUserMenu();
            switch (validData.isValidInteger(input.next())){
                case 1:
                    employeeView.allUsersAdmin();
                    break;
                case 2:
                    employeeView.addUserAdmin();
                    break;
                case 3:
                    employeeView.updateUserAdmin();
                    break;
                case 4:
                    employeeView.removeUserAdmin();
                    break;
                case 5:
                    employeeView.searchUserAdmin();
                    break;
                case 6:
                    employeeView.userByIdAdmin();
                    break;
                case 7:
                    adminMenu();
                    break;
                default:
                    logger.info("Wrong choice. Try again: ");
            }
        }
    }

    private void showAdminProductMenu() {
        logger.info(" - Admin product menu - \n");
        logger.info("1. All products");
        logger.info("2. Add product");
        logger.info("3. Update product");
        logger.info("4. Remove product");
        logger.info("5. Search product");
        logger.info("6. Product by id");
        logger.info("7. Back");
    }

    private void adminProductMenu() throws DAOException, IOException, ClassNotFoundException {
        while (true){
            showAdminProductMenu();
            switch (validData.isValidInteger(input.next())){
                case 1:
                    employeeView.allProductsAdmin();
                    break;
                case 2:
                    employeeView.addProductUser();
                    break;
                case 3:
                    employeeView.updateProductAdmin();
                    break;
                case 4:
                    employeeView.removeProductAdmin();
                    break;
                case 5:
                    employeeView.searchProductAdmin();
                    break;
                case 6:
                    employeeView.productByIdAdmin();
                    break;
                case 7:
                    adminMenu();
                    break;
                default:
                    logger.info("Wrong choice. Try again: ");
            }
        }
    }

    private void statisticAdmin() {
        User user = new User();
        Product product = new Product();

        logger.info(" - Counter of created objects -\n");

        logger.info("User objects: " + user.userObjectCounter);
        logger.info("Product objects: " + product.productObjectCounter);
    }

    private void showAdminMenu() {
        logger.info(" - Admin - \n");
        logger.info("1. User menu");
        logger.info("2. Product menu");
        logger.info("3. Order menu");
        logger.info("4. Cart menu");
        logger.info("5. Statistics");
        logger.info("6. LogOut");
    }

    public void adminMenu() throws DAOException, IOException, ClassNotFoundException {
        while (true){
            showAdminMenu();
            switch (validData.isValidInteger(input.next())){
                case 1:
                    adminUserMenu();
                    break;
                case 2:
                    adminProductMenu();
                    break;
                case 5:
                    statisticAdmin();
                    break;
                case 6:
                    StartMenu startMenu = new StartMenu();
                    startMenu.startMenu();
                default:
                    logger.info("Wrong choice. Try again: ");
            }
        }
    }
}
