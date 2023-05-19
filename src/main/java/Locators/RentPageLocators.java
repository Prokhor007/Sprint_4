package Locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;


public class RentPageLocators {

    WebDriver driver;

    // Поле "Когда привезти самокат" с календарем
    private By rentalDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Поле "Срок аренды"
    private By rentalPeriod = By.className("Dropdown-placeholder");

    // Список срока аренды
    private By rentalTime = By.xpath(".//*[(@role ='option' and text()='пятеро суток')]");

    // Цвет самоката "Черный жемчуг"
    private By checkBoxBlackPearl = By.xpath(".//input[@id='black']");

    // Цвет самоката "Серая безысходность"
    private By checkBoxGreyHopelessness = By.xpath(".//input[@id='grey']");

    // Поле "Комментария для курьера"
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    // Кнопка "Да" в поп-апе "Хотите оформить заказ?"
    private By yesButton = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    // Поп-ап "Заказ оформлен"
    private By modalWindowOrder = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");


    // Конструктор класса
    public RentPageLocators(WebDriver driver) {
        this.driver = driver;
    }


    /* Методы для работы с элементами страницы аренды */

    // Ожидание загрузки страницы и ввод даты доставки
    public RentPageLocators inputRentalDate(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentalDate));
        driver.findElement(rentalDate).sendKeys(date);
        driver.findElement(rentalDate).sendKeys(Keys.ENTER);
        return this;
    }

    // Выбор срока аренды
    public RentPageLocators inputRentalTime() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalTime).click();
        return this;
    }

    // Выбор цвета самоката "Черный жемчуг"
    public RentPageLocators clickCheckBoxBlackPearl() {
        driver.findElement(checkBoxBlackPearl).click();
        return this;
    }

    // Выбор цвета самоката "Серая безысходность"
    public RentPageLocators clickCheckBoxGreyHopelessness() {
        driver.findElement(checkBoxGreyHopelessness).click();
        return this;
    }

    // Ввод комментария для курьера
    public RentPageLocators inputCommentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
        return this;
    }

    // Нажатие кнопки "Заказать"
    public RentPageLocators clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    // Нажатие кнопки "Да" в поп-апе "Хотите оформить заказ?"
    public RentPageLocators clickYesButton() {
        driver.findElement(yesButton).click();
        return this;
    }

    // Поп-ап "Заказ оформлен" появился
    public RentPageLocators modalWindowOrderDisplayed() {
        String ModalWindowOrderDisplayed = driver.findElement(modalWindowOrder).getText();
        Assert.assertThat(ModalWindowOrderDisplayed, containsString("Заказ оформлен"));
        return this;
    }
}
