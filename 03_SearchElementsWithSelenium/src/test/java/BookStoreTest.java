import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStoreTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFindElement() {
        var feedback = driver.findElement(By.linkText("Обратная связь"));
        var preOrders = driver.findElement(By.linkText("Предзаказы"));
        var bookAdd = driver.findElement(By.className("book-add"));
        var cardCount = driver.findElement(By.id("cart_count"));
        var book = driver.findElement(By.id("genres"));
        var storeSearch = driver.findElement(By.id("search-input"));
    }

    @Test
    public void testAllElements() {
        int count = driver.findElements(By.className("book-info")).size();
        Assert.assertEquals("неверно найден элемент", 15, count);
    }
}