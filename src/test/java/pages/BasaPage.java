package pages;

import Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasaPage {
    public static final String DATA_TEST_PATTERN = "[data-test='%s']";
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");
    private final By title = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));


    WebDriver driver;
    WebDriverWait wait;

    public BasaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String checkTitleName() {
        return driver.findElement(title).getText();
    }

}