import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

/**
 * Created by hazel on 13.11.2016.
 */
public class MainTest {

    private static WebDriver driver = null;
    private static String baseUrl = null;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hazel\\Desktop\\N11Test\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.n11.com";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        HomePage.closeNotification(driver).click();
    }

    @Test
    public void mainTest() throws Exception {
        HomePage.clickLogin(driver).click();
        LoginPage.clickFbLogin(driver).click();
        LoginPage.testFbAuthorization(driver);
        driver.get(baseUrl);
        BookPage.chooseBookCategorize(driver);
        assertTrue(isElementPresent(By.cssSelector("a[title=\"Kitap\"] > span")));
        WritersPage.clickWriters(driver);
        assertTrue(isElementPresent(By.cssSelector("a[title=\"Yazarlar\"] > span")));

        //Testing letter size
        List<WebElement> letters = new ArrayList<>();
        for (int i = 1; i<=32; i++){
            letters.add(driver.findElement(By.xpath("//div[@id='brandsPaging']/div/span[" + i +"]")));
        }
        assertEquals(32, letters.size());

        //Testing all writers with first characters
        WritersPage.writersStartsWithControl(driver, 'A', 2);
        WritersPage.writersStartsWithControl(driver, 'B', 3);
        WritersPage.writersStartsWithControl(driver, 'C', 4);
        WritersPage.writersStartsWithControl(driver, 'Ç', 5);
        WritersPage.writersStartsWithControl(driver, 'D', 6);
        WritersPage.writersStartsWithControl(driver, 'E', 7);
        WritersPage.writersStartsWithControl(driver, 'F', 8);
        WritersPage.writersStartsWithControl(driver, 'G', 9);
        WritersPage.writersStartsWithControl(driver, 'H', 10);
        WritersPage.writersStartsWithControl(driver, 'I', 11);
        WritersPage.writersStartsWithControl(driver, 'İ', 12);
        WritersPage.writersStartsWithControl(driver, 'J', 13);
        WritersPage.writersStartsWithControl(driver, 'K', 14);
        WritersPage.writersStartsWithControl(driver, 'L', 15);
        WritersPage.writersStartsWithControl(driver, 'M', 16);
        WritersPage.writersStartsWithControl(driver, 'N', 17);
        WritersPage.writersStartsWithControl(driver, 'O', 18);
        WritersPage.writersStartsWithControl(driver, 'Ö', 19);
        WritersPage.writersStartsWithControl(driver, 'P', 20);
        WritersPage.writersStartsWithControl(driver, 'Q', 21);
        WritersPage.writersStartsWithControl(driver, 'R', 22);
        WritersPage.writersStartsWithControl(driver, 'S', 23);
        WritersPage.writersStartsWithControl(driver, 'Ş', 24);
        WritersPage.writersStartsWithControl(driver, 'T', 25);
        WritersPage.writersStartsWithControl(driver, 'U', 26);
        WritersPage.writersStartsWithControl(driver, 'Ü', 27);
        WritersPage.writersStartsWithControl(driver, 'V', 28);
        WritersPage.writersStartsWithControl(driver, 'W', 29);
        WritersPage.writersStartsWithControl(driver, 'X', 30);
        WritersPage.writersStartsWithControl(driver, 'Y', 31);
        WritersPage.writersStartsWithControl(driver, 'Z', 32);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
