package swagLabs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import swagLabs_retry.swagLabsRetry;

public class CartPageTests extends BasicTest{
    @Test(priority = 1,retryAnalyzer = swagLabsRetry.class)
    public void verifyTheUrl(){
        inventoryPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.isCartPage(), "There should be Cart page");
    }
    @Test(priority = 1,retryAnalyzer = swagLabsRetry.class)
    public void verifyTheTitlePage (){
        String expectedTitle = "Swag Labs";
        String product = "Sauce Labs Backpack";

        inventoryPage.addToCartProduct(product);
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getTitle(),expectedTitle
                ,"Title should be '" + expectedTitle + "'");
    }
    @Test(priority = 3,retryAnalyzer = swagLabsRetry.class)
    public void verifyTheTitleInHead(){
        String expectedTitle = "Swag Labs";

        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getTitleInHead(),expectedTitle
                ,"Title should be '" + expectedTitle + "'");
    }
    @Test(priority = 4,retryAnalyzer = swagLabsRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsPresented(){
        inventoryPage.clickOnCartIcon();
        cartPage.clickAndShowLeftMenu();
        Assert.assertTrue(cartPage.verifyLeftMenuIsShowing(),"Left menu should be visible");
    }
    @Test
    public void verifyIfTheCartIconIsPresented (){
        inventoryPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.isCartIconVisible(),"Cart icon should be visible");
    }
}
