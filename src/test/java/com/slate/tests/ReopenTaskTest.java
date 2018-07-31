package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.TaskPage;
import com.slate.steps.api.TaskApiStep;
import com.slate.steps.mobile.TaskMobileStep;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.DataProvider.TASK_NAME;

public class ReopenTaskTest extends BaseTest {

    @BeforeClass
    public void resolveTask() {
        new TaskPage(driver)
                .pickTask(TASK_NAME)
                .resolveTask();
        new TaskMobileStep()
                .verifyTaskIsNotPresentOnMobile(TASK_NAME);
        new TaskApiStep()
                .verifyTaskIsNotPresentOnApi(TASK_NAME);

    }

    @Test
    public void checkTaskReopenViaApi() {
        new TaskMobileStep().verifyTaskPresentOnMobile(TASK_NAME);
    }

}
