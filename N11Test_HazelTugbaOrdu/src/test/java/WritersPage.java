import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import java.util.List;

/**
 * Created by hazel on 13.11.2016.
 */
public class WritersPage {

    private static WebElement element;

    public static void clickWriters(WebDriver driver) throws Exception{
        driver.findElement(By.linkText("Yazarlar")).click();
    }

    public static void writersStartsWithControl(WebDriver driver, char letter, int i) throws Exception{

        driver.findElement(By.xpath("//div[@id='brandsPaging']/div/span[" + i + "]")).click();
        int countDiv = driver.findElements(By.xpath("//div[@id='authorsList']/child::div")).size();
        String lastWriter;
        int totalStartsWithSize = 0,totalWritersSize = 0;
        for (int j = 1; j <= countDiv; j++) {
            int countPath = driver.findElements(By.xpath("//div[@id='authorsList']/div[" + j + "]/descendant::li")).size();
            totalWritersSize += countPath;
            List<WebElement> list = driver.findElements(By.xpath("//div[@id='authorsList']/div[" + j + "]/descendant::a[starts-with(text(),'" + letter + "')]"));
            int startsWithSize = list.size();
            totalStartsWithSize += startsWithSize;
            if (j == countDiv) {
                lastWriter = driver.findElement(By.xpath("//div[@id='authorsList']/div[" + countDiv + "]/descendant::a[" + countPath + "]")).getText();
                WebElement xpath = driver.findElement(By.xpath("//a[@href = '//www.n11.com/yazarlar/" + letter + "?pg=2']"));
                if(xpath.isEnabled()) {
                    xpath.click();
                    String firstWriter = driver.findElement(By.xpath("//div[@id='authorsList']/div[1]/descendant::li[1]/a")).getText();
                    assertNotSame(lastWriter, firstWriter);
                }
                else continue;
            }
        }
        assertEquals(totalWritersSize, totalStartsWithSize);
        assertEquals(80, totalWritersSize);
    }

}

