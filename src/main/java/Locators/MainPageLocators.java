package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageLocators {

    public MainPageLocators(WebDriver driver) {
        this.driver = driver;
    }
    private static WebDriver driver;


    // Локатор кнопки принятия куки
    private By cookieButton = By.id("rcc-confirm-button");

    // Кнопка "Заказать" сверху
    private By orderButtonUp = By.className("Button_Button__ra12g");

    // Кнопка "Заказать" снизу
    private By orderButtonDown = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    // Блок "Вопросы о важном"
    private By QuestionsList = By.className("accordion");


    /* Методы для работы с локаторами главной страницы */

    // Открытие сайта
    public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Нажатие на кнопку принятия куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // Нажатие на кнопку "Заказ" сверху страницы
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }

    // Нажатие на кнопку "Заказ" снизу страницы
    public void clickOrderButtonDown() {
        driver.findElement(orderButtonDown).click();
    }

    // Прокрутка до кнопки "Заказать" снизу
    public void scrollPageToOrderButtonDown() {
        WebElement element = driver.findElement(orderButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Прокрутка страницы до блока "Вопросы о важном"
    public void scrollPageToQuestionsList() {
        WebElement element = driver.findElement(QuestionsList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Нажатие на вопрос
    public void clickQuestion(String questionLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionLocator)));
        driver.findElement(By.id(questionLocator)).click();
    }

}
