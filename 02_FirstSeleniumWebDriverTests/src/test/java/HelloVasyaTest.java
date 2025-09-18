
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloVasyaTest {
    WebDriver driver;

    @Before
    public void methodBefore() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
    }

    @After
    public void methodAfter() {
        driver.quit();
    }

    @Test
    public void testHelloVasya() {

        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Привет, Вася!";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHello() {
        driver.findElement(By.className("button")).click();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);
    }
}
