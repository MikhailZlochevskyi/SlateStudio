package com.slate.steps.api;

import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.response.Response;
import com.slate.pojo.task.Task;

import java.util.concurrent.TimeUnit;

import static com.slate.client.impl.task.TasksClient.getTasksClient;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.awaitility.Awaitility.await;

public class TaskApiStep {

    public long getLastAddedTaskId() {
        Task[] tasks = getTasksClient().getTasks().getResponse().as(Task[].class, ObjectMapperType.GSON);
        int tasksCnt = tasks.length;
        return tasks[tasksCnt - 1].getId();
    }


    public Response getTasks() {
        Response tasks = getTasksClient().getTasks().getResponse();
        tasks.then()
                .assertThat().body(matchesJsonSchemaInClasspath("json/get_tasks_schema.json"))
                .assertThat().statusCode(200);
        return tasks;
    }

    public void verifyTaskPresentOnApi(String taskName) {
        await().pollInterval(4, TimeUnit.SECONDS).until(() ->
                new TaskApiStep().getTasks().path("content").toString().contains(taskName)
        );
    }

    public void verifyTaskIsNotPresentOnApi(String taskName) {
        await().pollInterval(4, TimeUnit.SECONDS).until(() ->
                !new TaskApiStep().getTasks().path("content").toString().contains(taskName)
        );
    }

}
