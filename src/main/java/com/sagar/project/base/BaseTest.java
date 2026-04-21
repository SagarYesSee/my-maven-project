package com.sagar.project.base;

import com.sagar.project.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import com.sagar.project.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}