import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void task1() {
        //    1a
        By element1 = By.cssSelector("p");
//    1b
        By element2 = By.cssSelector("[class*='text'] > a");
//    1c
        By element3 = By.cssSelector("div.text:nth-of-type(2) > a[href='#']");
    }

    @Test
    public void task2() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
//    2 Найдите тег input, у которого нет атрибута id.
        driver.findElement(By.cssSelector("input:not([id])"));
//    2 Найдите все теги p, у которых одновременно выполняются два условия:
//          class начинается на слово form;
//          class НЕ заканчивается на слово error.
        driver.findElements(By.cssSelector("p[class^='form']:not(error)"));
//    2 Найдите <div class="form-inner">, у него найдите первый по счёту элемент такого типа: <p class="form-row">.
        driver.findElements(By.cssSelector("div.form-inner > .form > p.form-row:nth-of-type(1)"));
    }

    @Test
    public void task3() throws InterruptedException {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
//        driver.manage().window().maximize();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.articlePreview__link")));
        driver.findElement(By.cssSelector(".articlePreview__link")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".pageArticle__sidebar.page__sidebar")));
        String val = driver.findElement(By.cssSelector(".baseInput__field")).getAttribute("value");
        String val2 = driver.findElement(By.cssSelector(".vb-content > .articlePreview.pageArticle__articlePreview:first-child " +
                "> .articlePreview__content > .articlePreview__title")).getText();
        Assert.assertEquals("Заголовки не одинаковы", val, val2);
        String val3 = driver.findElement(By.cssSelector(".baseTextarea__text")).getAttribute("value");
        String val4 = driver.findElement(By.cssSelector(".vb-content > .articlePreview.pageArticle__articlePreview:first-child " +
                "> .articlePreview__content > .articlePreview__text")).getText();
        Assert.assertEquals("Содержание не одинаково", val3, val4);
        driver.findElement(By.cssSelector("div.pageArticle__buttons > button.pageArticle__button:last-child " +
                "> svg.pageArticle__icon")).click();
        driver.findElement(By.cssSelector(".articlePreview__link")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.pageArticle__buttons > button.pageArticle__button:last-child " +
                "> svg.pageArticle__icon")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".articlePreview__link")));
        Assert.assertTrue("Не исчез список справа",
                driver.findElements(By.cssSelector(".articlePreview__link")).size()==0);
    }
}