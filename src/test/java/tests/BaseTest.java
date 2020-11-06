package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;
import steps.cart.CartSteps;
import steps.checkout.CheckoutSteps;
import steps.header.HeaderSteps;
import steps.login.LoginSteps;
import steps.productDetails.ProductDetailsStep;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    LoginSteps loginSteps;
    CartSteps cartSteps;
    HeaderSteps headerSteps;
    CheckoutSteps checkoutSteps;
    ProductDetailsStep productDetailsStep;
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    Header header;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    ProductDetailPage productDetailPage;
    FinishPage finishPage;

    @BeforeClass(description = "Create Chrome Driver")
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        header = new Header(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        finishPage = new FinishPage(driver);
        loginSteps = new LoginSteps(driver);
        cartSteps = new CartSteps(driver);
        headerSteps = new HeaderSteps(driver);
        checkoutSteps = new CheckoutSteps(driver);
        productDetailsStep = new ProductDetailsStep(driver);
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
