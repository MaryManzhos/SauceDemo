package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public static final By NAME_OF_PAGE_PRODUCTS = By.cssSelector(".product_label");
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    String itemProduct = "//*[contains(text(),'%s')]//ancestor::div[@class='inventory_item_name']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfPage() {
        return driver.findElement(NAME_OF_PAGE_PRODUCTS).getText();
    }

    public ProductsPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_OF_PAGE_PRODUCTS));
        return this;
    }

    @Step("Add item to cart")
    public ProductsPage addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
        return this;
    }

    @Step("Go to product details")
    public ProductDetailPage goToProductDetails(String productName) {
        driver.findElement(By.xpath(String.format(itemProduct, productName))).click();
        return new ProductDetailPage(driver);
    }

}
