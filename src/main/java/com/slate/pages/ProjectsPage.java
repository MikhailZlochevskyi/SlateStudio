package com.slate.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProjectsPage {

    public ProjectsPage passToProjects(AndroidDriver driver) {
        getElementByXpath(driver, "//android.widget.ImageButton[@content-desc=\"Change the current view\"]").click();
        getElementByXpath(driver, "//android.widget.TextView[@text='Projects']").click();
        return this;
    }

    public ProjectsPage verifyProjectPresent(AndroidDriver driver, String name) {
        Assert.assertTrue(getElementByXpath(driver, "//android.widget.TextView[@text='" + name + "']").isDisplayed(),
                "Project " + name + " not present!");
        return this;
    }

    public ProjectsPage pickProject(AndroidDriver driver, String name) {
        getElementByXpath(driver, "//android.widget.TextView[@text='" + name + "']").click();
        return this;
    }

    private static WebElement getElementByXpath(AndroidDriver driver, String xpath) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(xpath)));

    }
}
