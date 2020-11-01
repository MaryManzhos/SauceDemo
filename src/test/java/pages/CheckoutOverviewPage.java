package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class CheckoutOverviewPage extends BasePage {
    public static final By TITLE_PAGE = By.cssSelector(".subheader");
    public static final By TOTAL_ITEM = By.cssSelector(".summary_subtotal_label");
    public static final By TAX_ITEM = By.cssSelector(".summary_tax_label");
    public static final By TOTAL = By.cssSelector(".summary_total_label");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_PAGE));
        return this;
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

    public FinishPage goToPageFinish() {
        driver.findElement(FINISH_BUTTON).click();
        return new FinishPage(driver);
    }
}
