package com.slate.pages;

import com.slate.config.TestConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "btn_welcome_continue_with_email")
    private MobileElement loginWithEmailBtn;

    @AndroidFindBy(id = "email_exists_input")
    private MobileElement emailInput;

    @AndroidFindBy(id = "btn_continue_with_email")
    private MobileElement emailContinueBtn;

    @AndroidFindBy(id = "log_in_password")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "btn_log_in")
    private MobileElement loginBtn;


    public LoginPage loginToApp() {
        loginWithEmailBtn.click();
        emailInput.setValue(TestConfig.getUserLogin());
        emailContinueBtn.click();
        passwordInput.setValue(TestConfig.getUserPass());
        loginBtn.click();
        return this;
    }

}
