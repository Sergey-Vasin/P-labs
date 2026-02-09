import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasaTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized"); // максимальные размер окна
        //   options.addArguments("headless"); // без открытие браузерв

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}
