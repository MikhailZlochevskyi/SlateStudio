package com.slate.steps.mobile;

import com.slate.steps.api.TaskApiStep;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.slate.client.impl.task.TasksClient.getTasksClient;
import static com.slate.pages.TaskPage.verifyTaskDisappear;
import static com.slate.pages.TaskPage.verifyTaskPresent;
import static org.awaitility.Awaitility.await;

public class TaskMobileStep {

//    public void reopenUntilVisibleOnMobile(String taskName) {
//        await().pollInterval(4, TimeUnit.SECONDS).atMost(60, TimeUnit.SECONDS)
//                .until(() -> verifyTaskPresentOnMobile(taskName));
//
//    }
//
//    private boolean verifyTaskPresentOnMobile(String taskName) {
//        long taskId = new TaskApiStep().getLastAddedTaskId();
//        getTasksClient()
//                .reopenTask(taskId);
//        return By.xpath("//android.widget.TextView[@text='" + taskName + "']")).isDisplayed();
//    }


    public void verifyTaskPresentOnMobile(String taskName) {
        verifyTaskPresent(taskName);
    }

    public void verifyTaskIsNotPresentOnMobile(String taskName) {
        verifyTaskDisappear(taskName);
    }

}
