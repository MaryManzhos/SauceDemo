package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    public static final By CHECKOUT_BUTTON = By.className("checkout_button");
    public static final By REMOVE_BUTTON = By.className("cart_button");
    public static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".cart_footer .btn_secondary");
    public static final By ITEMS = By.className("cart_item");
    public static final By TITLE_OF_PAGE = By.className("subheader");
    String productNameLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_name']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        return this;
    }

    public Map<String, String> getDetailsOfProductIntoCart(String productName) {
        Map<String, String> values = new HashMap<String, String>();
        values.put("Quantity", driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText());
        values.put("Product_Name", driver.findElement(By.xpath(String.format(productNameLocator, productName))).getText());
        values.put("Price", driver.findElement(By.xpath(String.format(priceLocator, productName))).getText());
        return values;
    }

    public boolean isCartEmpty() {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(ITEMS);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public String getTitleOfPage() {
        return driver.findElement(TITLE_OF_PAGE).getText();
    }

    public int getCountOfItems() {
        return driver.findElements(REMOVE_BUTTON).size();
    }

    public CartPage removeItemFromCart() {
        driver.findElements(REMOVE_BUTTON).get(0).click();
        return this;
    }

    public int isItemRemoved() {
        return driver.findElements(REMOVE_BUTTON).size();
    }

    public CheckoutInformationPage goToCheckoutInformationPage() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutInformationPage(driver);
    }

    public ProductsPage goToProductPage() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }
}
