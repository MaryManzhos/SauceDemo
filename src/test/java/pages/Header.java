package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {

    public static final By MENU_ICON = By.className("bm-burger-button");
    public static final By CART_ICON = By.cssSelector("[data-icon=shopping-cart]");
    public static final By CART_COUNTER = By.className("shopping_cart_badge");

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

    public CartPage goToPageCart() {
        driver.findElement(CART_ICON).click();
        return new CartPage(driver);
    }
}
