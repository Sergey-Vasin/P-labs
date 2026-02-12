package tests;

import org.testng.annotations.Test;

import static user.UserFactory.withAdminPermission;
import static org.testng.AssertJUnit.*;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Onesie";

    @Test
    public void checkGoodsAdded() {
        System.out.println("CartTest.corrent !!!!! in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.checkTitleName(), "Products");

        productsPage.addGoodsToCart(goodsName);
        productsPage.switchToCart();

        assertEquals(cartPage.checkTitleName(), "Your Cart");
        assertEquals(cartPage.getProductsName().size(), 1);
        assertFalse(cartPage.getProductsName().isEmpty());
        assertTrue(cartPage.getProductsName().contains(goodsName));
    }
}