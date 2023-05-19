package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageLocators {

    private WebDriver driver;

    // Поле ввода "Имя"
    private By clientFirstName = By.xpath(".//input[@placeholder='* Имя']");

    // Поле ввода "Фамилия"
    private By clientLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес: куда привезти заказ"
    private By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле "Станция метро"
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // Поле "Телефон: на него позвонит курьер"
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    // Конструктор класса
    public OrderPageLocators(WebDriver driver) {
        this.driver = driver;
    }


    /* Методы для работы с элементами страницы заказа */

    // Ввод имени
    public OrderPageLocators inputFirstName(String firstName) {
        driver.findElement(clientFirstName).sendKeys(firstName);
        return this;
    }

    // Ввод фамилии
    public OrderPageLocators inputLastName(String lastName) {
        driver.findElement(clientLastName).sendKeys(lastName);
        return this;
    }

    // Ввод адреса доставки
    public OrderPageLocators inputDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
        return this;
    }

    // Выбор станции метро
    public OrderPageLocators selectMetroStation(String chooseMetroStation) {
        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(chooseMetroStation);
        driver.findElement(metroStation).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    // Ввод номера телефона
    public OrderPageLocators inputPhoneNumber(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
        return this;
    }

    // Нажать кнопку "Далее"
    public OrderPageLocators  clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }
}
