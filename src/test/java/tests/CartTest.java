package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CartTest extends BaseTest {

    @Test
    public void backToProductPage() {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .addToCart(ITEM_PRODUCT_NAME_1)
                .addToCart(ITEM_PRODUCT_NAME_2);
        header
                .goToPageCart()
                .isPageOpen()
                .goToProductPage();

        assertEquals(productsPage.getNameOfPage(), "Products");
    }

    @Test
    public void removeItemFromCart() {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .addToCart(ITEM_PRODUCT_NAME_1)
                .addToCart(ITEM_PRODUCT_NAME_2);
        header
                .goToPageCart()
                .isPageOpen()
                .removeItemFromCart();

        assertEquals(cartPage.isItemRemoved(), 1);
    }
}
