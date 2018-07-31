package com.slate.steps;

import java.util.concurrent.TimeUnit;

import static com.slate.client.impl.task.TasksClient.getTasksClient;
import static com.slate.pages.TaskPage.verifyTaskDisappear;
import static com.slate.pages.TaskPage.verifyTaskPresent;
import static org.awaitility.Awaitility.await;

public class TaskVerificationStep {

    public void verifyTaskPresentOnApi(String taskName) {
        await().pollInterval(4, TimeUnit.SECONDS).until(() ->
                getTasksClient().getTasks().getResponse().path("content").toString().contains(taskName)
        );
    }

    public void verifyTaskIsNotPresentOnApi(String taskName) {
        await().pollInterval(4, TimeUnit.SECONDS).until(() ->
                !getTasksClient().getTasks().getResponse().path("content").toString().contains(taskName)
        );
    }

    public void verifyTaskPresentOnMobile(String taskName) {
        verifyTaskPresent(taskName);
    }

    public void verifyTaskIsNotPresentOnMobile(String taskName) {
        verifyTaskDisappear(taskName);
    }


}
