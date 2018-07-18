package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.MainPage;
import com.slate.pages.ProjectsPage;
import com.slate.utils.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.TodoistDataProvider.PROJECT_NAME;
import static com.slate.tests.data.TodoistDataProvider.TASK_NAME;

public class CreateTaskTest extends BaseTest {


    @BeforeClass
    public void createTask() {
        Assert.assertFalse(new ApiUtils().getTasks().path("content").toString().contains(TASK_NAME));

        new ProjectsPage().passToProjects(driver).pickProject(driver, PROJECT_NAME);
        new MainPage()
                .startCreateTask(driver)
                .fillNameTask(driver, TASK_NAME)
                .createTask(driver);
    }

    @Test
    public void checkTaskCreation() {
        new ApiUtils().verifyTaskPresent(TASK_NAME);
    }

}
