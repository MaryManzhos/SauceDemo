package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CartTest extends BaseTestWithAuthorization {

    @Test
    public void backToProductPage() {
        cartSteps.checkDisplayItemsIntoCart(ITEM_PRODUCT_NAME_1,ITEM_PRODUCT_NAME_2);
        cartPage.goToProductPage();

        assertEquals(productsPage.getNameOfPage(), "Products");
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void removeItemFromCart() {
        cartSteps.checkDisplayItemsIntoCart(ITEM_PRODUCT_NAME_1,ITEM_PRODUCT_NAME_2);
        cartPage.removeItemFromCart();

        assertEquals(cartPage.isItemRemoved(), 1);
    }
}
