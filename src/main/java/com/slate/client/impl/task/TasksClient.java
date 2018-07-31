package com.slate.client.impl.task;

import com.jayway.restassured.response.Response;
import com.slate.client.ResponseWrapper;
import com.slate.client.RestClient;
import com.slate.pojo.task.Task;

public class TasksClient extends RestClient {

    private static TasksClient client = new TasksClient();
    private static String TASKS = "/tasks";

    public static TasksClient getTasksClient() {
        return client;
    }

    public ResponseWrapper<Task> getTasks() {
        return get(TASKS, Task.class);
    }

    public ResponseWrapper<Task> getTaskById(long id) {
        return get(TASKS + "/" + id, Task.class);
    }

    public ResponseWrapper<Response> reopenTask(long id) {
        return post(TASKS + "/" + id + "/reopen", Response.class);
    }



}