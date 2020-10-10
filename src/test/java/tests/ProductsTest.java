package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.*;

public class ProductsTest extends BaseTest {
    @Test
    public void productsShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD);
        productsPage
                .isPageOpen()
                .addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.isPageOpen();

        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Quantity"), "1", "Quantity is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Product_Name"), ITEM_PRODUCT_NAME_1, "Product name is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Price"), "49.99", "Price is not correct");
    }

    @Test
    public void displayCounterOnCart() {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");
        assertEquals(header.getCounterFromCart(), "2");
    }

    @Test
    public void productsShouldBeRemovedFromCart() {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.isPageOpen();
        assertTrue(cartPage.isCartEmpty());
    }
}
