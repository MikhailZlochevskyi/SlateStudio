package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.ProjectsPage;
import com.slate.pages.TaskPage;
import com.slate.pages.components.SideBarMenu;
import com.slate.steps.api.TaskApiStep;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.DataProvider.PROJECT_NAME;
import static com.slate.tests.data.DataProvider.TASK_NAME;

public class CreateTaskTest extends BaseTest {

    @BeforeClass
    public void createTask() {
        new TaskApiStep()
                .verifyTaskIsNotPresentOnApi(TASK_NAME);

        new SideBarMenu(driver)
                .open();

        new ProjectsPage(driver)
                .clickToProjects()
                .pickProject(PROJECT_NAME);

        new TaskPage(driver)
                .startCreateTask()
                .fillNameTask(TASK_NAME)
                .createTask()
                .hideKeyboard();
    }

    @Test
    public void checkTaskCreation() {
        new TaskApiStep()
                .verifyTaskPresentOnApi(TASK_NAME);
    }

    @AfterClass
    public void closeProjects() {
        new ProjectsPage(driver)
                .moveBack();
        new SideBarMenu(driver)
                .open();
        new ProjectsPage(driver)
                .clickToProjects();

    }

}
