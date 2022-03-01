package com.company.controller;

import com.company.dao.UserDAOException;
import com.company.entities.User;
import com.company.services.UserDAOImpl;
import com.company.utils.InitializationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController extends User {
    private String username;
    private String password;

    UserDAOImpl userDAO = new UserDAOImpl();
    InitializationUtil initialize = new InitializationUtil();
    List<User> userList = new ArrayList<>();
    CatalogController catalogController = new CatalogController();

    public void login() throws UserDAOException {
        initialize.uploadUsers(userList);
        System.out.println("Enter username: ");
        username = (new Scanner(System.in)).nextLine();
        System.out.println("Enter password: ");
        password = (new Scanner((System.in))).nextLine();

        if (!username.equals("") && !password.equals("")){
            for (User user : userList) {
                if (username.contains(user.getUsername()) && password.contains(user.getPassword())){
                    userDAO.addUser(user);
                    System.out.println("Successfully logged in!");
                    catalogController.catalogMenu();
                    break;
                }
                else {
                    System.out.println("This user does not exist");
                }
            }
        }
    }

    public void register () {
        User user = new User();
        System.out.println("Enter id: ");
        user.setId((new Scanner(System.in)).nextInt());
        System.out.println("Enter E-mail: ");
        user.setEmail((new Scanner(System.in)).nextLine());
        System.out.println("Enter username: ");
        user.setUsername((new Scanner(System.in)).nextLine());
        System.out.println("Enter password: ");
        user.setPassword((new Scanner(System.in)).nextLine());
        if(user.getEmail().matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")){
            userList.add(user);
        }
        else {
            System.out.println("Invalid E-mail address");
        }

        if(userList.contains(user)){
            System.out.println("User successfully registered");
        }
        else {
            System.out.println("User does not registered");
        }
    }
}
