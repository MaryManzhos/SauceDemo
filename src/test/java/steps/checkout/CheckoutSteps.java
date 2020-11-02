package steps.checkout;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import steps.BaseStep;

public class CheckoutSteps extends BaseStep {

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Checkout products")
    public void checkOutProducts(String item1) {
        productsPage
                .addToCart(item1);
        header
                .goToPageCart()
                .isPageOpen()
                .goToCheckoutInformationPage();
    }

}
