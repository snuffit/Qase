package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @DataProvider
    public Object[][] projectData() {
        return new Object[][] {
            {"qaTest", "something", false}
        };
    }

    @Test(dataProvider = "projectData")
    public void checkCreateProject(String project, String description, boolean isPrivate) {
        loginPage.openPage()
                .login(user, password)
                .waitTillOpened()
                .createNewProject(project, description, isPrivate);
        projectsPage.openPage()
                .isProjectCreated(project)
                .deleteProject(project)
                .isProjectDeleted(project);
    }

    @Test(testName = "Тест для проверки работы скриншота")
    public void checkDeleteProject() {
        loginPage.openPage()
                .login(user, password)
                .waitTillOpened()
                .deleteProject("Sharelan");

    }
}
