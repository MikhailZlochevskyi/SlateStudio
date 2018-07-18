package com.slate.tests;

import com.jayway.restassured.response.Response;
import com.slate.BaseTest;
import com.slate.pages.ProjectsPage;
import com.slate.utils.ApiUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.TodoistDataProvider.PROJECT_NAME;

public class CreateProjectTest extends BaseTest {

    private Response project;

    @BeforeClass
    public void createFolder() {
        project = new ApiUtils()
                .createProject(PROJECT_NAME);
    }

    @Test
    public void checkProjectPresent() {
        new ProjectsPage()
                .passToProjects(driver)
                .verifyProjectPresent(driver, PROJECT_NAME);
    }

    @AfterClass
    public void cleanUp() {
//        String projectId = project.path("id").toString(); todo: move clean up to AfterSuite
//        new ApiUtils().deleteProject(projectId);
        driver.navigate().back();
    }

}