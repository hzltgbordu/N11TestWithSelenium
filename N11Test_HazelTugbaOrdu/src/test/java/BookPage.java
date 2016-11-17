import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

/**
 * Created by hazel on 13.11.2016.
 */
public class BookPage {

    private static WebElement element;

    public static void chooseBookCategorize(WebDriver driver) throws Exception{
        driver.findElement(By.id("allCatBtn")).click();
        driver.findElement(By.cssSelector("li.catMenuItem.active > a[title=\"Kitap, Müzik, Film, Oyun\"]")).click();
        driver.findElement(By.cssSelector("li.mainCat.active > a[title=\"Kitap\"]")).click();
    }
}
