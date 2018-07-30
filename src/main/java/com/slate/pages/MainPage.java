package com.slate.pages;

import io.appium.java_client.android.AndroidDriver;

import static com.slate.utils.PageUtil.getElementById;

public class MainPage {

    private AndroidDriver driver;

    public MainPage(AndroidDriver driver){
        this.driver = driver;
    }

    public TaskPage startCreateTask(){
        getElementById(driver, "com.todoist:id/fab").click();
        return new TaskPage(driver);
    }

}
