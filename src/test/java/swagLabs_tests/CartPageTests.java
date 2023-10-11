package swagLabs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import swagLabs_retry.swagLabsRetry;

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
    @Test(priority = 3)
    public void verifyTheTitleInHead(){
        String expectedTitle = "Swag Labs";

        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getTitleInHead(),expectedTitle
                ,"Title should be '" + expectedTitle + "'");
    }
}
