package com.sagar.project.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
}
