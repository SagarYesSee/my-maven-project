package com.sagar.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sagar.project.utils.DropdownUtils;
import com.sagar.project.utils.WaitUtils;

public class SignupPage {

    private WebDriver driver;

    // Locators

    private By signupHeader = By.xpath("//h2[text()='New User Signup!']");
    private By nameSignup = By.xpath("//input[@placeholder='Name']");
    private By emailSignup = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By formHeader = By.xpath("//b[text()='Enter Account Information']");

    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By password = By.id("password");
    private By day = By.cssSelector("[data-qa='days']");
    private By month = By.cssSelector("[data-qa='months']");
    private By year = By.cssSelector("[data-qa='years']");
    private By newsletter = By.id("newsletter");
    private By receiveSpecialOffers = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipCode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[text()='Create Account']");

    private By accountCreatedHeader = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.xpath("//a[text()='Continue']");

    private By loggedinas = By.xpath("//a[contains(text(),'Logged in as')]");
    private By deleteaccButton = By.xpath("//a[contains(text(),'Delete Account')]");
    private By accountDeletedHeader = By.xpath("//b[text()='Account Deleted!']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignupHeaderDisplayed() {
        WaitUtils.waitForVisible(driver, signupHeader, 10);
        return driver.findElement(signupHeader).isDisplayed();
    }

    public void enterName(String name) {
        WaitUtils.waitForVisible(driver, nameSignup, 10);
        driver.findElement(nameSignup).sendKeys(name);
    }

    public void enterEmailAddress(String email) {
        WaitUtils.waitForVisible(driver, emailSignup, 10);
        driver.findElement(emailSignup).sendKeys(email);
    }

    public void clickSignup() {
        WaitUtils.waitForVisible(driver, signupButton, 10);
        driver.findElement(signupButton).click();
    }

    public void signup(String name, String email) {
        enterName(name);
        enterEmailAddress(email);
    }

    public boolean isFormHeaderDisplayed() {
        WaitUtils.waitForVisible(driver, formHeader, 10);
        return driver.findElement(formHeader).isDisplayed();
    }

    public void submitForm() {
        WaitUtils.waitForVisible(driver, titleMr, 10);
        driver.findElement(titleMr).click();
        driver.findElement(password).sendKeys("password");
        DropdownUtils.selectByValue(driver.findElement(day), "30");
        DropdownUtils.selectByValue(driver.findElement(month), "6");
        DropdownUtils.selectByValue(driver.findElement(year), "2003");
        driver.findElement(newsletter).click();
        driver.findElement(receiveSpecialOffers).click();
        driver.findElement(firstName).sendKeys("Sagar");
        driver.findElement(lastName).sendKeys("Chintamani");
        driver.findElement(address).sendKeys("123 Main St");
        driver.findElement(address2).sendKeys("123 Main St");
        DropdownUtils.selectByVisibleText(driver.findElement(country), "India");
        driver.findElement(state).sendKeys("Maharashtra");
        driver.findElement(city).sendKeys("Mumbai");
        driver.findElement(zipCode).sendKeys("123456");
        driver.findElement(mobileNumber).sendKeys("1234567890");
    }

    public void clickCreateAccount() {
        WaitUtils.waitForVisible(driver, createAccountButton, 10);
        driver.findElement(createAccountButton).click();
    }

    public boolean isAccountCreatedHeaderDisplayed() {
        WaitUtils.waitForVisible(driver, accountCreatedHeader, 10);
        return driver.findElement(accountCreatedHeader).isDisplayed();
    }

    public void clickContinue() {
        WaitUtils.waitForVisible(driver, continueButton, 10);
        driver.findElement(continueButton).click();
    }

    public boolean isLoggedInAsDisplayed() {
        WaitUtils.waitForVisible(driver, loggedinas, 10);
        return driver.findElement(loggedinas).isDisplayed();
    }

    public void clickDeleteAccount() {
        WaitUtils.waitForVisible(driver, deleteaccButton, 10);
        driver.findElement(deleteaccButton).click();
    }

    public boolean isAccountDeletedHeaderDisplayed() {
        WaitUtils.waitForVisible(driver, accountDeletedHeader, 10);
        return driver.findElement(accountDeletedHeader).isDisplayed();
    }

}
