package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class BasaTest {
    public WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // максимальные размер окна
        options.addArguments("--guest");
        // options.addArguments("--window-size=1920,1080");
        //   options.addArguments("headless"); // без открытие браузерв
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        // driver.quit();
    }
}