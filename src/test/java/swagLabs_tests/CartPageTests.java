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
    @Test
    public void verifyIfTheHamburgerMenuButtonIsEnabled(){
        inventoryPage.clickOnCartIcon();
        cartPage.clickAndShowLeftMenu();
        Assert.assertTrue(cartPage.verifyLeftMenuButtonIsEnable(),"Left menu Button should be enabled");
    }
    @Test
    public void verifyIfTheCartIconIsEnabled(){
        inventoryPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.verifyCartIconIsEnable(),"Cart icon should be enabled");
    }
    @Test
    public void verifyIfTheHamburgerButtonIsWorking(){
        inventoryPage.clickOnCartIcon();
        cartPage.clickAndShowLeftMenu();
        Assert.assertTrue(cartPage.verifyLeftMenuIsShowing(),"Left menu should be visible");
    }
    @Test
    public void verifyIfTheCartIconIsWorking(){
        inventoryPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.verifyCartIconIsEnable(),"Cart icon should be visible");
    }
    @Test
    public void verifyIfTheCartIconHasCorrectNumberOfAddedItems() {
        String expected = "1";
        String product = "Sauce Labs Backpack";

        inventoryPage.addToCartProduct(product);

        Assert.assertEquals(inventoryPage.getCartNumber(),expected
                ,"On Cart there should be two products");
    }

}
