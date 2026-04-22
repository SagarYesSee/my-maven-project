package com.sagar.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sagar.project.base.BaseTest;
import com.sagar.project.pages.HomePage;
import com.sagar.project.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Test Case 2: Login with valid credentials\n" +
            "1. Launch browser\n" +
            "2. Navigate to url\n" +
            "3. Verify home page visibility\n" +
            "4. Click Signup/Login\n" +
            "5. Verify 'Login to your account' visibility\n" +
            "6. Enter correct email/password\n" +
            "7. Click Login\n" +
            "8. Verify 'Logged in as username' visibility\n" +
            "9. Click Logout\n" +
            "10. Verify home page visibility")
    public void testUserLogin() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        Assert.assertTrue(home.isLogoDisplayed(), "Logo should be displayed");

        home.clickSignupLogin();

        Assert.assertTrue(login.isLoginHeaderDisplayed(), "Login header should be displayed");

        login.login("sagarsc003@gmail.com", "123456789");

        Assert.assertTrue(login.isLoggedInAsDisplayed(), "Logged in as header should be displayed");

        home.clickLogout();

        Assert.assertTrue(home.isLogoDisplayed(), "Logo should be displayed");
    }

    @Test(description = "Test Case 3: Login with invalid credentials\n" +
            "1. Launch browser\n" +
            "2. Navigate to url\n" +
            "3. Verify home page visibility\n" +
            "4. Click Signup/Login\n" +
            "5. Verify 'Login to your account' visibility\n" +
            "6. Enter incorrect email/password\n" +
            "7. Click Login\n" +
            "8. Verify 'Please enter correct email or password' error message")
    public void testInvalidLogin() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        Assert.assertTrue(home.isLogoDisplayed(), "Logo should be displayed");

        home.clickSignupLogin();

        Assert.assertTrue(login.isLoginHeaderDisplayed(), "Login header should be displayed");

        login.login("invalid@gmail.com", "wronsword");

        Assert.assertTrue(login.isErrorMessageDisplayed(), "Error message should be displayed");
    }

}