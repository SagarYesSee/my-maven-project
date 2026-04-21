package com.sagar.project.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
                { "validuser@test.com", "validpass" },
                { "invalid@test.com", "wrongpass" }
        };
    }
}