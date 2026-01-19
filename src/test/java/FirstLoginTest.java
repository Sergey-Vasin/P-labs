import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstLoginTest {

    @Test
    public void testFirstLogin() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

}
