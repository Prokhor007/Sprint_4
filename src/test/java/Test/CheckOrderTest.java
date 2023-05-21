package Test;

import Locators.MainPageLocators;
import Locators.OrderPageLocators;
import Locators.RentPageLocators;
import Utilities.WebDriverSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class CheckOrderTest extends WebDriverSettings {
    private By orderButton;

    public CheckOrderTest(By orderButton) {
        this.orderButton = orderButton;
    }
    // Тестовые данные
    @Parameterized.Parameters
    public static  Object[][] getOrderButton() {
        return new Object[][]{
                new By[]{MainPageLocators.orderButtonUp},
                new By[]{MainPageLocators.orderButtonDown}};
    }

    @Test
    public void orderTest() {

        // Открытие сайта и переход на страницу заказа
        new MainPageLocators(driver)
            .openSite()
            .clickCookieButton()
            .clickOrderButton(orderButton);

        // Заполнение полей страницы заказа
        new OrderPageLocators(driver)
                .inputFirstName("Иванов")
                .inputLastName("Иван")
                .inputDeliveryAddress("Москва, Ленина 1")
                .selectMetroStation("Сокол")
                .inputPhoneNumber("79999999999")
                .clickNextButton();

        // Заполнение полей страницы аренды
        new RentPageLocators(driver)
                .inputRentalDate("12.12.2023")
                .inputRentalTime()
                .clickCheckBoxBlackPearl()
                .inputCommentForCourier("Тестируем страницу")
                .clickOrderButton()
                .clickYesButton()
                .modalWindowOrderDisplayed();
    }
}