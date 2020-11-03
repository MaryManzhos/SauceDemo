package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CheckoutInformationTest extends BaseTestWithAuthorization {
    @Test(description = "Authorization with valid credentials")
    public void isSuccessfulCheckoutInformation() {
        checkoutSteps.checkOutProducts(ITEM_PRODUCT_NAME_1);
        checkoutInformationPage.successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);

        assertEquals(checkoutOverviewPage.getTitlePage(), "Checkout: Overview", "Don't title Checkout: Overview");
    }

    @Test(description = "Clickable button CANCEL", retryAnalyzer = RetryAnalyzer.class)
    public void isCanceledToCheckoutInformation() {
        checkoutSteps.checkOutProducts(ITEM_PRODUCT_NAME_1);
        checkoutInformationPage.returnToPageCart();

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

    @Test(description = "Show error message with authorization with invalid credentials", dataProvider = "Data for test error message")
    public void showErrorMessageWhenFieldsAreEmpty(String firstName, String lastName, String zipPostalCode, String expectedResult) {
        checkoutSteps.checkOutProducts(ITEM_PRODUCT_NAME_1);
        checkoutInformationPage.successfulContinueToPageCheckoutOverview(firstName, lastName, zipPostalCode);

        assertEquals(checkoutInformationPage.getErrorMessage(), expectedResult, "Don't display error message");
    }
}
