package com.slate.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {

    public static WebElement getElementByXpath(AndroidDriver driver, String xpath) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(xpath)));

    }

    public static WebElement getElementById(AndroidDriver driver, String id) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.id(id)));
    }
}
