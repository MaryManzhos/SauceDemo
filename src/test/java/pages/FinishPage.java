package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage extends BasePage {
    public static final By TITLE_OF_PAGE = By.className("subheader");
    public static final By INFO_TEXT = By.className("complete-header");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public FinishPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_OF_PAGE));
        return this;
    }

    public String getInfoText() {
        return driver.findElement(INFO_TEXT).getText();
    }
}
