package com.slate;

import com.slate.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private final String APPIUM_HOST = "http://127.0.0.1:4723/wd/hub";

    public AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5 API 24");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.todoist");
        caps.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver(new URL(APPIUM_HOST), caps);

        new LoginPage().loginToApp(driver);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }

}
