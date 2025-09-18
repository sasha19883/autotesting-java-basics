import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    static WebDriver driver;
    By email = By.className("email");
    By button = By.id("write-to-me");
    String emailName = "test@test.ru";
    By text = By.className("result-email");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void giveKittens() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(email).sendKeys(emailName);
        driver.findElement(button).click();
        WebElement resultEmailElement = driver.findElement(text);
        Assert.assertTrue("не отобразился текст про email", driver.findElement(text).isDisplayed());
        Assert.assertEquals("неправильный текст про email", emailName, driver.findElement(text).getText());
    }

    @Test
    public void giveKittensEmptyEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(button).click();
        Assert.assertEquals("неправильный текст про email", "", driver.findElement(text).getText());
    }
}