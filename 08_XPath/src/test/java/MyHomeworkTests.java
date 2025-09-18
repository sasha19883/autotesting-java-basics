import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    // задание 1

    //Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
    var firstLocator = By.xpath("//*[@class='da-arrows-prev']");
    //Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум классам. <a href="#" class="da-link button">Узнать больше</a>
    var secondLocator = By.xpath("//a[@href='#'][@class='da-link button']");
    //Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
    var thirdLocator = By.xpath("//li[@class='filter']");
    //Все элементы, у которых класс начинается на слова button.
    var forthLocator = By.xpath("//*[starts-with(@class,'button')]");
    //Кнопка «Подписаться сейчас».
    var fifthLocator = By.xpath("//*[text()='Подписаться сейчас']");
    //Все картинки клиентов из раздела «Наши клиенты». Для уточнения локатора используйте указание ближайшего родительского элемента с ID.
    var sixthLocator = By.xpath("//img[@class='centered']");
    //Необязательное задание. Все элементы с ценами тарифов, следующих после тарифа «Любительский».
    var seventhLocator = By.xpath("//div[@class='span4 price-column animated fadeInDown'][1]/following-sibling::*//li[@class='price']");
    //Необязательное задание. Все поля для ввода в форме «Скажите “Привет”», которые предшествуют полю «* Текст сообщения».
    var eightsLocator =  By.xpath("//*[@id='contact-form']//following-sibling::*[@class='span12']");

     //Заголовок пятого курса.
    var firstLocator = By.xpath("(//span[@class='baseCard__title'])[5]");// или "//*[text()='Алфавит для взрослых (обновлённый материал)']"
    //Элемент с учебным периодом последнего курса.
    var secondLocator =  By.xpath("(//*[@class='baseCondition'])[last()]/p");
    //Необязательное задание. Все div, которые являются непосредственными родителями для ссылок с href='#'.
    var thirdLocator = By.xpath("//*[@href]/ancestor::div");
    //Необязательное задание. Преобразуйте предыдущий локатор, чтобы он возвращал пятый элемент.
    var forthLocator = By.xpath("(//*[@href]/ancestor::div)[5]");
    //Необязательное задание. Все родительские элементы заголовка «Все курсы».
    var fifthLocator = By.xpath("//div[@class='pageCreate__title']/ancestor::*");

    //Ссылка «О магазине» в футере.
    var firstLocator = By.xpath("//a[@test-info='about-us']");
    //Заголовок «Бестселлеры».
    var secondLocator = By.xpath("//li/a[text()='Бестселлеры']");
    //Строка поиска.
    var thirdLocator = By.xpath("//*[@id='search-input']");
    //Итоговая сумма заказа в корзине.
    var forthLocator = By.xpath("//div[@id='total']");
    //Заголовок «Ваш заказ: в корзине.
    var fifthLocator = By.xpath("//*[text()='Ваш заказ: ']");
    //Кнопка «Отменить» на странице поиска.
    var sixthLocator = By.xpath("//button[@class='filter-button']");

    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}