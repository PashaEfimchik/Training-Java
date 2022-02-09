package com.company.view;

import java.util.Scanner;

public class Menu {
    private Scanner input;

    public void adminMenuProduct() {
        System.out.println("\n1. Add product");
        System.out.println("2. Delete product by id");
        System.out.println("3. Get product by id");
        System.out.println("4. Show all products");
        System.out.println("5. Search product");
        System.out.println("6. Upload product data");
        System.out.println("7. Exit\n");
    }

    public void adminMenuUser() {
        System.out.println("\n1. Add user");
        System.out.println("2. Delete user by id");
        System.out.println("3. Get user by id");
        System.out.println("4. Show all users");
        System.out.println("5. Search user");
        System.out.println("6. Upload user data");
        System.out.println("7. Exit\n");
    }

    /*public void adminProcess() {
        while (true){
            adminMenuProduct();
            switch (input.nextInt()){

            }
        }
    }*/
}
