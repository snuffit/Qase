package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {

    final String CREATE_NEW_PROJECT_TEXT = "Create new project";

    public ProjectsPage waitTillOpened() {
        $(byText(CREATE_NEW_PROJECT_TEXT)).shouldBe(visible);
        return this;
    }

    public ProjectsPage openPage() {
        open("/projects");
        return this;
    }

    public ProjectPage createNewProject(String project, String description, boolean isPrivate) {
        $(byText(CREATE_NEW_PROJECT_TEXT)).click();
        $(byId("project-name")).setValue(project);
        $(byId("description-area")).setValue(description);
        if (isPrivate) {
            $("[value=private]").click();
        } else {
            $("[value=public]").click();
        }
        $(byText("Create project")).click();
        return new ProjectPage();
    }

    public ProjectsPage deleteProject(String project) {
        $(byText(project))
                .ancestor("tbody")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $x("//span[text()='Delete project']").click();
        return this;
    }

    public ProjectsPage isProjectCreated(String project) {
        $(byText(project))
                .ancestor("tbody")
                .find("button[aria-label='Open action menu']")
                .shouldBe(visible);
        return this;
    }

    public ProjectsPage isProjectDeleted(String project) {
        $(byText(project))
                .ancestor("tbody")
                .find("button[aria-label='Open action menu']")
                .shouldNot(visible);
        return this;
    }
}
