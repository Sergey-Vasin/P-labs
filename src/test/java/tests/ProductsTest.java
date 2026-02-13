package tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static User.UserFactory.withAdminPermission;
import static org.testng.AssertJUnit.*;

public class ProductsTest extends BaseTest {
    List<String> goodsList = new ArrayList<>(
            List.of("Sauce Labs Bike Light", "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt")
    );

    @Test
    public void checkGoodsAdded() {
        System.out.println("ProductsTest.corrent !!!!! in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.checkTitleName(), "Products");
        assertTrue(productsPage.isTitleisdisplayed());

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        /* for (int i = 0; i < goodsList.size(); i++) {
            productsPage.addGoodsToCart(goodsList.get(i));
        } */

        productsPage.addGoodsToCart(5);
        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}