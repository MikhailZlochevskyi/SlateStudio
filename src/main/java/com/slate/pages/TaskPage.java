package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static com.slate.pages.PageUtil.getElementById;
import static com.slate.pages.PageUtil.getElementByXpath;

public class TaskPage {

    public TaskPage fillNameTask(AndroidDriver driver, String name) {
        getElementById(driver, "android:id/message").sendKeys(name);
        return this;
    }

    public TaskPage createTask(AndroidDriver driver) {
        getElementById(driver, "android:id/button1").click();
        driver.hideKeyboard();
        return this;
    }

    public TaskPage pickTask(AppiumDriver<MobileElement> driver, String taskName) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.todoist:id/text")));

        List<MobileElement> tasks = driver.findElements(By.id("com.todoist:id/text"));
        int countTasks = tasks.size();
        for (int i = 0; i < countTasks; i++) {
            if (tasks.get(i).getText().contains(taskName)) tasks.get(i).click();
        }
        return this;
    }

    public TaskPage resolveTask(AndroidDriver driver) {
        getElementById(driver, "com.todoist:id/menu_item_complete").click();
        return this;
    }

    public TaskPage verifyTaskPresent(AndroidDriver driver, String taskName) {
        Assert.assertTrue(getElementByXpath(driver, "//android.widget.TextView[@text='" + taskName + "']").isDisplayed(),
                "Task " + taskName + " not present!");
        return this;
    }

    public TaskPage verifyTaskDisappear(AppiumDriver driver, String taskName) {
        Assert.assertTrue(new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(
                (By.xpath("//android.widget.TextView[@text='" + taskName + "']")))),
                "Task " + taskName + " present!");
        return this;
    }
}