package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {

    public static final By CHECKOUT_BUTTON = By.className("checkout_button");
    public static final By ITEMS = By.className("cart_item");
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
    }

    public void productDetailsShouldBeLike(String productName, String quantity, String price) {
        String actualPrice = driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
        String actualQuantity = driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
        assertEquals(actualPrice, price, "Price is not correct");
        assertEquals(actualQuantity, quantity, "Price is not correct");
    }

    public boolean isCartEmpty() {
        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(ITEMS);
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }

    public void goToCheckoutInformationPage() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
