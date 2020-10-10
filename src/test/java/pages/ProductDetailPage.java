package pages;

import org.openqa.selenium.By;
import static testData.TestData.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage{

    public static final By ADD_TO_CART_BUTTON = By.className("btn_inventory");
    public static final By BACK_BUTTON = By.className("inventory_details_back_button");
    String nameOfProduct = "//*[contains(text(),'%s')]//ancestor::div[@class='inventory_details_name']";

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(nameOfProduct,ITEM_PRODUCT_NAME_1))));
    }

    public void addToCartProduct() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
}
