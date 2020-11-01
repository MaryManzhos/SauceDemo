package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInformationPage extends BasePage {
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    public static final By CONTINUE_BUTTON = By.cssSelector(".cart_button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        return this;
    }

    public CheckoutOverviewPage successfulContinueToPageCheckoutOverview(String firstName, String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Click button CANCEL")
    public void returnToPageCart() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
