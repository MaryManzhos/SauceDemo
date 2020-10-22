package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CheckoutInformationTest extends BaseTestWithAuthorization {
    @Test
    public void isSuccessfulCheckoutInformation() {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1);
        header
                .goToPageCart()
                .goToCheckoutInformationPage()
                .successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);

        assertEquals(checkoutOverviewPage.getTitlePage(), "Checkout: Overview", "Don't title Checkout: Overview");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void isCanceledToCheckoutInformation() {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1);
        header
                .goToPageCart()
                .isPageOpen()
                .goToCheckoutInformationPage()
                .returnToPageCart();

        assertEquals(cartPage.getTitleOfPage(), "Your Cart", "Don't title Your Cart");
    }

    @DataProvider(name = "Data for test error message")
    public Object[][] dataForTestErrorMessage() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", LAST_NAME, ZIP_POSTAL_CODE, "Error: First Name is required"},
                {FIRST_NAME, "", ZIP_POSTAL_CODE, "Error: Last Name is required"},
                {FIRST_NAME, LAST_NAME, "", "Error: Postal Code is required"}
        };
    }

    @Test(dataProvider = "Data for test error message")
    public void showErrorMessageWhenFieldsAreEmpty(String firstName, String lastName, String zipPostalCode, String expectedResult) {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1);
        header
                .goToPageCart()
                .isPageOpen()
                .goToCheckoutInformationPage()
                .successfulContinueToPageCheckoutOverview(firstName, lastName, zipPostalCode);

        assertEquals(checkoutInformationPage.getErrorMessage(), expectedResult, "Don't display error message");
    }
}
