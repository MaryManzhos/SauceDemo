package tests;

import org.testng.annotations.Test;

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

}
