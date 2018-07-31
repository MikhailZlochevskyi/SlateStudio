package com.slate.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {

    @AndroidFindBy(id = "toolbar")
    private MobileElement homeToolbar;

    protected static AppiumDriver<MobileElement> driver;

    public BasePage(final AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, new TimeOutDuration(15, TimeUnit.SECONDS)), this);
    }

    public BasePage hideKeyboard() {
        driver.hideKeyboard();
        return this;
    }

    public BasePage moveBack() {
        driver.navigate().back();
        return this;
    }
}
