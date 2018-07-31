package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.ProjectsPage;
import com.slate.pages.TaskPage;
import com.slate.steps.TaskVerificationStep;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.TodoistDataProvider.PROJECT_NAME;
import static com.slate.tests.data.TodoistDataProvider.TASK_NAME;

public class CreateTaskTest extends BaseTest {

    @BeforeClass
    public void createTask() {
        new TaskVerificationStep()
                .verifyTaskIsNotPresentOnApi(TASK_NAME);

        new ProjectsPage(driver)
                .pickProject(PROJECT_NAME);

        new TaskPage(driver)
                .startCreateTask()
                .fillNameTask(TASK_NAME)
                .createTask();
    }

    @Test
    public void checkTaskCreation() {
        new TaskVerificationStep()
                .verifyTaskPresentOnApi(TASK_NAME);
    }

}
