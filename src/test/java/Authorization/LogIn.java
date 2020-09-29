package Authorization;

import SetUp.SetUpChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LogIn extends SetUpChrome {

    public void authorization(){
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        buttonLogin.click();
        WebElement titleProducts = driver.findElement(By.className("product_label"));
    }
}
