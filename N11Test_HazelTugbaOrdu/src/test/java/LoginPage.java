import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;

/**
 * Created by hazel on 13.11.2016.
 */
public class LoginPage {

    private static WebElement element;
    private static Set<String> handles;

    public static WebElement clickFbLogin(WebDriver driver) throws Exception{
        element = driver.findElement(By.cssSelector(".button.facebook"));
        return element;
    }

    public static void testFbAuthorization(WebDriver driver) throws Exception {

        handles = driver.getWindowHandles();
        driver.switchTo().window((String) handles.toArray()[1]); //switches to pop-up window

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("n11test.hazeltugbaordu@gmail.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("n11test11");
        driver.findElement(By.id("u_0_2")).click();

        driver.switchTo().window((String) handles.toArray()[0]); //switches to main window

    }
}
