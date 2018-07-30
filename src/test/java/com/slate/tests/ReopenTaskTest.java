package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.ProjectsPage;
import com.slate.pages.TaskPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.client.impl.task.TasksClient.getTasksClient;
import static com.slate.tests.data.TodoistDataProvider.PROJECT_NAME;
import static com.slate.tests.data.TodoistDataProvider.TASK_NAME;

public class ReopenTaskTest extends BaseTest {

    @BeforeClass
    public void resolveTask() {
        new ProjectsPage().passToProjects(driver).pickProject(driver, PROJECT_NAME);
        new TaskPage()
                .pickTask(driver, TASK_NAME)
                .resolveTask(driver)
                .verifyTaskDisappear(driver, TASK_NAME);
    }

    @Test
    public void checkTaskReopenViaApi() {
        getTasksClient().reopenTask("2735000216");//todo: get id from response tasks
        new TaskPage().verifyTaskPresent(driver, TASK_NAME);
    }

}
