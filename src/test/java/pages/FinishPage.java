package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage extends BasePage {
    public static final By TITLE_OF_PAGE = By.cssSelector(".subheader");
    public static final By INFO_TEXT = By.cssSelector(".complete-header");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_OF_PAGE));
    }

    public String getInfoText() {
        return driver.findElement(INFO_TEXT).getText();
    }
}
