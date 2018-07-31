package com.slate.steps.api;

import static com.slate.client.impl.project.ProjectClient.getProjectClient;
import static com.slate.tests.data.DataProvider.PROJECT_NAME;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProjectApiStep {

    public ProjectApiStep createProjectAndVerifySchema() {
        getProjectClient()
                .createProject(PROJECT_NAME)
                .getResponse().then()
                .assertThat().body(matchesJsonSchemaInClasspath("json/create_project_schema.json"))
                .assertThat().statusCode(200);
        return this;
    }

}
