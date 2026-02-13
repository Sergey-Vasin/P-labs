package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductsPage extends BasaPage {

    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";
    private final By title = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By cartCounter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleisdisplayed() {
        return driver.findElement(title).isDisplayed();
    }

   /* public String getTitle() {
        return driver.findElement(title).getText();
    } */

    @Step("добавляем товары в корзину по названию")
    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("добавляем товары в корзину по индексу")
    public void addGoodsToCart(int goodsIndex) {
        driver.findElements(By.xpath(
                "//*[text()='Add to cart']")).get(goodsIndex).click();
    }

    @Step("проверяем сколько добавлено товаров в корзину")
    public String checkCounterValue() {
        return driver.findElement(cartCounter).getText();
    }

    @Step("проверяем цвет корзин, что товары добавлены")
    public String checkCounterColor() {
        return driver.findElement(cartCounter).getCssValue("background-color");
    }

    @Step("переходим в корзину")
    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}