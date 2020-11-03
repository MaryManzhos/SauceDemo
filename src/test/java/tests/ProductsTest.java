package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.ITEM_PRODUCT_NAME_1;
import static testData.TestData.ITEM_PRODUCT_NAME_2;

public class ProductsTest extends BaseTestWithAuthorization {

    @Test(description = "Add product to cart from Product page")
    public void productsShouldBeAddedIntoCart() {
        productsPage.addToCart(ITEM_PRODUCT_NAME_1);
        headerSteps.goToCart();

        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Quantity"), "1", "Quantity is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Product_Name"), ITEM_PRODUCT_NAME_1, "Product name is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Price"), "49.99", "Price is not correct");
    }

    @Test(description = "Display counter on cart icon")
    public void displayCounterOnCart() {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1)
                .addToCart(ITEM_PRODUCT_NAME_2);

        assertEquals(header.getCounterFromCart(), "2");
    }

    @Test(description = "Remove product from cart from Product Page")
    public void productsShouldBeRemovedFromCart() {
        productsPage
                .addToCart(ITEM_PRODUCT_NAME_1)
                .addToCart(ITEM_PRODUCT_NAME_1);
        headerSteps.goToCart();

        assertTrue(cartPage.isCartEmpty());
    }
}
