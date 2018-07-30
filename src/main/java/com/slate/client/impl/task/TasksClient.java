package com.slate.client.impl.task;

import com.jayway.restassured.response.Response;
import com.slate.client.ResponseWrapper;
import com.slate.client.RestClient;

public class TasksClient extends RestClient {

    private static TasksClient client = new TasksClient();
    private static String TASKS = "/tasks";

    public static TasksClient getTasksClient() {
        return client;
    }

    public ResponseWrapper<Response> getTasks() {
        return get(TASKS, Response.class);
    }

    public ResponseWrapper<Response> reopenTask(String id) {
        return post(TASKS + "/" + id + "/reopen", Response.class);
    }

}