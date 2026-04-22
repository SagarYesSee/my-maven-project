package com.sagar.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By loginHeader = By.xpath("//h2[text()='Login to your account']");
    private By emailLogin = By.cssSelector("input[data-qa='login-email']");
    private By passwordField = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailLogin).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isLoginHeaderDisplayed() {
        return driver.findElement(loginHeader).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isLoggedInAsDisplayed() {
        return driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
    }

}