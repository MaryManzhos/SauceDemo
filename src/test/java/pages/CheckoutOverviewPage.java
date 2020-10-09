package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {
    public static final By TITLE_PAGE = By.className("subheader");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_PAGE));
    }

    public String getTitlePage() {
        return driver.findElement(TITLE_PAGE).getText();
    }
}
