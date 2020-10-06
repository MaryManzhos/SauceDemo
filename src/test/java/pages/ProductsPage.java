package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public static final By NAME_OF_PAGE_PRODUCTS = By.className("product_label");
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfPage() {
        return driver.findElement(NAME_OF_PAGE_PRODUCTS).getText();
    }

    public void isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_OF_PAGE_PRODUCTS));
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }
}
