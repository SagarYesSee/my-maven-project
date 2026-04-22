package com.sagar.project.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop = new Properties();

    static {
        // getResourceAsStream loads from the classpath — works correctly both
        // with `mvn test` (src/test/resources is on the test classpath) and
        // when running directly from the IDE.
        try (InputStream is = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new RuntimeException(
                    "config.properties not found on the classpath. " +
                    "Make sure it is in src/test/resources/");
            }
            prop.load(is);

        } catch (Exception e) {
            // Re-throw so the test fails immediately with a clear message
            // instead of a confusing NullPointerException later.
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key '" + key + "' not found in config.properties");
        }
        return value.trim();
    }
}