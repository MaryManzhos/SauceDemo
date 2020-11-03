package steps.header;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import steps.BaseStep;

public class HeaderSteps extends BaseStep {

    public HeaderSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Go to Cart")
    public void goToCart() {
        header
                .goToPageCart()
                .isPageOpen();
    }

    @Step("Go to page Products")
    public void goToProductsPage() {
        header
                .isPageOpen()
                .showMenu()
                .isItemClickable()
                .goToProductsPage()
                .isPageOpen();
    }
}
