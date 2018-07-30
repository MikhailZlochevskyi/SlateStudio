package com.slate.steps;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.slate.client.impl.task.TasksClient.getTasksClient;
import static org.awaitility.Awaitility.await;

public class TasksStep {

    public void verifyTaskPresent(String taskName) {
        await().pollInterval(2, TimeUnit.SECONDS).until(() ->
                getTasksClient().getTasks().getResponse().path("content").toString().contains(taskName)
        );
    }

    public void verifyTaskIsNotPresent(String taskName) {
        Assert.assertFalse(getTasksClient().getTasks().getResponse().path("content").toString().contains(taskName));
    }
}
