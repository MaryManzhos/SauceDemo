package steps.cart;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import steps.BaseStep;

public class CartSteps extends BaseStep {

    public CartSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Go to added items into cart")
    public void checkDisplayItemsIntoCart(String item1, String item2) {
        productsPage
                .addToCart(item1)
                .addToCart(item2);
        header
                .goToPageCart()
                .isPageOpen();
    }

    @Step("Clear cart")
    public void clearCart(){
        header
                .goToPageCart()
                .isPageOpen();

        if (!cartPage.isCartEmpty()) {

            int countOfItems = cartPage.getCountOfItems();
            int countOfRemovedItems = 0;

            while (countOfRemovedItems < countOfItems) {
                cartPage.removeItemFromCart();
                countOfRemovedItems++;
            }
        }
    }


}
