package com.company.controller;

import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginController extends User {
    private String username;
    private String password;

    List<User> userList = new ArrayList<>();

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
            }
        }
    }
}
