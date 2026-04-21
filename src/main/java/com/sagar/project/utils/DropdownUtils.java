package com.sagar.project.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropdownUtils {

    // 🔹 Select by visible text (for <select>)
    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // 🔹 Select by value
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // 🔹 Select by index
    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // 🔹 Handle custom dropdown (dynamic)
    public static void selectCustomDropdown(WebDriver driver, By optionsLocator, String value) {
        List<WebElement> options = driver.findElements(optionsLocator);

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }
}