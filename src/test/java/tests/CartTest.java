package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Onesie";

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.checkTitleName(), "Products");

        productsPage.addGoodsToCart(goodsName);
        productsPage.switchToCart();

        assertEquals(cartPage.checkTitleName(), "Your Cart");
        assertEquals(cartPage.getProductsName().size(), 2);
        assertFalse(cartPage.getProductsName().isEmpty());
        assertTrue(cartPage.getProductsName().contains(goodsName));
    }
}