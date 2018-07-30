package com.slate.pages;

import com.slate.config.TestConfig;
import io.appium.java_client.android.AndroidDriver;

import static com.slate.utils.PageUtil.getElementById;

public class LoginPage {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver){
        this.driver = driver;
    }

    public LoginPage loginToApp() {
        getElementById(driver, "com.todoist:id/btn_welcome_continue_with_email").click();
        getElementById(driver, "com.todoist:id/email_exists_input").sendKeys(TestConfig.getUserLogin());
        getElementById(driver, "com.todoist:id/btn_continue_with_email").click();
        getElementById(driver, "com.todoist:id/log_in_password").sendKeys(TestConfig.getUserPass());
        getElementById(driver, "com.todoist:id/btn_log_in").click();
        return this;
    }

}
