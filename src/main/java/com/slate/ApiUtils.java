package com.slate;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

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
