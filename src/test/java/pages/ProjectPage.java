package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public ProjectPage waitTillOpened() {
        $(byText("Create new suite")).shouldBe(visible);
        return this;
    }
}
