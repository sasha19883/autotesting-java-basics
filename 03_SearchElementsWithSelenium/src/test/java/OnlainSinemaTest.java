import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OnlainSinemaTest {
    static WebDriver driver;
    static long startTime;
    static long endTime;

    @BeforeClass
    public static void setUp() {
        startTime = System.nanoTime();
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Test takes " + timeElapsed/1000000000 + " seconds");
    }

    @Test
    public void testAllFieldsFilled() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys("qwert");
        driver.findElement(By.name("serials")).sendKeys("asdfg");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String actualResult1 = driver.findElement(By.id("best_films")).getText();
        String expectedResult1 = "qwert";
        String actualResult2 = driver.findElement(By.id("best_serials")).getText();
        String expectedResult2 = "asdfg";
        Assert.assertEquals("неверный фильм при проверке", expectedResult1, actualResult1);
        Assert.assertEquals("неверный сериал при проверке", expectedResult2, actualResult2);
    }

    @Test
    public void testFilmFieldFilled() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys("qwert");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        List<WebElement> elems = null;
        elems = driver.findElements(By.className("fake-checkbox"));
        elems.get(1).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String actualResult1 = driver.findElement(By.id("best_films")).getText();
        String expectedResult1 = "qwert";
        String actualResult2 = driver.findElement(By.id("best_serials")).getText();
        String expectedResult2 = "";
        String actualResult3 = driver.findElement(By.id("language")).getText();
        String expectedResult3 = "С английскими субтитрами";
        Assert.assertEquals("неверный фильм при проверке", expectedResult1, actualResult1);
        Assert.assertEquals("неверный сериал при проверке", expectedResult2, actualResult2);
        Assert.assertEquals("неверный язык при проверке", expectedResult3, actualResult3);
    }

    @Test
    public void testAllCheckboxFilled() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        List<WebElement> elems = null;
        elems = driver.findElements(By.className("fake-checkbox"));
        for (WebElement elem: elems) {
            elem.click();
        }
        List<WebElement> radioBut = null;
        radioBut = driver.findElements(By.className("fake-radiobutton"));
        radioBut.get(2).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String actualResult1 = driver.findElement(By.id("best_films")).getText();
        String expectedResult1 = "";
        String actualResult2 = driver.findElement(By.id("best_serials")).getText();
        String expectedResult2 = "";
        String actualResult3 = driver.findElement(By.id("language")).getText();
        String expectedResult3 = "С русскими субтитрами, С английскими субтитрами, В оригинале, В дубляже";
        String actualResult4 = driver.findElement(By.id("age")).getText();
        String expectedResult4 = "26-30";
        Assert.assertEquals("неверный фильм при проверке", expectedResult1, actualResult1);
        Assert.assertEquals("неверный сериал при проверке", expectedResult2, actualResult2);
        Assert.assertEquals("неверный язык при проверке", expectedResult3, actualResult3);
        Assert.assertEquals("неверный возраст при проверке", expectedResult4, actualResult4);
    }
}