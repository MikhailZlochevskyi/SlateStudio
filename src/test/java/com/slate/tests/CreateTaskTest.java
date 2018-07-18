package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.MainPage;
import com.slate.pages.ProjectsPage;
import com.slate.utils.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class CreateTaskTest extends BaseTest {

    private String taskName = "Slate-" + Math.random() * 1000 + 1;

    @BeforeClass
    public void createTask() {
        Assert.assertFalse(new ApiUtils().getTasks().path("content").toString().contains(taskName));

//        new LoginPage().loginToApp(wait);//remove further
        new ProjectsPage().passToProjects(driver, wait).pickProject(driver, wait, "New1");
        new MainPage()
                .startCreateTask(wait)
                .fillNameTask(wait, taskName)
                .createTask(wait, driver);
    }

    @Test
    public void checkProjectPresent() {
        await().pollInterval(3, TimeUnit.SECONDS).until(() ->
                new ApiUtils().getTasks().path("content").toString().contains(taskName)
        );
    }

}
