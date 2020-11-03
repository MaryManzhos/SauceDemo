package steps.cart;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import steps.BaseStep;

import static org.testng.Assert.assertEquals;

public class CartSteps extends BaseStep {

    public CartSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Go to cart with added items")
    public void checkDisplayItemsIntoCart(String item1, String item2) {
        productsPage
                .addToCart(item1)
                .addToCart(item2);
        header
                .goToPageCart()
                .isPageOpen();
    }

    @Step("Clear cart")
    public void clearCart() {
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

    public void validateTitleOfProductPage() {
        assertEquals(productsPage.getNameOfPage(), "Products");
    }

    public void validateRemovedItem() {
        assertEquals(cartPage.isItemRemoved(), 1);
    }
}
