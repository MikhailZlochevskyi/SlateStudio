package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskPage extends BasePage {

    public TaskPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "fab")
    private MobileElement startCreationTask;

    @AndroidFindBy(id = "message")
    private MobileElement taskNameInput;

    @AndroidFindBy(id = "button1")
    private MobileElement createTaskBtn;

    @AndroidFindBy(id = "menu_item_complete")
    private MobileElement taskCompleteBtn;

    @AndroidFindBy(id = "email_exists_input")
    private MobileElement emailInput;

    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "text")
    private List<MobileElement> tasksName;


    public TaskPage fillNameTask(String name) {
        taskNameInput.setValue(name);
        return this;
    }

    public TaskPage createTask() {
        createTaskBtn.click();
        return this;
    }

    public TaskPage startCreateTask() {
        startCreationTask.click();
        return this;
    }

    public TaskPage pickTask(String taskName) {
        int countTasks = tasksName.size();
        for (int i = 0; i < countTasks; i++) {
            if (tasksName.get(i).getText().contains(taskName)) tasksName.get(i).click();
        }
        return this;
    }

    public TaskPage resolveTask() {
        taskCompleteBtn.click();
        return this;
    }

    public static boolean verifyTaskPresent(String taskName) {
       return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(
                (By.xpath("//android.widget.TextView[@text='" + taskName + "']")))).isDisplayed();
    }

    public static void verifyTaskDisappear(String taskName) {
        Assert.assertTrue(new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(
                (By.xpath("//android.widget.TextView[@text='" + taskName + "']")))),
                "Task " + taskName + " present!");
    }

}
