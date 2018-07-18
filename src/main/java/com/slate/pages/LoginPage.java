package com.slate.pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.slate.pages.PageUtil.getElementById;

public class LoginPage {

    public LoginPage loginToApp(AndroidDriver driver) {
        Properties userProps = loadProperties("user.properties");

        getElementById(driver, "com.todoist:id/btn_welcome_continue_with_email").click();
        getElementById(driver,"com.todoist:id/email_exists_input").sendKeys(userProps.getProperty("user.login"));
        getElementById(driver,"com.todoist:id/btn_continue_with_email").click();
        getElementById(driver,"com.todoist:id/log_in_password").sendKeys(userProps.getProperty("user.pass"));
        getElementById(driver,"com.todoist:id/btn_log_in").click();

        return this;
    }

    private Properties loadProperties(String name) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String userConfigPath = rootPath + name;
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(userConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
