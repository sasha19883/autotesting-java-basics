import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmateurClubFunnySocksUpdatePart3Tests {

   private static WebDriver driver;
    By emailLocator = By.id("email");
    By passLocator = By.name("password");
    By buttonLocator = By.tagName("button");
    By errorLocator = By.className("form-error-password-email");
    String email = "@";
    String pass = "123";

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
    public void loginInSite() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passLocator).sendKeys(pass);
        driver.findElement(buttonLocator).click();
        WebElement error = driver.findElement(errorLocator);
        String actualRes = error.getText();
        String expectedRes = "Некорректный email или пароль";
        Assert.assertTrue("Не отобразилось сообщение об ошибке", error.isDisplayed());
        Assert.assertEquals("Не верный результат сравнения", expectedRes,actualRes);
    }
}