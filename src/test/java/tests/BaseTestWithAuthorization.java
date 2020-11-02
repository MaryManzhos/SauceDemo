package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static testData.TestData.PASSWORD;
import static testData.TestData.USERNAME_1;

public class BaseTestWithAuthorization extends BaseTest {

    @BeforeClass
    public void authorization() {
        loginSteps.authorization(USERNAME_1, PASSWORD);
    }

    @AfterMethod
    public void goToProductPage() {
        cartSteps.clearCart();
        headerSteps.goToProductsPage();
    }
}
