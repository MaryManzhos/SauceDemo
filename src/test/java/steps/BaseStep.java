package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public abstract class BaseStep {

    protected CartPage cartPage;
    protected CheckoutInformationPage checkoutInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected FinishPage finishPage;
    protected Header header;
    protected LoginPage loginPage;
    protected ProductDetailPage productDetailPage;
    protected ProductsPage productsPage;

    public BaseStep(WebDriver driver) {
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        finishPage = new FinishPage(driver);
        header = new Header(driver);
        loginPage = new LoginPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productsPage = new ProductsPage(driver);
    }
}
