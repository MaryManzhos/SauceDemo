package tests;

import org.testng.annotations.Test;

import static testData.TestData.PASSWORD;
import static testData.TestData.USERNAME_1;

public class ProductsTest extends BaseTest {
    @Test
    public void productsShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.productDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
    }
}
