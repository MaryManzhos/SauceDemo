package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CheckoutInformationTest extends BaseTest {
    @Test
    public void isSuccessfulCheckoutInformation() {
        loginPage.openPage();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        header.goToPageCart();
        cartPage.goToCheckoutInformationPage();
        checkoutInformationPage.continueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        assertEquals(checkoutOverviewPage.getTitlePage(), "Checkout: Overview", "Don't title Checkout: Overview");
    }
}
