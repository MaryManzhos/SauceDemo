package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class FinishTest extends BaseTest {
    @Test
    public void orderShouldBeCheckout() {
        loginPage
                .openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .addToCart(ITEM_PRODUCT_NAME_1);
        header
                .goToPageCart()
                .isPageOpen()
                .goToCheckoutInformationPage()
                .successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE)
                .goToPageFinish();

        assertEquals(finishPage.getInfoText(), "THANK YOU FOR YOUR ORDER");
    }
}
