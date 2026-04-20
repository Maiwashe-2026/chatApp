/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Shirley
 */
public class LoginTest {
    
  

    // Helper method
    private Login createValidUser() {
        return new Login("kyl_1", "Ch&&sec@ke99!", "0838968976", "Kyle", "Smith");
    }

    @Test
    public void testUsernameCorrectlyFormatted_ReturnsSuccessMessage() {
        Login user = createValidUser();
        String expected = "Username successfully captured. Password successfully captured. Cell phone number successfully added.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testUsernameIncorrectlyFormatted_ReturnsErrorMessage() {
        Login user = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "0838968976", "Kyle", "Smith");
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_ReturnsErrorMessage() {
        Login user = new Login("kyl_1", "password", "0838968976", "Kyle", "Smith");
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted_ReturnsErrorMessage() {
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        String expected = "Cell phone number incorrectly formatted or does not contain international code.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testLoginSuccessful_ReturnsTrue() {
        Login user = createValidUser();
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed_ReturnsFalse() {
        Login user = createValidUser();
        assertFalse(user.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    public void testUsernameCorrect_ReturnsTrue() {
        Login user = createValidUser();
        assertTrue(user.checkUserName());
    }

    @Test
    public void testUsernameIncorrect_ReturnsFalse() {
        Login user = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "0838968976", "Kyle", "Smith");
        assertFalse(user.checkUserName());
    }

    @Test
    public void testPasswordMeetsComplexity_ReturnsTrue() {
        Login user = createValidUser();
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_ReturnsFalse() {
        Login user = new Login("kyl_1", "password", "0838968976", "Kyle", "Smith");
        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrect_ReturnsTrue() {
        Login user = createValidUser();
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrect_ReturnsFalse() {
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(user.checkCellPhoneNumber());
    }
}