import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobjects.ScooterHomePage;
import pageobjects.ScooterOrderPage;

public class ScooterTestOrdering {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    // Данные для Заказа
    private final String name = "Дмитрий";
    private final String surname = "Осипов";
    private final String address = "Щёлково, Пролетарский проспект дом 3 квартира 159";
    private final String phone = "89250914255";
    private final String metroStations = "Черкизовская";
    private final String whenDate = "11.11.2022";
    private final String commentCourier = "Позвонить за час до приезда";
    private final String textExpected = "Заказ оформлен";

    @Test
    // Путь. Верхняя кнопка "Заказать" Google Chrome
    public void pressTopButtonOrdering() {
        // драйвер Google Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.clickTopButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // Путь. Нижняя кнопка "Заказать" Google Chrome
    public void pressBottomButtonOrdering() {
        // драйвер Google Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // Путь Верхняя кнопка "Заказать" FireFox
    public void pressTopButtonOrderingFireFox() {
        // драйвер Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.clickTopButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // Путь. Нижняя кнопка "Заказать" FireFox
    public void pressBottomButtonOrderingFireFox() {
        // драйвер Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
