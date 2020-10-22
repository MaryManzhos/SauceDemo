package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.ITEM_PRODUCT_NAME_1;

public class ProductDetailsTest extends BaseTestWithAuthorization {

    @Test
    public void addToCartProductFromProductDetailPage() {
        productsPage
                .goToProductDetails(ITEM_PRODUCT_NAME_1)
                .isPageOpen()
                .addToCartProduct();
        header.goToPageCart()
                .isPageOpen();

        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Quantity"), "1", "Quantity is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Product_Name"), ITEM_PRODUCT_NAME_1, "Product name is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Price"), "49.99", "Price is not correct");
    }

    @Test
    public void removeProductFromCartFromProductDetailPage() {
        productsPage
                .goToProductDetails(ITEM_PRODUCT_NAME_1)
                .isPageOpen()
                .addToCartProduct()
                .addToCartProduct();
        header
                .goToPageCart()
                .isPageOpen();

        assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void backToProductPage() {
        productsPage
                .goToProductDetails(ITEM_PRODUCT_NAME_1)
                .isPageOpen()
                .backToProductPage();

        assertEquals(productsPage.getNameOfPage(), "Products");
    }
}
