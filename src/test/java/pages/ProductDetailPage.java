package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static testData.TestData.ITEM_PRODUCT_NAME_1;

public class ProductDetailPage extends BasePage {

    public static final By ADD_TO_CART_BUTTON = By.className("btn_inventory");
    public static final By BACK_BUTTON = By.className("inventory_details_back_button");
    String nameOfProduct = "//*[contains(text(),'%s')]//ancestor::div[@class='inventory_details_name']";

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(nameOfProduct, ITEM_PRODUCT_NAME_1))));
        return this;
    }

    public ProductDetailPage addToCartProduct() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public ProductsPage backToProductPage() {
        driver.findElement(BACK_BUTTON).click();
        return new ProductsPage(driver);
    }
}
