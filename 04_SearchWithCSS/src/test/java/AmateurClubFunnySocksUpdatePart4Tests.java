import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmateurClubFunnySocksUpdatePart4Tests {

    private static WebDriver driver;

    @Before
    static public void setUp(){
        System.setProperty("webdriver.chrom.driver","drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    static public void tearDown(){
        driver.quit();
    }
    private By email = By.cssSelector("#email");
    private By password = By.cssSelector("#password");
    private By entrance = By.cssSelector("#submit");
    private By result = By.cssSelector("#error");

    @Test
    public void bookShopFindTheFeedbackLink(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(email).sendKeys("@");
        driver.findElement(password).sendKeys("123");
        driver.findElement(entrance).click();
        Assert.assertTrue("Данные не отобразились на странице",driver.findElement(result).isDisplayed());
        Assert.assertEquals("Данные выведены некорректно","Некорректный email или пароль",driver.findElement(result).getText());



    }
}