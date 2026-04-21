package com.sagar.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sagar.project.base.BaseTest;
import com.sagar.project.pages.HomePage;
import com.sagar.project.pages.SignupPage;

public class RegisterUser extends BaseTest {

    @Test(description = "Test Case 1: Register User Flow\n" +
            "1. Launch browser\n" +
            "2. Navigate to url\n" +
            "3. Verify home page visibility\n" +
            "4. Click Signup/Login\n" +
            "5. Verify 'New User Signup!' visibility\n" +
            "6-7. Enter name/email and Signup\n" +
            "8. Verify 'ENTER ACCOUNT INFORMATION' visibility\n" +
            "9-12. Fill details and checkboxes\n" +
            "13. Click 'Create Account'\n" +
            "14. Verify 'ACCOUNT CREATED!'\n" +
            "15. Click 'Continue'\n" +
            "16. Verify 'Logged in as username'\n" +
            "17. Click 'Delete Account'\n" +
            "18. Verify 'ACCOUNT DELETED!'")
    public void testUserRegistration() {

        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        Assert.assertTrue(home.isLogoDisplayed(), "Logo should be displayed");

        home.clickSignupLogin();

        Assert.assertTrue(signup.isSignupHeaderDisplayed(), "Signup header should be displayed");

        signup.signup("Sagar", "sagarsc003@gmail.com");

        signup.clickSignup();

        Assert.assertTrue(signup.isFormHeaderDisplayed(), "Form header should be displayed");

        signup.submitForm();

        signup.clickCreateAccount();

        Assert.assertTrue(signup.isAccountCreatedHeaderDisplayed(), "Account created header should be displayed");

        signup.clickContinue();

        Assert.assertTrue(signup.isLoggedInAsDisplayed(), "Logged in as header should be displayed");

        signup.clickDeleteAccount();

        Assert.assertTrue(signup.isAccountDeletedHeaderDisplayed(), "Account deleted header should be displayed");

    }
}
