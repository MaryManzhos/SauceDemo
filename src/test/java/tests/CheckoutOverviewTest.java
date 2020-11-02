package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.*;

public class CheckoutOverviewTest extends BaseTestWithAuthorization {

    @Test
    public void calculationSumOfCost() {
        checkoutSteps.checkOutProducts(ITEM_PRODUCT_NAME_1);
        checkoutInformationPage.successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE);

        assertEquals(checkoutOverviewPage.getValueFromSum().get("Item_Total"), "Item total: $49.99");
        assertEquals(checkoutOverviewPage.getValueFromSum().get("Item_Tax"), "Tax: $4.00");
        assertEquals(checkoutOverviewPage.getValueFromSum().get("Total"), "Total: $53.99");
    }

    @Test
    public void isCanceledToCheckoutInformation() {
        checkoutSteps.checkOutProducts(ITEM_PRODUCT_NAME_1);
        checkoutInformationPage
                .successfulContinueToPageCheckoutOverview(FIRST_NAME, LAST_NAME, ZIP_POSTAL_CODE)
                .returnToPageCheckOutInf();

        assertEquals(productsPage.getNameOfPage(), "Products", "Don't title products");
    }
}
