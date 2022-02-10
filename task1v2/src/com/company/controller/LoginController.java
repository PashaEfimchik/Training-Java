package com.company.controller;

import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController extends User {
    private String username;
    private String password;

    List<User> userList = new ArrayList<>();
    User user = new User();

    public void login() {
        System.out.println("Enter username: ");
        username = (new Scanner(System.in)).nextLine();
        System.out.println("Enter password: ");
        password = (new Scanner((System.in))).nextLine();

        if (!username.equals("") && !password.equals("")){
            for (User user : userList) {
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                    System.out.println("Successfully logged in!");
                }
                else {
                    System.out.println("This user does not exist");
                }
            }
        }
    }

    public void register () {
        System.out.println("Enter id: ");
        user.setId((new Scanner(System.in)).nextInt());
        System.out.println("Enter E-mail: ");
        user.setEmail((new Scanner(System.in)).nextLine());
        System.out.println("Enter username: ");
        user.setUsername((new Scanner(System.in)).nextLine());
        System.out.println("Enter password: ");
        user.setPassword((new Scanner(System.in)).nextLine());
        //System.out.println("Enter confirm password: ");
        userList.add(user);

        if(userList.contains(user)){
            System.out.println("User successfully registered");
        }
    }
}
