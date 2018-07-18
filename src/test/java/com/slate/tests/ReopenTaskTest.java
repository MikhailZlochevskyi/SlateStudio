package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.ProjectsPage;
import com.slate.pages.TaskPage;
import com.slate.utils.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReopenTaskTest extends BaseTest {

    //    private String taskName = "SlateTask-" + Math.random() * 1000 + 1;
    private String taskName = "123";

    @BeforeClass
    public void createTask() {
        new ProjectsPage().passToProjects(wait).pickProject(driver, wait, "New1");
        new TaskPage()
                .pickTask(wait, driver, taskName)
                .resolveTask(wait)
                .verifyTaskDisappear(driver, wait, taskName);
    }

    @Test
    public void checkTaskReopenViaApi() {
        new ApiUtils().reopenTask("2735000216");
        new TaskPage().verifyTaskPresent(driver, wait, taskName);
    }
}
