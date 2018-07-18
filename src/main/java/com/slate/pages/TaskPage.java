package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPage {

    public TaskPage fillNameTask(WebDriverWait wait, String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/message"))).sendKeys(name);
        return this;
    }

    public TaskPage createTask(WebDriverWait wait, AppiumDriver driver) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/button1"))).click();
        driver.hideKeyboard();

        return this;
    }
}
