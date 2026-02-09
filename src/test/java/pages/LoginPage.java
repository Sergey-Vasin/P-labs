package pages;

import User.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasaPage {
    private final By loginInput = By.id("user-name");
    private final By passwordInput = By.cssSelector(DATA_TEST_PATTERN.formatted("password"));
    private final By loginButton = By.cssSelector("[name='login-button']");
    private static final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(User user) {
        fillLoginField(user.getEmail());
        fillPasswordfield(user.getPassword());
        driver.findElement(loginButton).click();
    }

    public void fillLoginField(String user) {
        driver.findElement(loginInput).sendKeys(user);
    }

    public void fillPasswordfield(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(errorMsg).getText();
    }
}