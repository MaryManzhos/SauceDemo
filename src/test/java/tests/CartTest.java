package tests;

import org.testng.annotations.Test;

import static testData.TestData.ITEM_PRODUCT_NAME_1;
import static testData.TestData.ITEM_PRODUCT_NAME_2;

public class CartTest extends BaseTestWithAuthorization {

    @Test(description = "Clickable button BACK")
    public void backToProductPage() {
        cartSteps.checkDisplayItemsIntoCart(ITEM_PRODUCT_NAME_1, ITEM_PRODUCT_NAME_2);
        cartPage.goToProductPage();
        cartSteps.validateTitleOfProductPage();
    }

    @Test(description = "Remove item from CART", retryAnalyzer = RetryAnalyzer.class)
    public void removeItemFromCart() {
        cartSteps.checkDisplayItemsIntoCart(ITEM_PRODUCT_NAME_1, ITEM_PRODUCT_NAME_2);
        cartPage.removeItemFromCart();

        cartSteps.validateRemovedItem();
    }
}
