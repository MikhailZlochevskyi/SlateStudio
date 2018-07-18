package com.slate.tests;

import com.jayway.restassured.response.Response;
import com.slate.pages.LoginPage;
import com.slate.pages.ProjectsPage;
import com.slate.utils.ApiUtils;
import com.slate.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseTest {

    private String projectName = "Slate";
    private Response project;

    @BeforeClass
    public void createFolder() {
        project = new ApiUtils().createProject(projectName);
    }

    @AfterClass
    public void cleanUp() {
        String projectId = project.path("id").toString();
        new ApiUtils().deleteProject(projectId);
    }

    @Test
    public void checkProjectPresent() {
        new ProjectsPage()
                .passToProjects(wait)
                .verifyProjectPresent(driver, wait, projectName);
    }


}