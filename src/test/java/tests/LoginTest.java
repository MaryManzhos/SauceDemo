package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import static testData.TestData.*;

public class LoginTest extends BaseTest {

    @Test
    public void isSuccessfulAuthorization() {
        loginPage.openPage();
        loginPage.logIn(USERNAME_1,PASSWORD);
        assertEquals(productsPage.getNameOfPage(),"Products","Is not page Products");
    }
}
