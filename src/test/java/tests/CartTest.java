package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.ITEM_PRODUCT_NAME_1;
import static testData.TestData.ITEM_PRODUCT_NAME_2;

public class CartTest extends BaseTestWithAuthorization {

    @Test
    public void backToProductPage() {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1)
                .addToCart(ITEM_PRODUCT_NAME_2);
        header
                .goToPageCart()
                .isPageOpen()
                .goToProductPage();

        assertEquals(productsPage.getNameOfPage(), "Products");
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void removeItemFromCart() {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1)
                .addToCart(ITEM_PRODUCT_NAME_2);
        header
                .goToPageCart()
                .isPageOpen()
                .removeItemFromCart();

        assertEquals(cartPage.isItemRemoved(), 1);
    }
}
