package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class TaskPage {

    public TaskPage fillNameTask(WebDriverWait wait, String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/message"))).sendKeys(name);
        return this;
    }

    public TaskPage createTask(WebDriverWait wait, AppiumDriver<MobileElement> driver) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/button1"))).click();
        driver.hideKeyboard();

        return this;
    }

    public TaskPage pickTask(WebDriverWait wait, AppiumDriver<MobileElement> driver, String taskName) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.todoist:id/text")));

        List<MobileElement> tasks = driver.findElements(By.id("com.todoist:id/text"));
        int countTasks = tasks.size();
        for (int i = 0; i < countTasks; i++) {
            if (tasks.get(i).getText().contains(taskName)) tasks.get(i).click();
        }
        return this;
    }

    public TaskPage resolveTask(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.todoist:id/menu_item_complete"))).click();
        return this;
    }



    public TaskPage verifyTaskPresent(AppiumDriver driver, WebDriverWait wait, String taskName) {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//android.widget.TextView[@text='" + taskName + "']"))).isDisplayed(),
                "Task " + taskName + " not present!");
        return this;
    }

    public TaskPage verifyTaskDisappear(AppiumDriver driver, WebDriverWait wait, String taskName) {
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        (By.xpath("//android.widget.TextView[@text='" + taskName + "']")))),
                "Task " + taskName + " present!");
        return this;
    }




}
