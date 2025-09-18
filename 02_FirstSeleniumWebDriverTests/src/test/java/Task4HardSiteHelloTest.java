import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4HardSiteHelloTest {

    WebDriver driver;

    @Before
    public void methodBefore() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
    }

    @After
    public void methodAfter() {
        driver.quit();
    }

    @Test
    public void testPositive() {
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys("milo@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        buttonClick();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту (milo@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 123456789.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoName() {
        driver.findElement(By.name("email")).sendKeys("milo@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        buttonClick();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (milo@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 123456789.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoEmail() {
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        buttonClick();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 123456789.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoPhone() {
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys("milo@mail.ru");
        buttonClick();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту (milo@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNegative() {
        buttonClick();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

    private void buttonClick() {
        driver.findElement(By.className("button")).click();
    }
}