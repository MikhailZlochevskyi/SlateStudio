package com.slate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public TaskPage startCreateTask(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/fab"))).click();
        return new TaskPage();
    }
}
