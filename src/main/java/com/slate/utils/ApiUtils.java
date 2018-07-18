package com.slate.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

public class ApiUtils {

    final static Logger log = Logger.getLogger(ApiUtils.class);

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
        log.info("Project has been created: " + response.getBody().print());
        return response;
    }

    public void deleteProject(String id){
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_TOKEN)
                .delete("/projects/" + id);
        Assert.assertEquals(response.getStatusCode(), 204);
    }

}
