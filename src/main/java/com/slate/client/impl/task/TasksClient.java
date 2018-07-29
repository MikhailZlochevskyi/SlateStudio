package com.slate.client.impl.task;

import com.jayway.restassured.response.Response;
import com.slate.client.ResponseWrapper;
import com.slate.client.RestClient;
import com.slate.client.impl.project.ProjectClient;

public class TasksClient extends RestClient {

    private static ProjectClient client = new ProjectClient();
    private static String TASKS = "/tasks";

    public static ProjectClient getTasksClient() {
        return client;
    }

    public ResponseWrapper<Response> getTasks() {
        return get(TASKS, Response.class);
    }

    public ResponseWrapper<Response> reopenTask(String id) {
        return post(TASKS + "/" + id + "/reopen", Response.class);
    }

}
