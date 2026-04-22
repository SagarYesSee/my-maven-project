package com.sagar.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By logo = By.xpath("//img[@src='/static/images/home/logo.png']");
    private By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By logoutLink = By.xpath("//a[contains(text(),'Logout')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
