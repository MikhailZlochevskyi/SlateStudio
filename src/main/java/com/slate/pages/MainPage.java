package com.slate.pages;

import io.appium.java_client.android.AndroidDriver;

import static com.slate.pages.PageUtil.getElementById;

public class MainPage {

    public TaskPage startCreateTask(AndroidDriver driver){
        getElementById(driver, "com.todoist:id/fab").click();
        return new TaskPage();
    }
}
