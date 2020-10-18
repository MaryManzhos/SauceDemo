package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    //LoginPage loginPage;
    //LoginPageFactory loginPage;
    LoginFluentChainOfInvocationPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    Header header;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    ProductDetailPage productDetailPage;
    FinishPage finishPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginFluentChainOfInvocationPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        header = new Header(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        finishPage = new FinishPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
