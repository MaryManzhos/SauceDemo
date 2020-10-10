package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CheckoutInformationTest extends BaseTest {
    @Test
    public void isSuccessfulCheckoutInformation() {
        loginPage.openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart()
                .goToCheckoutInformationPage()
                .successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);

        assertEquals(checkoutOverviewPage.getTitlePage(), "Checkout: Overview", "Don't title Checkout: Overview");
    }

    @Test
    public void isCanceledToCheckoutInformation() {
        loginPage.openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart()
                .isPageOpen()
                .goToCheckoutInformationPage()
                .returnToPageCart();

        assertEquals(cartPage.getTitleOfPage(), "Your Cart", "Don't title Your Cart");
    }

    @Test
    public void showErrorMessageWhenFieldsAreEmpty() {
        loginPage.openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .addToCart(ITEM_PRODUCT_NAME_1);
        header.goToPageCart()
                .isPageOpen()
                .goToCheckoutInformationPage()
                .successfulContinueToPageCheckoutOverview("", "", "");

        assertEquals(checkoutInformationPage.getErrorMessage(), "Error: First Name is required", "Don't display error message");
    }
}
