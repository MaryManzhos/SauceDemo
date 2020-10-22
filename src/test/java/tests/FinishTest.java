package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class FinishTest extends BaseTest {
    @Test
    public void orderShouldBeCheckout() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        productsPage.isPageOpen();
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart();
        cartPage.isPageOpen();
        cartPage.goToCheckoutInformationPage();
        checkoutInformationPage.continueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);
        checkoutOverviewPage.goToPageFinish();
        assertEquals(finishPage.getInfoText(), "THANK YOU FOR YOUR ORDER");
    }
}
