package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductsTest extends BasaTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isTitleisdisplayed();
        productsPage.addGoodsToCart("Sauce Labs Onesie");
        productsPage.addGoodsToCart("Sauce Labs Backpack");
        productsPage.addGoodsToCart("Test.allTheThings() T-Shirt (Red)");
        assertEquals(productsPage.checkCounterValue(), "3");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}