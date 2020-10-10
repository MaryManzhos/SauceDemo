package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static testData.TestData.*;

public class ProductDetailsTest extends BaseTest{

    @Test
    public void addToCartProductFromProductDetailPage() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1,PASSWORD);
        productsPage.isPageOpen();
        productsPage.goToProductDetails(ITEM_PRODUCT_NAME_1);
        productDetailPage.isPageOpen();
        productDetailPage.addToCartProduct();
        header.goToPageCart();
        cartPage.isPageOpen();
        cartPage.productDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
    }

    @Test
    public void removeProductFromCartFromProductDetailPage() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1,PASSWORD);
        productsPage.isPageOpen();
        productsPage.goToProductDetails(ITEM_PRODUCT_NAME_1);
        productDetailPage.isPageOpen();
        productDetailPage.addToCartProduct();
        productDetailPage.addToCartProduct();
        header.goToPageCart();
        cartPage.isPageOpen();
        assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void backToProductPage() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1,PASSWORD);
        productsPage.isPageOpen();
        productsPage.goToProductDetails(ITEM_PRODUCT_NAME_1);
        productDetailPage.isPageOpen();
        productDetailPage.backToProductPage();
        assertEquals(productsPage.getNameOfPage(),"Products");
    }
}
