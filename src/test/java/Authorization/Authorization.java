package Authorization;

import SetUp.SetUpChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Authorization extends SetUpChrome {

    public void logIn(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        buttonLogin.click();
        WebElement titleProducts = driver.findElement(By.className("product_label"));
    }

    public void logOut() {
        WebElement openMenu = driver.findElement(By.className("bm-burger-button"));
        openMenu.click();
        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
    }
}
