package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageLocators {

    WebDriver driver;

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
    public void inputFirstName(String firstName) {
        driver.findElement(clientFirstName).sendKeys(firstName);
    }

    // Ввод фамилии
    public void inputLastName(String lastName) {
        driver.findElement(clientLastName).sendKeys(lastName);
    }

    // Ввод адреса доставки
    public void inputDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
    }

    // Выбор станции метро
    public void selectMetroStation(String chooseMetroStation) {
        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(chooseMetroStation);
        driver.findElement(metroStation).sendKeys(Keys.DOWN,Keys.ENTER);
    }

    // Ввод номера телефона
    public void inputPhoneNumber(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    // Нажать кнопку "Далее"
    public void  clickNextButton() {
        driver.findElement(nextButton).click();
    }
}
