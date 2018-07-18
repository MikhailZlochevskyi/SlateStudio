package com.slate.pages;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import static com.slate.pages.PageUtil.getElementByXpath;

public class ProjectsPage {

    public ProjectsPage passToProjects(AndroidDriver driver) {
        getElementByXpath(driver,"//android.widget.ImageButton[@content-desc=\"Change the current view\"]").click();
        getElementByXpath(driver,"//android.widget.TextView[@text='Projects']").click();
        return this;
    }

    public ProjectsPage verifyProjectPresent(AndroidDriver driver, String name) {
        Assert.assertTrue(getElementByXpath(driver,"//android.widget.TextView[@text='" + name + "']").isDisplayed(),
                "Project " + name + " not present!");
        driver.navigate().back();
        return this;
    }

    public ProjectsPage pickProject(AndroidDriver driver, String name) {
        getElementByXpath(driver,"//android.widget.TextView[@text='" + name + "']").click();
        return this;
    }



}
