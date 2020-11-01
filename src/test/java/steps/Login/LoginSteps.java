package steps.Login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Authorization")
    public void authorization(String username, String password) {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(username,password)
                .isPageOpen();
    }
}
