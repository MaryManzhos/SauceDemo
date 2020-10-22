package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {

    public static final By MENU_ICON = By.cssSelector(".bm-burger-button");
    public static final By CART_ICON = By.cssSelector("[data-icon=shopping-cart]");
    public static final By CART_COUNTER = By.cssSelector(".shopping_cart_badge");
    public static final By PRODUCT_PAGE = By.id("inventory_sidebar_link");

    public Header(WebDriver driver) {
        super(driver);
    }

    public String getCounterFromCart() {
        return driver.findElement(CART_COUNTER).getText();
    }

    public Header isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MENU_ICON));
        return this;
    }

    public Header isItemClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(PRODUCT_PAGE));
        return this;
    }

    public CartPage goToPageCart() {
        driver.findElement(CART_ICON).click();
        return new CartPage(driver);
    }

    public Header showMenu() {
        driver.findElement(MENU_ICON).click();
        return this;
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(PRODUCT_PAGE).click();
        return new ProductsPage(driver);
    }
}
