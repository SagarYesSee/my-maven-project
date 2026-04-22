package com.sagar.project.listeners;

import com.sagar.project.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶ Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED: " + result.getName());

        // Capture screenshot on failure
        Object testInstance = result.getInstance();
        try {
            WebDriver driver = (WebDriver) testInstance.getClass()
                    .getField("driver")
                    .get(testInstance);
            ScreenshotUtils.takeScreenshot(driver, result.getName());
        } catch (Exception e) {
            System.out.println("Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭ SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🚀 Test Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Test Suite finished: " + context.getName());
        System.out.println("   Passed : " + context.getPassedTests().size());
        System.out.println("   Failed : " + context.getFailedTests().size());
        System.out.println("   Skipped: " + context.getSkippedTests().size());
    }
}
