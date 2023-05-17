package Test;

import Locators.MainPageLocators;
import Locators.OrderPageLocators;
import Locators.RentPageLocators;
import Utilities.WebDriverSettings;
import org.junit.Test;

public class CheckOrderTest extends WebDriverSettings {

    // Заказ через кнопку сверху
    @Test
    public void OrderByOrderButtonUp() {

        // Открытие сайта и переход на страницу заказа
        MainPageLocators objMainPage = new MainPageLocators(driver);

        objMainPage.openSite();
        objMainPage.clickCookieButton();
        objMainPage.clickOrderButtonUp();

        // Заполнение полей страницы заказа
        OrderPageLocators objOrderPage = new OrderPageLocators(driver);

        objOrderPage.inputFirstName("Иванов");
        objOrderPage.inputLastName("Иван");
        objOrderPage.inputDeliveryAddress("Москва, Ленина 1");
        objOrderPage.selectMetroStation("Сокол");
        objOrderPage.inputPhoneNumber("79999999999");
        objOrderPage.clickNextButton();

        // Заполнение полей страницы аренды
        RentPageLocators objRentPage = new RentPageLocators(driver);

        objRentPage.inputRentalDate("12.12.2023");
        objRentPage.inputRentalTime();
        objRentPage.clickCheckBoxBlackPearl();
        objRentPage.inputCommentForCourier("Тестируем страницу");
        objRentPage.clickOrderButton();
        objRentPage.clickYesButton();
        objRentPage.modalWindowOrderDisplayed();
    }

    // Заказ через кнопку снизу
    @Test
    public void OrderByOrderButtonDown() {

        // Открытие сайта и переход на страницу заказа
        MainPageLocators objMainPage = new MainPageLocators(driver);

        objMainPage.openSite();
        objMainPage.clickCookieButton();
        objMainPage.scrollPageToOrderButtonDown();
        objMainPage.clickOrderButtonDown();

        // Заполнение полей страницы заказа
        OrderPageLocators objOrderPage = new OrderPageLocators(driver);

        objOrderPage.inputFirstName("Петров");
        objOrderPage.inputLastName("Петр");
        objOrderPage.inputDeliveryAddress("Москва, Пушкина 777");
        objOrderPage.selectMetroStation("Динамо");
        objOrderPage.inputPhoneNumber("77777777777");
        objOrderPage.clickNextButton();

        // Заполнение полей страницы аренды
        RentPageLocators objRentPage = new RentPageLocators(driver);

        objRentPage.inputRentalDate("05.05.2024");
        objRentPage.inputRentalTime();
        objRentPage.clickCheckBoxGreyHopelessness();
        objRentPage.inputCommentForCourier("Снова тестируем страницу");
        objRentPage.clickOrderButton();
        objRentPage.clickYesButton();
        objRentPage.modalWindowOrderDisplayed();
    }
}