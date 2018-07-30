package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.MainPage;
import com.slate.pages.ProjectsPage;
import com.slate.steps.TasksStep;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.TodoistDataProvider.PROJECT_NAME;
import static com.slate.tests.data.TodoistDataProvider.TASK_NAME;

public class CreateTaskTest extends BaseTest {

    @BeforeClass
    public void createTask() {
        new TasksStep()
                .verifyTaskIsNotPresent(TASK_NAME);

        new ProjectsPage(driver)
                .passToProjects()
                .pickProject(PROJECT_NAME);
        new MainPage(driver)
                .startCreateTask()
                .fillNameTask(TASK_NAME)
                .createTask();
    }

    @Test
    public void checkTaskCreation() {
        new TasksStep()
                .verifyTaskPresent(TASK_NAME);
    }

    @AfterClass
    public void cleanUp() {
        driver.navigate().back();
    }
}
