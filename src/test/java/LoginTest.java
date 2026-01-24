import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BasaTest {

    @Test
    public void testFirstLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //ввести текст
        driver.findElement(By.id("user-name")).sendKeys(Keys.CONTROL + "A"); //выделить текст
        driver.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE); //удалить текст
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //ввести текст
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        boolean titleisdisplayed = driver.findElement(By.cssSelector("[class='title']")).isDisplayed();
        assertTrue(titleisdisplayed, "Заголовок не виден");

        String titleName = driver.findElement(By.cssSelector("[class='title']")).getText();
        assertEquals(titleName, "Products", "не верный заголовок");
    }

    @Test
    public void incorrentLogin() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user"); //ввести текст
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        boolean errorisdisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        assertTrue(errorisdisplayed, "Нет сообщения об ошибке");

        String errorMsg = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out",
                "не верный текст сообщения об ошибки");
    }
}
