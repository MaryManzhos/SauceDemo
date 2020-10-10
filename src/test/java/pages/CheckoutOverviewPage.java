package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class CheckoutOverviewPage extends BasePage {
    public static final By TITLE_PAGE = By.className("subheader");
    public static final By TOTAL_ITEM = By.className("summary_subtotal_label");
    public static final By TAX_ITEM = By.className("summary_tax_label");
    public static final By TOTAL = By.className("summary_total_label");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_PAGE));
    }

    public String getTitlePage() {
        return driver.findElement(TITLE_PAGE).getText();
    }

    public Map<String,String> getValueFromSum() {
        Map<String, String> valuesOfSum = new HashMap<String, String>();
        valuesOfSum.put("Item_Total", driver.findElement(TOTAL_ITEM).getText());
        valuesOfSum.put("Item_Tax", driver.findElement(TAX_ITEM).getText());
        valuesOfSum.put("Total", driver.findElement(TOTAL).getText());
        return valuesOfSum;
    }

    public void returnToPageCheckOutInf() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
