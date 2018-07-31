package com.slate.tests;

import com.slate.BaseTest;
import com.slate.pages.ProjectsPage;
import com.slate.pages.components.SideBarMenu;
import com.slate.steps.api.ProjectApiStep;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.slate.tests.data.DataProvider.PROJECT_NAME;

public class CreateProjectTest extends BaseTest {

    @BeforeClass
    public void createFolder() {
        new ProjectApiStep()
                .createProjectAndVerifySchema();
    }

    @Test
    public void checkProjectPresent() {
        new SideBarMenu(driver)
                .open();

        new ProjectsPage(driver)
                .clickToProjects()
                .verifyProjectPresent(PROJECT_NAME);
    }

    @AfterClass
    public void  closeProjects() {
        new ProjectsPage(driver)
                .clickToProjects()
                .moveBack();

//        String projectId = project.path("id").toString(); todo: move clean up to AfterSuite
//        new ApiUtils().deleteProject(projectId);
//        driver.navigate().back();
    }

}