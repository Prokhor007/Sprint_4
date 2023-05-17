package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class WebDriverSettings {

    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/prokhorenkomaks/Documents/projects/chromedriver"))
                .build();
        driver = new ChromeDriver(service);

     /* FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options); */
    }

    @After
    public void tearDown() { driver.quit(); }
}
