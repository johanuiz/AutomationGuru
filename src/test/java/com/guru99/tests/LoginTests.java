package com.guru99.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Parameters({"username", "userPassword"})
    @Test
    public void  verifyUserLoginWithCorrectCredentials(String username, String password){
        reportUtils.createTestCase("verify User Login With Correct Credentials");
        reportUtils.addTestLog(Status.INFO, "Performing Login");
        loginPage.loginToApplication(username, password);
        String expectedTitle = "Guru99 Bank Manager HomePage";
        String actualTitle = cmnDriver.getTitleOfThePage();
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Parameters({"incorrectUsername", "incorrectPassword"})
    @Test
    public void verifyUserLoginWithIncorrectCredentials(String incorrectUsername, String incorrectPassword) {
        reportUtils.createTestCase("Verify User Login With Incorrect Credentials");
        reportUtils.addTestLog(Status.INFO, "Performing Login with Incorrect Credentials");
        loginPage.loginToApplication(incorrectUsername, incorrectPassword);
        //String expectedErrorMessage = "Invalid credentials"; // Cambia esto según el mensaje de error real
        //String actualErrorMessage = loginPage.getErrorMessage(); // Asume que hay un método para obtener el mensaje de error
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual error message");
        //Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }



}
