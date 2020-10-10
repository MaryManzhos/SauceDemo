package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static testData.TestData.PASSWORD;
import static testData.TestData.USERNAME_1;

public class LoginTest extends BaseTest {

    @Test
    public void isSuccessfulAuthorization() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, PASSWORD);
        assertEquals(productsPage.getNameOfPage(), "Products", "Is not page Products");
    }

    @Test
    public void displayErrorMessageWhenUsernameIsEmpty() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn("", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Don't display error message");
    }

    @Test
    public void displayErrorMessageWhenPasswordIsEmpty() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Don't display error message");
    }

    @Test
    public void displayErrorMessageWhenUsernameIsNotValid() {
        loginPage.openPage();
        loginPage.isPageOpen();
        loginPage.logIn(USERNAME_1, "12345");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Don't display error message");
    }

}
