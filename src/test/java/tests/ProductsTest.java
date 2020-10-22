package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.*;

public class ProductsTest extends BaseTest {
    @Test
    public void productsShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.isPageOpen();
        cartPage.productDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
    }

    @Test
    public void displayCounterOnCart() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Bike Light");
        assertEquals(header.getCounterFromCart(), "2");
    }

    @Test
    public void productsShouldBeRemovedFromCart() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.isPageOpen();
        assertTrue(cartPage.isCartEmpty());
    }
}
