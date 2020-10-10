package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.*;

public class ProductDetailsTest extends BaseTest {

    @Test
    public void addToCartProductFromProductDetailPage() {
        loginPage.openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
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
        loginPage.openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .isPageOpen()
                .goToProductDetails(ITEM_PRODUCT_NAME_1)
                .isPageOpen()
                .addToCartProduct()
                .addToCartProduct();
        header.goToPageCart()
                .isPageOpen();

        assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void backToProductPage() {
        loginPage.openPage()
                .isPageOpen()
                .successfulLogIn(USERNAME_1, PASSWORD)
                .isPageOpen()
                .goToProductDetails(ITEM_PRODUCT_NAME_1)
                .isPageOpen()
                .backToProductPage();

        assertEquals(productsPage.getNameOfPage(), "Products");
    }
}
