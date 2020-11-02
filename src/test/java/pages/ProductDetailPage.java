package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static testData.TestData.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage{

    public static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn_inventory");
    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    String nameOfProduct = "//*[contains(text(),'%s')]//ancestor::div[@class='inventory_details_name']";

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(nameOfProduct,ITEM_PRODUCT_NAME_1))));
        return this;
    }

    @Step("Click button ADD TO CART")
    public ProductDetailPage addToCartProduct() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    @Step("Click button BACK")
    public void backToProductPage() {
        driver.findElement(BACK_BUTTON).click();
    }
}
