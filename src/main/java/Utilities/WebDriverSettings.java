package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSettings {

    public WebDriver driver;

    @Before
    public void setUp() {
        /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*, --no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options); */

            FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
    }

    @After
    public void tearDown() {
            driver.quit();
        }
}