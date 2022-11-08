package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderPage {
    private WebDriver driver;

    // для поле Имя
    private By nameInputField = By.xpath(".//input[@placeholder='* Имя']");

    // поле Фамилия
    private By surnameInputField = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле Адрес
    private By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле Телефон
    private By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // поле Станция метро
    private By metroStationInputField = By.className("select-search__input");

    // выбор Станции метро
    private By metroStationSelect = By.className("select-search__select");

    // кнопка Далее
    private By buttonFarther = By.xpath(".//button[text()='Далее']");

    // поле Когда
    private By whenInputField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // поле Срок аренды
    private By pentalPeriodInputField = By.className("Dropdown-placeholder");

    // выбора срока аренды
    private By pentalPeriodInput = By.xpath(".//div[text()='двое суток']");

    // выбор цвета
    private By colourField = By.id("grey");

    // комментарий курьеру
    private By courierCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // кнопка заказать
    private By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // кнопка Да
    private By buttonYes = By.xpath(".//button[text()='Да']");

    // собщениее об успешном создании заказа
    private By textMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    // конструктор класса
    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // заполнение поля * Имя
    public void sendNameInput(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    // заполнение поля * Фамилия
    public void sendSurnameInput(String surname) {
        driver.findElement(surnameInputField).sendKeys(surname);
    }

    // заполнение поля * Адрес
    public void sendAddressInput(String address) {
        driver.findElement(addressInputField).sendKeys(address);
    }

    // заполнение поля * Телефон
    public void sendPhoneInput(String phone) {
        driver.findElement(phoneInputField).sendKeys(phone);
    }

    // заполнение станции метро
    public void sendMetroStationInput(String metroStations) {
        driver.findElement(metroStationInputField).click();
        driver.findElement(metroStationInputField).sendKeys(metroStations);
        driver.findElement(metroStationSelect).click();
    }

    // нажатие кнопки далее
    public void clickButtonFarther() {
        driver.findElement(buttonFarther).click();
    }

    // заполнение поля * Когда
    public void sendWhenInput(String whenDate) {
        driver.findElement(whenInputField).sendKeys(whenDate);
        driver.findElement(whenInputField).sendKeys(Keys.ENTER);
    }

    // заполнение поля * Срок аренды
    public void sendRentalPeriodSevenDaysInput() {
        driver.findElement(pentalPeriodInputField).click();
        driver.findElement(pentalPeriodInput).click();
    }

    // выбор цвета
    public void sendColourBlackInput() {
        driver.findElement(colourField).click();
    }

    // коментарий курьеру
    public void sendCourierCommentInput(String commentCourier) {
        driver.findElement(courierCommentField).sendKeys(commentCourier);
    }

    // нажатие кнопки Заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    // нажатие кнопки Да
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    // проверка появления сообщениея об успешном создании заказа
    public void waitTextAppear(String textExpected) {
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.textToBePresentInElementLocated(textMessage, textExpected));
    }

    // заполнение полей на первой странице
    public void fillingFieldsFirstPage(String name, String surname, String address, String phone, String metroStations) {
        sendNameInput(name);
        sendSurnameInput(surname);
        sendAddressInput(address);
        sendPhoneInput(phone);
        sendMetroStationInput(metroStations);
    }

    // заполнение полей на второй странице
    public void fillingFieldsSecondPage(String whenDate, String commentCourier) {
        sendWhenInput(whenDate);
        sendRentalPeriodSevenDaysInput();
        sendColourBlackInput();
        sendCourierCommentInput(commentCourier);
    }
}
