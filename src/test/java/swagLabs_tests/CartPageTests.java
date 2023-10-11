package swagLabs_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends BasicTest{
    @Test
    public void verifyTheUrl(){
        inventoryPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.isCartPage(), "There should be Cart page");
    }
    @Test
    public void verifyTheTitlePage (){
        String expectedTitle = "Swag Labs";
        String product = "Sauce Labs Backpack";
        inventoryPage.addToCartProduct(product);
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getTitle(),expectedTitle
                ,"Title should be '" + expectedTitle + "'");
    }

}
