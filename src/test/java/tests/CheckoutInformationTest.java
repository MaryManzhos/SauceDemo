package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CheckoutInformationTest extends BaseTest {
    @Test
    public void isSuccessfulCheckoutInformation() {
        loginPage.openPage();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.goToCheckoutInformationPage();
        checkoutInformationPage.continueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        assertEquals(checkoutOverviewPage.getTitlePage(), "Checkout: Overview", "Don't title Checkout: Overview");
    }

    @Test
    public void isCanceledToCheckoutInformation() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.isPageOpen();
        cartPage.goToCheckoutInformationPage();
        checkoutInformationPage.returnToPageCart();
        assertEquals(cartPage.getTitleOfPage(), "Your Cart", "Don't title Your Cart");
    }
}
