import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTagAtribTests {
    private static WebDriver driver;
    @Before
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public static void tearDown()
    {
        driver.quit();
    }
    @Test
    public void searchTagAttribTest1()
    {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        var locator11 = driver.findElement(By.cssSelector("a[test-info='about-us']")); //Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>. Осуществите поиск только по атрибуту test-info, равному about-us.
        var locator12 = driver.findElements(By.cssSelector("a[href='']")); //Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
        var locator14 = driver.findElements(By.cssSelector("div.book-price"));//Локатор на главной странице для элемента <div class="book-price">. Осуществите поиск одновременно по тегу и классу, равному book-price.
        var locator15 = driver.findElements(By.cssSelector("button[class^='book']")); //Локатор на главной странице  для всех элементов с тегом button и с атрибутом class, начинающимся на book.
        var locator16 = driver.findElements(By.cssSelector("[class$='main']")); //Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.
        var locator17 = driver.findElements(By.cssSelector("a[class*='menu']")); // Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
        var locator21 = driver.findElements(By.cssSelector("#footer > div"));// На главной странице найдите все теги div, которые являются дочерними элементами первого уровня у элемента <footer id="footer">.
        var locator22 = driver.findElement(By.cssSelector("li#genres + *")); //На главной странице найдите любой тег, который расположен сразу после <li id="genres">.
        Assert.assertEquals("О магазине", locator11.getText());
        Assert.assertEquals(3, locator12.size());
        Assert.assertEquals(15,locator14.size());
        Assert.assertEquals(15,locator15.size());
        Assert.assertEquals(1,locator16.size());
        Assert.assertEquals(8,locator17.size());
        Assert.assertEquals(3,locator21.size());
        Assert.assertEquals("Новинки", locator22.getText());
    }
    @Test
    public void searchTagAttribTest2()
    {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        var locator13 = driver.findElements(By.cssSelector("option[selected]"));  //Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
        var locator23 = driver.findElements(By.cssSelector("div.filter-container ~ *")); // На странице поиска найдите любые теги, которые расположены после <div class="filter-container"> (необязательно ближайший сосед).
        Assert.assertEquals(2, locator13.size());
        Assert.assertEquals(3, locator23.size());
    }
    @Test
    public void searchTagAttribTest3()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        var locator31 = driver.findElement(By.cssSelector("section.important-section-block[for='main-header-page'] > h1:first-child")); //Первый тег h1, находящийся сразу на первом уровне вложенности внутри <section class="important-section-block" for="main-header-page">. Используйте поиск по первому child.
        var locator32 = driver.findElement(By.cssSelector("form#login-form.form > p:last-child"));//Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">. Используйте поиск по child.
        var locator33 = driver.findElement(By.cssSelector("body > *:nth-child(3)")); // Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
        var locator34 = driver.findElement(By.cssSelector("div.footer__menuList > a:nth-of-type(1)"));  //Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">. Используйте поиск по type.
        var locator35 = driver.findElement(By.cssSelector("div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)")); // По желанию: найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у своего родителя <div class="footer__menuList">, при этом <div class="footer__menuList"> является первым дочерним элементом у своего родителя <div class="footer__menu">. Составленный поиск должен вернуть ровно один найденный элемент.
        Assert.assertEquals("КЛУБ ЛЮБИТЕЛЕЙ", locator31.getText());
        Assert.assertEquals("Войти", locator32.getText());
        Assert.assertEquals("footer", locator33.getTagName());
        Assert.assertEquals("a", locator34.getTagName());
        Assert.assertEquals("С \"ног\"", locator35.getText());
    }
}