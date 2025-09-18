import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {
    /* В этом классе можете описать тесты для домашнего задания */
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLesson33() {
        driver.findElement(By.className("form-input")).sendKeys("xaas@mail.ru");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.name("confirm_password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        String expectedResult = "Вам на почту xaas@mail.ru выслано письмо с подтверждением";
        String actualResult = driver.findElement(By.className("form-result")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

}
