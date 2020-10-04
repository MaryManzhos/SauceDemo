package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    public static final By MENU_ICON = By.className("bm-burger-button");
    public static final By CART_COUNTER = By.className("shopping_cart_badge");

    public Header(WebDriver driver) {
        super(driver);
    }

    public String getCounterFromCart() {
        return driver.findElement(CART_COUNTER).getText();
    }
}
