package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static testData.TestData.URL;

public class LoginFluentChainOfInvocationPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginFluentChainOfInvocationPage(WebDriver driver) {
        super(driver);
    }

    public LoginFluentChainOfInvocationPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    public LoginFluentChainOfInvocationPage openPage() {
        driver.get(URL);
        return this;
    }

    public LoginFluentChainOfInvocationPage failedLogIn(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public ProductsPage successfulLogIn(String username, String password) {
        failedLogIn(username, password);
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
