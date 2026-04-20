package com.mycompany.chatapp;

/**
 *
 * @author Shirley
 */


public class Login {

    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;

    // ✅ Constructor
    public Login(String username, String password, String phoneNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ✅ Username validation
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // ✅ Password validation
    public boolean checkPasswordComplexity() {
        if (password.length() < 8) return false;

        boolean capital = false;
        boolean number = false;
        boolean special = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) capital = true;
            else if (Character.isDigit(c)) number = true;
            else if (!Character.isLetterOrDigit(c)) special = true;
        }

        return capital && number && special;
    }

    // ✅ Phone validation (matches your tests)
    public boolean checkCellPhoneNumber() {
        return phoneNumber.matches("0\\d{9}");
    }

    // ✅ Register method
    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "Username successfully captured. Password successfully captured. Cell phone number successfully added.";
    }

    // ✅ Login check
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}