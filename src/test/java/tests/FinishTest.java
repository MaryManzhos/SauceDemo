package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class FinishTest extends BaseTestWithAuthorization {
    @Test(description = "Verify order")
    public void orderShouldBeCheckout() {
        checkoutSteps.checkOutProducts(ITEM_PRODUCT_NAME_1);
        checkoutInformationPage
                .successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE)
                .isPageOpen()
                .goToPageFinish()
                .isPageOpen();

        assertEquals(finishPage.getInfoText(), "THANK YOU FOR YOUR ORDER");
    }
}
