package com.company.controller;

import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterController{
    User userRegister = new User();
    List<User> userList = new ArrayList<>();
    public void register () {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter id: ");
            userRegister.setId(scanner.nextInt());
            System.out.println("Enter E-mail: ");
            userRegister.setEmail(scanner.nextLine());
            System.out.println("Enter username: ");
            userRegister.setUsername(scanner.nextLine());
            System.out.println("Enter password: ");
            userRegister.setPassword(scanner.nextLine());
            //System.out.println("Enter confirm password: ");

            userList.add(userRegister);
        }
    }
}
