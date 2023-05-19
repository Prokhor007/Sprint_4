package Test;

import Utilities.WebDriverSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import Locators.MainPageLocators;

@RunWith(Parameterized.class)
public class CheckAnswersTextTest extends WebDriverSettings {

    private String questionLocator;
    private String answerLocator;
    private String answerText;

    public CheckAnswersTextTest(String questionLocator, String answerLocator, String answerText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

    // Ожидаемые ответы
    @Parameterized.Parameters
    public static Object[][] expectedAnswers() {
        return new Object[][]{
                {MainPageLocators.questionsArray[0], MainPageLocators.answersArray[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPageLocators.questionsArray[1], MainPageLocators.answersArray[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPageLocators.questionsArray[2], MainPageLocators.answersArray[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPageLocators.questionsArray[3], MainPageLocators.answersArray[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPageLocators.questionsArray[4], MainPageLocators.answersArray[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPageLocators.questionsArray[5], MainPageLocators.answersArray[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPageLocators.questionsArray[6], MainPageLocators.answersArray[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPageLocators.questionsArray[7], MainPageLocators.answersArray[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkAnswersText() {

        new MainPageLocators(driver)
                .openSite()
                .clickCookieButton()
                .scrollPageToQuestionsList()
                .clickQuestion(questionLocator)
                .checkAnswers(answerLocator, answerText);
    }
}