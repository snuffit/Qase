package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final String EMAIL_CSS = "[name=email]",
            PASSWORD_CSS = "[name=password]",
            SIGN_IN_BUTTON_TEXT = "Sign in";

    public LoginPage openPage() {
        open("/login");
        return this;
    }

    public ProjectsPage login(String login, String password) {
        $(EMAIL_CSS).setValue(login);
        $(PASSWORD_CSS).setValue(password);
        $(byText(SIGN_IN_BUTTON_TEXT)).click();
        return new ProjectsPage();
    }
}
