package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProjectsPage {

    public ProjectsPage passToProjects(AppiumDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.ImageButton[@content-desc=\"Change the current view\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[@text='Projects']"))).click();
        return this;
    }

    public ProjectsPage verifyProjectPresent(AppiumDriver driver, WebDriverWait wait, String name) {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.TextView[@text='" + name + "']"))).isDisplayed(),
                "Project " + name + " not present!");
        driver.navigate().back();
        return this;
    }

    public ProjectsPage pickProject(AppiumDriver driver, WebDriverWait wait, String name) {
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//android.widget.TextView[@text='" + name + "']"))).click();
        return this;
    }

}
