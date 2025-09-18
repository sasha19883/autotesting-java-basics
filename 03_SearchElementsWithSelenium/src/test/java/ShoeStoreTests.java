import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoeStoreTests {
    private static WebDriver driver;

    @BeforeClass
    static public void setUp(){
        System.setProperty("webdriver.chrom.driver","drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    static public void tearDown(){
        driver.quit();
    }


    @Test
    public void shoeStorePositiveScenario(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("38");
        driver.findElement(By.tagName("button")).click();
        String resalt = driver.findElement(By.id("size-success")).getText();
        Assert.assertEquals("Неверный текст при положительном результате поиска","В нашем магазине есть обувь вашего размера",resalt);

    }

    @Test
    public void shoeStoreNegativeScenario(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        String resalt = driver.findElement(By.className("subtitle")).getText();
        Assert.assertEquals("Неверный текст в поле сайта","В нашем магазине есть обувь c 34 по 44 размер",resalt);

    }

}