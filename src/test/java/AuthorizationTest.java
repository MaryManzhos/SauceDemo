import Authorization.Authorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AuthorizationTest extends Authorization {
    @Test
    public void successfulAuthorization(){
        logIn();
        WebElement titleProducts = driver.findElement(By.className("product_label"));
        String pageProducts = titleProducts.getText();
        assertEquals(pageProducts,"Products");
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        for (int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getText());
        }

        for (int i = 0; i < prices.size(); i++){
            System.out.println(prices.get(i).getText());
        }

        logOut();
    }
}
