package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPageLocators {

    public MainPageLocators(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    // Кнопка принятия куки
    private By cookieButton = By.id("rcc-confirm-button");

    // Кнопка "Заказать" сверху
    public static By orderButtonUp = By.className("Button_Button__ra12g");

    // Кнопка "Заказать" снизу
    public static By orderButtonDown = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    // Список вопросов
    public static String[] questionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    // Список ответов
    public static String[] answersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    // Блок "Вопросы о важном"
    private By questionsList = By.className("accordion");


    /* Методы для работы с локаторами главной страницы */

    // Открытие сайта
    public MainPageLocators openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    // Нажатие на кнопку принятия куки
    public MainPageLocators clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    // Нажатие на кнопку "Заказ"
    public MainPageLocators clickOrderButton(By orderButton) {
        driver.findElement(orderButton).click();
        return this;
    }

    // Прокрутка страницы до блока "Вопросы о важном"
    public MainPageLocators scrollPageToQuestionsList() {
        WebElement element = driver.findElement(questionsList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    // Нажатие на вопрос
    public MainPageLocators clickQuestion(String questionLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionLocator)));
        driver.findElement(By.id(questionLocator)).click();
        return this;
    }

    //Сравнение ожидаемого и фактического ответов
    public MainPageLocators checkAnswers(String answerLocator, String answerText){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerLocator)));

        String actualAnswerText = driver.findElement(By.id(answerLocator)).getText();
        assertEquals("Текст ответа не совпадает с ожидаемым", answerText, actualAnswerText);
        return this;
    }
}
