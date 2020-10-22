package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CartTest extends BaseTest {

    @Test
    public void backToProductPage() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        productsPage.addToCart(ITEM_PRODUCT_NAME_2);
        header.goToPageCart();
        cartPage.isPageOpen();
        cartPage.goToProductPage();
        assertEquals(productsPage.getNameOfPage(), "Products");
    }

    @Test
    public void removeItemFromCart() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        productsPage.addToCart(ITEM_PRODUCT_NAME_2);
        header.goToPageCart();
        cartPage.isPageOpen();
        cartPage.removeItemFromCart(0);
        assertEquals(cartPage.isItemRemoved(),1);
    }
}
