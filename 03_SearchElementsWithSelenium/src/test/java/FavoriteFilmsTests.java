import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class FavoriteFilmsTests {
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
    public void cinemaOnlineTestOne(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys("Человек дождя");
        driver.findElement(By.name("serials")).sendKeys("Доктор Хаус");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String bestFilm = driver.findElement(By.id("best_films")).getText();
        Assert.assertEquals("Неверное название фильма","Человек дождя",bestFilm);
        String bestSerial = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("Неверное название сериала","Доктор Хаус",bestSerial);


    }

    @Test
    public void cinemaOnlineTestTwo(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.className("fake-checkbox")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String var = driver.findElement(By.id("language")).getText();
        Assert.assertEquals("Неверный язык","С русскими субтитрами",var);



    }

    @Test
    public void cinemaOnlineTestThree(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.className("fake-radiobutton")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        String var = driver.findElement(By.id("age")).getText();
        Assert.assertEquals("Неверный возраст","10-17",var);



    }



}