import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hazel on 13.11.2016.
 */
public class HomePage {

    private static WebElement element;

    public static WebElement closeNotification(WebDriver driver) throws Exception{
        Thread.sleep(5000);
        element = driver.findElement(By.className("sgm-notification-close"));
        return element;
    }

    public static WebElement clickLogin(WebDriver driver) throws Exception{
        element = driver.findElement(By.linkText("Giriş Yap"));
        return element;
    }
}
