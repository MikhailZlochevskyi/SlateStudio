package com.slate.client.impl.project;

import com.jayway.restassured.response.Response;
import com.slate.client.ResponseWrapper;
import com.slate.client.RestClient;

public class ProjectClient extends RestClient {

    private static ProjectClient client = new ProjectClient();
    private static String PROJECTS = "/projects";

    public static ProjectClient getProjectClient() {
        return client;
    }

    public ResponseWrapper<Response> createProject(String name) {
        String body = "{\"name\":" + name + "}";
        return post(PROJECTS, body, Response.class);
    }

    public ResponseWrapper<Response> deleteProject(String id) {
        return delete(PROJECTS + "/" + id, Response.class);
    }

}
