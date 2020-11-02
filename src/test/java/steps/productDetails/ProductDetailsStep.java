package steps.productDetails;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import steps.BaseStep;

public class ProductDetailsStep extends BaseStep {

    public ProductDetailsStep(WebDriver driver) {
        super(driver);
    }

    @Step("Go to Product Details")
    public void goToProductDetails(String item) {
        productsPage
                .goToProductDetails(item)
                .isPageOpen();
    }
}
