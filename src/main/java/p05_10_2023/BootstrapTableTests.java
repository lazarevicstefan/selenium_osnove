package p05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    /*
    Kreirati klasu SwagLabsTests https://www.saucedemo.com/
    Before Method:
    Ucitava home stranicu
    Brise kolacice

    Test #1:  Verify error is displayed when username is missing
    Koraci:
    Ucitati home stranicu
    Klik na login dugme
    Verifikovati da je prikazana poruka Epic sadface: Username is required

    Test #2:  Verify error is displayed when password is missing
    Koraci:
    Ucitati home stranicu
    Uneti username
    Klik na login dugme
    Verifikovati da je prikazana poruka Epic sadface: Password is required

    Test #3:  Verify error is displayed when credentials are wrong
    Podaci:
    username: standard_user
    password: invalidpassword
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je prikazana poruka Epic sadface: Username and password do not match any user in this service

    Test #4:  Verify error is displayed when user is locked
    Podaci:
    username: locked_out_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je prikazana poruka Epic sadface: Sorry, this user has been locked out.

    Test #5:  Verify successful login
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Klik na Menu iz gornjeg lovog ugla
    Sacekati da se prikaze meni
    Verifikovati da Logout dugme postoji
    Klik na logout
    Verifikovati da je prikazana login forma

    Test #6:  Adding Products to Cart
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
    Klik na Add to cart pored proizvoda.
    Proverite da se pojavilo Remove dugme
    Proverite da li se broj proizvoda u korpi povećao na 1.

    Test #7: Viewing Product Details
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
    Klik na proizvod
    Proverite da li se prikazuju detalji proizvoda, uključujući cenu, opis i dugme za dodavanje u korpu

    Test #8: Removing Products from Cart
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
    Klik na Add to cart pored proizvoda.
    Proverite da li se broj proizvoda u korpi povećao na 1.
    Kliknuti na korpu iz navigacije
    Proverite da li se proizvod "Sauce Labs Backpack" ubacio u korpu.
    Klik na Remove dugme pored proizvoda
    Proverite da li se proizvod "Sauce Labs Backpack" izbacio iz korpe.

    Test #9: Product Checkout
    Podaci:
    username: standard_user
    password: secret_sauce
    checkout name: Pera
    checkout last name: Peric
    checkout zip: 18000
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Pronađite proizvod "Sauce Labs Backpack" na početnoj stranici.
    Klik na Add to cart pored proizvoda.
    Proverite da li se broj proizvoda u korpi povećao na 1.
    Kliknuti na korpu iz navigacije
    Klik na checkout dugme iz korpe
    Unesite podatke za checkout formu
    Klik na continue
    Proverite da li su podaci na Checkout: Overview stranici ispravni
    Klik na finish
    Validirati da se prikazuje poruka za uspesno porucivanje Thank you for your order!

    Test #10:  Validate Social Links in Footer
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Odskrolati do footera
    Validirati sve linkove iz footera da li vracaju status 200. To su linkovi linkedin, facebook i twitter

    Test #11:  Test Default Name Sort (A-Z)
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Proveriti da li su nazivi proizvoda sortirani prema abacednom redu (A-Z)

    Test #12: Test Invert Named Sort (Z-A)
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Za soritranje selektovati Name (Z to A)
    Proveriti da li su nazivi proizvoda sortirani prema abacednom redu (Z to A)

    Test #13: Test Sort Price Low High
    Podaci:
    username: standard_user
    password: secret_sauce
    Koraci:
    Ucitati home stranicu
    Uneti username i password
    Klik na login dugme
    Verifikovati da je url stranice /inventory.html
    Za soritranje selektovati Price (low to high)
    Proveriti da li su nazivi proizvoda sortirani prema ceni od najnize do najvise
    */
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseURL = "https://www.saucedemo.com/";
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseURL);
    }
    @Test(priority = 1)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing (){
        String expectedError = "Epic sadface: Username is required";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),expectedError
                ,"Expected error should be '" + expectedError + "'");
    }
    @Test(priority = 2)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        String expectedError = "Epic sadface: Password is required";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("fakeUsername");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),expectedError
                ,"Expected error should be '" + expectedError + "'");
    }
    @Test(priority = 3)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong (){
        String username = "standard_user";
        String password = "invalidpassword";
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),expectedError
                ,"Expected error should be '" + expectedError + "'");
    }
    @Test(priority = 4)
    public void verifyErrorIsDisplayedWhenUserIsLocked(){
        String username = "locked_out_user";
        String password = "secret_sauce";
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),expectedError
                ,"Expected error should be '" + expectedError + "'");
    }
    @Test(priority = 5)
    public void verifySuccessfulLogin(){
        String username = "standard_user";
        String password = "secret_sauce";


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-hidden='false']")));

        Assert.assertTrue(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("logout_sidebar_link"))).isDisplayed());
        driver.findElement(By.id("logout_sidebar_link")).click();
        Assert.assertTrue(driver.findElement(By.className("login_container")).isDisplayed());
    }
    @Test(priority = 6)
    public void AddingProductsToCart () throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";
        String product = "Sauce Labs Backpack";


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        List<WebElement> listShopElement = driver.findElements(By.cssSelector(".inventory_list > div > div:nth-child(2)"));

        for (int i = 0; i < listShopElement.size(); i++) {
            String element = listShopElement.get(i).findElement(By.cssSelector("div > a > div")).getText();
            if (element.equals(product)){
                Thread.sleep(1000);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack"))).click();
                WebElement el = driver.findElement(By.id("remove-sauce-labs-backpack"));
                System.out.println(el.getText());
                Assert.assertEquals(el.getText(),"Remove", "After product is added should be button 'Remove'");
            }
        }

        Assert.assertEquals(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("shopping_cart_badge")))
                .getText(),"1","Shopping cart should be 1" );

    }
    @Test(priority = 7)
    public void viewingProductDetails(){
        String username = "standard_user";
        String password = "secret_sauce";
        String product = "Sauce Labs Backpack";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        List<WebElement> list = driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < list.size(); i++) {
            try {
                String pro = list.get(i).getText();
                if (pro.equals(product)) {
                    list.get(i).click();
                }
            }catch (Exception e){
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc")));

        Assert.assertTrue(wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("inventory_details_desc"))).isDisplayed()
                ,"On product page there should be product details");
        Assert.assertTrue(wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("inventory_details_price"))).isDisplayed()
                ,"On product page there should be product price");
        Assert.assertTrue(wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack"))).isEnabled()
                ,"On product page there should be 'Add to cart' button");
    }
    @Test(priority = 8)
    public void removingProductsFromCart(){
        String username = "standard_user";
        String password = "secret_sauce";
        String product = "Sauce Labs Backpack";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        List<WebElement> list = driver.findElements(By.className("inventory_item_description"));
        for (int i = 0; i < list.size(); i++) {
            try {
                String pro = list.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
                if (pro.equals(product)) {
                    list.get(i).findElement(By.cssSelector(".pricebar > button")).click();
                }
            }catch (Exception e){
            }
        }
        Assert.assertEquals(wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("shopping_cart_badge")))
                .getText(),"1","Shopping cart should be 1" );
        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.className("inventory_item_name"))).isDisplayed()
                ,"In shopping cart there should be product '" + product + "'");

        driver.findElement(By.cssSelector(".item_pricebar > button")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> cart = driver
                .findElements(By.className("inventory_item_name"));
        Assert.assertEquals(cart.size(),0,"Shopping cart should be empty");

    }
    @Test(priority = 9)
    public void productCheckout (){
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";
        String product = "Sauce Labs Backpack";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        List<WebElement> list = driver.findElements(By.className("inventory_item_description"));
        for (int i = 0; i < list.size(); i++) {
            try {
                String pro = list.get(i).findElement(By.cssSelector(".inventory_item_name")).getText();
                if (pro.equals(product)) {
                    list.get(i).findElement(By.cssSelector(".pricebar > button")).click();
                }
            }catch (Exception e){
            }
        }
        Assert.assertEquals(wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("shopping_cart_badge")))
                .getText(),"1","Shopping cart should be 1" );

        driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys(checkoutName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name"))).sendKeys(checkoutLastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code"))).sendKeys(checkoutZip);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue"))).click();
        String actualProduct = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("inventory_item_name"))).getText();
        Assert.assertEquals(actualProduct,product, "There should be Details about ordered products");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))).click();

        String thankYouMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("complete-header"))).getText();
        Assert.assertEquals(thankYouMessage,"Thank you for your order!");

    }
    @Test(priority = 10)
    public void validateSocialLinksInFooter ()throws Exception {
        String username = "standard_user";
        String password = "secret_sauce";
        int expectedResponseCode = 200;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        new Actions(driver).scrollToElement(driver.findElement(By.className("footer_copy"))).perform();

        List<WebElement> socialElements = driver.findElements(By.xpath("//*[@class='social']//a"));

        for (int i = 0; i < socialElements.size(); i++) {
            String social = socialElements.get(i).getText();
            URL link = new URL(socialElements.get(i).getAttribute("href"));
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();
            try {
                Assert.assertEquals(connection.getResponseCode(), expectedResponseCode
                        , "Http response code should be 200 for '" + social + "'");
            } catch (Exception e) {
            }
            connection.disconnect();
        }
    }
    @Test(priority = 11)
    public void testDefaultNameSortA_Z(){
        String username = "standard_user";
        String password = "secret_sauce";
        String expectedSort = "Name (A to Z)";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        String actualSort = driver.findElement(By.className("active_option")).getText();
        Assert.assertEquals(actualSort,expectedSort,"Products should be sorted in format '" + expectedSort + "'");
    }
    @Test(priority = 12)
    public void testInvertNamedSortZ_A(){
        String username = "standard_user";
        String password = "secret_sauce";
        String expectedSort = "Name (Z to A)";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        new Select(driver.findElement(By.className("product_sort_container"))).selectByValue("za");

        String actualSort = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("active_option"))).getText();
        Assert.assertEquals(actualSort,expectedSort,"Products should be sorted in format '" + expectedSort + "'");
    }
    @Test(priority = 13)
    public void testSortPriceLowHigh(){
        String username = "standard_user";
        String password = "secret_sauce";
        String expectedSort = "Price (low to high)";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")
                , "Expected url shoud countain '/inventory.html'");

        new Select(driver.findElement(By.className("product_sort_container"))).selectByValue("lohi");

        String actualSort = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("active_option"))).getText();
        Assert.assertEquals(actualSort,expectedSort,"Products should be sorted in format '" + expectedSort + "'");
    }
//    @AfterMethod
//    public void afterMethod(){
//        driver.manage().deleteAllCookies();
//        ((JavascriptExecutor)driver).executeScript("windows.localStorage.clear()");
//    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
