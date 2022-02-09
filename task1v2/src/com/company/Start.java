package com.company;

import com.company.entities.User;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public void startMenu() throws IOException {
        Scanner input = new Scanner(System.in);
        User user = new User();
        while (true) {
            System.out.println("1. Sign in\n2. Sign up\n3. Exit");
            switch (input.nextInt()){
                case 1:
                    break;
                case 2:

                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong item selected. Try again");
            }
        }
    }
}
