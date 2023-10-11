package saurcedemo_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saurcedemo_retry.saurcedemoRetry;

public class SwagLabsTests extends BasicTest{
    @Test(priority = 1,retryAnalyzer = saurcedemoRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing (){
        String expectedErrorMessage = "Epic sadface: Username is required";

        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage
                ,"There should be error message");
    }
    @Test(priority = 2,retryAnalyzer = saurcedemoRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        String username = "standard_user";
        String expectedErrorMessage = "Epic sadface: Password is required";

        loginPage.clearAndEnterUsername(username);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage
                ,"There should be error message");
    }
    @Test(priority = 3,retryAnalyzer = saurcedemoRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong(){
        String username = "standard_user";
        String password = "invalidpassword";
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        loginPage.clearAndEnterUsername(username);
        loginPage.clearAndEnterPassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage
                ,"There should be error message");
    }
    @Test(priority = 4,retryAnalyzer = saurcedemoRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked(){
        String username = "locked_out_user";
        String password = "secret_sauce";
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

        loginPage.clearAndEnterUsername(username);
        loginPage.clearAndEnterPassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage
                ,"There should be error message");
    }
    @Test(priority = 5,retryAnalyzer = saurcedemoRetry.class)
    public void verifySuccessfulLogin(){
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndEnterUsername(username);
        loginPage.clearAndEnterPassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertTrue(inventoryPage.isInventoryPage()
                ,"There should be opened Inventory Page");
        topNavPage.clickAndShowLeftMenu();
        Assert.assertTrue(leftNavPage.isLeftNavShowing());

        Assert.assertTrue(leftNavPage.isLogOutButtonExist());
        leftNavPage.clickOnLogOutButton();

        Assert.assertTrue(loginPage.isLoginPageShowing());
    }




    @Test(priority = 6)
    public void addingProductsToCart() throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";
        String product = "Sauce Labs Backpack";

        loginPage.clearAndEnterUsername(username);
        loginPage.clearAndEnterPassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertTrue(inventoryPage.isInventoryPage()
                , "There should be opened Inventory Page");

        inventoryPage.addToCartProduct(product);
        Thread.sleep(5000);

    }
}
