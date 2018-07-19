package com.slate.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;
import static org.awaitility.Awaitility.await;

@Log4j
public class ApiUtils {


    public static final String API_TOKEN = "e0529a0699b5a102c741fc8d2942476efffd4838";

    public ApiUtils() {
        RestAssured.baseURI = "https://beta.todoist.com/API/v8";
    }

    public Response createProject(String name) {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_TOKEN)
                .queryParam("name", name)
                .post("/projects");
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Project has been created: " + response.getBody().prettyPrint());
        return response;
    }

    public void deleteProject(String id) {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_TOKEN)
                .delete("/projects/" + id);
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    public Response getTasks() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_TOKEN)
                .get("/tasks");
        Assert.assertEquals(response.getStatusCode(), 200);
        log.info("Tasks: " + response.getBody());
        return response;
    }

    public Response reopenTask(String id) {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_TOKEN)
                .post("/tasks/" + id + "/reopen");
        Assert.assertEquals(response.getStatusCode(), 204);
        log.info("Reopened: " + id);
        return response;
    }

    public void verifyTaskPresent(String taskName) {
        await().pollInterval(2, TimeUnit.SECONDS).until(() ->
                new ApiUtils().getTasks().path("content").toString().contains(taskName)
        );
    }

    public void verifyTaskIsNotPresent(String taskName) {
        Assert.assertFalse(new ApiUtils().getTasks().path("content").toString().contains(taskName));
    }

}
