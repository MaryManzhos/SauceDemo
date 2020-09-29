import Authorization.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AuthorizationTest extends LogIn {
    @Test
    public void successfulAuthorization(){
        authorization();
        WebElement titleProducts = driver.findElement(By.className("product_label"));
        String pageProducts = titleProducts.getText();
        assertEquals(pageProducts,"Products");
    }
}
