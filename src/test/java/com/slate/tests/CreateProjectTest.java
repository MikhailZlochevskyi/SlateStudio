package com.slate.tests;

import com.jayway.restassured.response.Response;
import com.slate.ApiUtils;
import com.slate.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseTest {

    private String projectName = "Slate";
    private Response project;

    @BeforeClass
    public void createFolder() {
        project = new ApiUtils().createProject(projectName);
    }

    @AfterClass
    public void cleanUp() {
        String projectId = project.path("id").toString();
        new ApiUtils().deleteProject(projectId);
    }

    @Test
    public void basicTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_welcome_continue_with_email"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/email_exists_input"))).sendKeys("mihailzlochevskiy@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_continue_with_email"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/log_in_password"))).sendKeys("assa6767");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_log_in"))).click();
        driver.findElementByAccessibilityId("Change the current view").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Projects']").click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + projectName + "']")).click();
    }


}