package com.slate;

import com.slate.pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

@Log4j
public class BaseTest {

    private final String APPIUM_HOST = "http://127.0.0.1:4723/wd/hub";

    public static AndroidDriver<MobileElement> driver;

    @BeforeSuite
    public void setUp(ITestContext testContext) throws MalformedURLException {
        log.info("Suite <" + testContext.getSuite().getName() + "> started");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5 API 24");// ideally move to properties
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.todoist");
        caps.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<>(new URL(APPIUM_HOST), caps);

        new LoginPage(driver)
                .loginToApp();
    }

    @AfterSuite
    public void tearDown(ITestContext testContext) {
        driver.quit();
        log.info("Suite <" + testContext.getSuite().getName() + "> ended");

    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(ITestContext testContext) {
        log.info("Test <<" + testContext.getCurrentXmlTest().getName() + ">> started");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(ITestContext testContext) {
        log.info("Test <<" + testContext.getCurrentXmlTest().getName() + ">> ended");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        log.info("===================================================================================================");
        log.info("Test method <<<" + method.getName() + ">>> started");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResult, Method method) {
        log.info("Test method <<<" + method.getName() + ">>> ended");
    }

}
