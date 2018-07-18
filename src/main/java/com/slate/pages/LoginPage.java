package com.slate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {

    public LoginPage loginToApp(WebDriverWait wait) {
        Properties userProps = loadProperties("user.properties");

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_welcome_continue_with_email"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/email_exists_input"))).sendKeys(userProps.getProperty("user.login"));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_continue_with_email"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/log_in_password"))).sendKeys(userProps.getProperty("user.pass"));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_log_in"))).click();

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
