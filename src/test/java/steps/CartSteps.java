package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.Header;
import steps.Login.LoginSteps;

public class CartSteps extends LoginSteps {

    Header header;

    public CartSteps(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    @Step("Go to items into cart")
    public void checkDisplayItemsIntoCart(String item1, String item2) {
        productsPage
                .addToCart(item1)
                .addToCart(item2);
        header
                .goToPageCart()
                .isPageOpen();
    }
}
