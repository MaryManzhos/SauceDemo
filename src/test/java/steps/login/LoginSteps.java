package steps.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import steps.BaseStep;

public class LoginSteps extends BaseStep {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Authorization with username '{username}'")
    public void authorization(String username, String password) {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(username, password)
                .isPageOpen();
    }
}
