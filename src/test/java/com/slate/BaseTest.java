package com.slate;

import com.slate.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    private static final String APPIUM_HOST = "http://127.0.0.1:4723/wd/hub";

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5 API 24");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.todoist");//"com.google.android.apps.nexuslauncher");
        caps.setCapability("appActivity", "com.todoist.activity.HomeActivity");// "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<>(new URL(APPIUM_HOST), caps);
        wait = new WebDriverWait(driver, 10);

        new LoginPage().loginToApp(wait);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
