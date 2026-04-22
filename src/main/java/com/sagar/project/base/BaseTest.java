package com.sagar.project.base;

import com.sagar.project.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import com.sagar.project.utils.ConfigReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}