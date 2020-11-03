package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.ITEM_PRODUCT_NAME_1;

public class ProductDetailsTest extends BaseTestWithAuthorization {

    @Test(description = "Add product into cart from Product Details Page")
    public void addToCartProductFromProductDetailPage() {
        productDetailsStep.goToProductDetails(ITEM_PRODUCT_NAME_1);
        productDetailPage.addToCartProduct();
        headerSteps.goToCart();

        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Quantity"), "1", "Quantity is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Product_Name"), ITEM_PRODUCT_NAME_1, "Product name is not correct");
        assertEquals(cartPage.getDetailsOfProductIntoCart(ITEM_PRODUCT_NAME_1).get("Price"), "49.99", "Price is not correct");
    }

    @Test(description = "Remove product from cart from Product Details Page")
    public void removeProductFromCartFromProductDetailPage() {
        productDetailsStep.goToProductDetails(ITEM_PRODUCT_NAME_1);
        productDetailPage
                .addToCartProduct()
                .addToCartProduct();
        headerSteps.goToCart();

        assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void backToProductPage() {
        productDetailsStep.goToProductDetails(ITEM_PRODUCT_NAME_1);
        productDetailPage.backToProductPage();

        assertEquals(productsPage.getNameOfPage(), "Products");
    }
}
