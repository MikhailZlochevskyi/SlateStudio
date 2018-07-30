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
        new ProjectsPage(driver)
                .passToProjects()
                .pickProject(PROJECT_NAME);
        new TaskPage(driver)
                .pickTask(TASK_NAME)
                .resolveTask()
                .verifyTaskDisappear(TASK_NAME);
    }

    @Test
    public void checkTaskReopenViaApi() {
        getTasksClient()
                .reopenTask("2735000216");//todo: get id from response tasks
        new TaskPage(driver)
                .verifyTaskPresent(TASK_NAME);
    }

}
