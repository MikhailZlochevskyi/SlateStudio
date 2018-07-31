package com.slate;

import com.slate.config.TestConfig;
import com.slate.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Log4j
public class BaseTest {

    public static AndroidDriver driver;

    @BeforeSuite
    public void setUp(ITestContext testContext) throws MalformedURLException {
        driver = new AndroidDriver(getAppiumServerUrl(), setCapabilities());

        new LoginPage(driver)
                .loginToApp();
    }

    @AfterSuite
    public void tearDown(ITestContext testContext) {
        driver.quit();
    }

    private DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 24");// ideally move to properties
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "5000");
        caps.setCapability(MobileCapabilityType.APP, getAppPath());
        caps.setCapability("appPackage", "com.todoist");
        caps.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        caps.setCapability("noReset", "false");
        caps.setCapability("skipUnlock", "true");
        return caps;
    }

    private URL getAppiumServerUrl() throws MalformedURLException {
        return new URL(TestConfig.getAppiumServer());
    }

    private String getAppPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("Todoist_v12.8_apkpure.com.apk").getFile()).getAbsolutePath();
    }
}
