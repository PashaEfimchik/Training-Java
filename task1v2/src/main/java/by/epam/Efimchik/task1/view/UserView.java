package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.StartMenu;
import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.UserService;

import java.io.IOException;
import java.util.Scanner;

public class UserView {
    UserService userService = new UserService();
    OrderView orderView = new OrderView();
    CartView cartView = new CartView();
    ProductView productView = new ProductView();
    Scanner input = new Scanner(System.in);
    StartMenu startMenu = new StartMenu();

    public void accountDetail(User user) throws DAOException, IOException {
        System.out.println(" - My Account -");
        System.out.println("\nE-mail: " + user.getEmail() + "\nUsername: " + user.getUsername() + "\nPassword: " + user.getPassword());
        System.out.println("\n1. Change data\n2.Back");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Input new E-mail: ");
                String email = input.next();
                System.out.println("Input new username: ");
                String username = input.next();
                System.out.println("Input new password: ");
                String password = input.next();
                userService.updateUser(user, new String[]{String.valueOf(user.getUserId()), email, username, password});
                break;
            case 2:
                userMenu(user);
                break;
        }
    }

    public void showUserMenu() {
        System.out.println("1. My account");
        System.out.println("2. My orders");
        System.out.println("3. My cart");
        System.out.println("4. All products");
        System.out.println("5. LogOut");
    }

    public void userMenu(User user) throws DAOException, IOException {
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
                    productView.showProducts();
                    break;
                case 5:
                    user.setUserSession(false);
                    startMenu.startMenu();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
