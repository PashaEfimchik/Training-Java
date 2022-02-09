package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Start start = new Start();
            start.startMenu();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
