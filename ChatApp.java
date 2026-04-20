/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author Shirley
 */
public class ChatApp {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Declaring variables
        String firstName = "";
        String lastName = ""; 
        String username = "";
        String password = "";
        boolean Registered = false;
        
        System.out.println("welcome to Chat App!");
        boolean running = true;
        while (running) {
            //System allows user to choose an option
        System.out.println("Options: ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        
        //Asking user to enter option
        System.out.print("Choose option: ");
        int choice = input.nextInt();
        input.nextLine();
        
        // Collecting user's first and last name during registration
        if (choice == 1) {
            System.out.println("\n---REGISTRATION---");
            
            System.out.print("Enter first name: ");
             firstName = input.nextLine();
             System.out.print("Enter last name: ");
             lastName = input.nextLine();
             
             System.out.println("\n");
             
             // Loop until the user enters a valid username that meets the required format
            while (true) {
            System.out.println("Username should be 5 characters long");
            System.out.println("Username should include an _ ");
            
        System.out.print("Enter username : ");
         username = input.nextLine();
         
         System.out.println("\n");
        
        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("Username successfully captured");
           break; 
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains and underscore and is no more than five characters in lenghth");
        }
        }
        // Loop until the user enters a valid password that meets all complexity requirements
        while (true) {
            boolean capital = false;
            boolean number = false;
            boolean special = false;
            
            System.out.println("\n");
            System.out.println("Password should be 8 characters long");
            System.out.println("Should contain a capital letter");
            System.out.println("Should contain a number");
            System.out.println("should contain a special character");
            
            
            System.out.print("Enter password: ");
         password = input.nextLine();
         
         // Loop through each character in the password to check required conditions
        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);
            
            if (Character.isUpperCase(letter)) {
                capital = true;
            } else if (Character.isDigit(letter)) {
                number = true;
            } else if (!Character.isLetterOrDigit(letter)) {
                special = true;
            }
        } 
        
        if (password.length() >= 8 && capital && number && special) {
            System.out.println("Password successfully captured");
            break;
        } else {
            System.out.println("Passowrd is not correctly formatted; Please ensure that the passowrd contains at least eight characters, a capital letter, a number and a special character");
            
        }
        }
        // Loop until the user enters a valid South African cellphone number
        while (true) {
            System.out.println("\n");
            System.out.println("Please begin with international code");
            System.out.print("Enter cellphone number: ");
            String phoneNumber = input.nextLine();
            
            // Check if the phone number is correctly formatted
            if (phoneNumber.startsWith ("+27") && phoneNumber.length() == 12) {
                System.out.println("Cellphone number successfully added");
                break;
            } else {
                System.out.println("Cellphone number incorrectly formatted or does not contain international code");
            }
        } 
        // Mark user as registered and proceed to login option
        Registered = true;
        } else if (choice == 2) {
            if (!Registered) {
                System.out.println("you have not registered");
                continue;
            }
            
            // Prompt user to enter login credentials
                 System.out.println("\n----LOGIN----");
                
                System.out.print("Enter username: ");
                String correctUsername = input.nextLine();
                
                System.out.print("Enter password: ");
                String correctPassword = input.nextLine();
                
                
                
               // Check if entered login details match the registered credentials 
               if (correctUsername.equals(username) && correctPassword.equals(password)) {
                    System.out.println("Welcome back" + " " + firstName + " " + lastName + "," + "It is great to see you again");
                    running = false;
                    } else {
                    System.out.println("Wrong username or password entered");
                    
                }
// Exit the program if user chooses option 3, otherwise handle invalid input    
} else if (choice == 3) {
        System.out.println("Goodbye");
        break;
        } else {
    System.out.println("INVALID OPTION");
}
        }
        input.close();
    }
    }
    

