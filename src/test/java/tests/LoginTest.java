package tests;

import user.User;
import user.UserFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static user.UserFactory.withAdminPermission;
import static user.UserFactory.withLockedPermission;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(invocationCount = 1, priority = 1, enabled = true, alwaysRun = true)
    public void correctLogin() {
        System.out.println("LoginTest.corrent !!!!! in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());

        assertTrue(productsPage.isTitleisdisplayed(), "Заголовок не виден");
        assertEquals(productsPage.checkTitleName(), "Products", "не верный заголовок");
    }

    @DataProvider() //* параметризация
    public Object[][] loginData() {

        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withEmptyNamePermission(), "Epic sadface: Username is required"},
                {UserFactory.withEmptyPasswordPermission(), "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData", description = "тест проверяет заблокированного пользователя", invocationCount = 1)
    public void incorrentLogin(User user, String errorMsg) {
        System.out.println("LoginTest.incorrentLogin !!!!! in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText().trim(),
                errorMsg.trim(),
                "не верный текст сообщения об ошибки");
    }
}