package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    public static final By TITLE_PAGE = By.className("subheader");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getTitlePage() {
        return driver.findElement(TITLE_PAGE).getText();
    }
}
