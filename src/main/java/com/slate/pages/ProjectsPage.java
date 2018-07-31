package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProjectsPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Change the current view\"]")
    private MobileElement openMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Projects']")
    private MobileElement projectSection;

    public ProjectsPage(AndroidDriver driver){
        super(driver);
    }

    public ProjectsPage clickToProjects() {
        projectSection.click();
        return this;
    }

    public ProjectsPage verifyProjectPresent(String name) {
        Assert.assertTrue(getElementByXpath(driver, "//android.widget.TextView[@text='" + name + "']").isDisplayed(),
                "Project " + name + " not present!");
        return this;
    }

    public ProjectsPage pickProject(String name) {
        getElementByXpath(driver, "//android.widget.TextView[@text='" + name + "']").click();
        return this;
    }

    private static WebElement getElementByXpath(AppiumDriver driver, String xpath) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(xpath)));

    }
}
