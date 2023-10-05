package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonLoginTests {
    /*
    Kreirati klasu KatalonLoginTests za testove
    Base url: https://cms.demo.katalon.com
    Test #1: Visit login page from Nav bar
    Koraci:
    Ucitati home stranicu
    Kliknuti na My account link
    Verifikovati da je naslov stranice My account – Katalon Shop
    Verifikovati da se u url-u stranice javlja /my-account
    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
    */
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseURL = "https://cms.demo.katalon.com/";

    @BeforeClass
    public void setup(){
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
    @Test (priority = 1)
    public void visitLoginPageFromNavBar (){
        String expectedTitle = "My account – Katalon Shop";
        String expectedContainUrl = "/my-account";

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#primary-menu > ul > li:nth-child(3) > a"))).click();

        Assert.assertEquals(driver.getTitle(),expectedTitle
                ,"On my account page title should be '" + expectedTitle + "'");

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedContainUrl)
                ,"On my account page url should contains '" + expectedContainUrl + "'");
    }
    @Test(priority = 2)
    public void checkInputTypes (){
        String expectedEmail = "text";
        String expectedPass = "password";
        String expectedCheckBox = "checkbox";

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#primary-menu > ul > li:nth-child(3) > a"))).click();

        Assert.assertEquals(driver.findElement(By.id("username"))
                .getAttribute("type"),expectedEmail
                , "On my account page, input email attribute type should contains be '" + expectedEmail + "'");

        Assert.assertEquals(driver.findElement(By.id("password"))
                .getAttribute("type"),expectedPass
                , "On my account page, input password attribute type should contains be '" + expectedPass + "'");

        Assert.assertEquals(driver.findElement(By.id("rememberme"))
                .getAttribute("type"),expectedCheckBox
                , "On my account page, check box attribute type should contains be '" + expectedCheckBox + "'");

        Assert.assertFalse(driver.findElement(By.id("rememberme"))
                .isSelected()
                ,"On my account page, check box is selected");
    }
    @Test(priority = 3)
    public void displayErrorWhenCredentialsAreWrong(){
        String email = "invalidemail@gmail.com";
        String password = "invalid123";
        String errorFullMessage = "ERROR: Invalid email address. Lost your password?";
        String expectedContainUrl = "/my-account";

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#primary-menu > ul > li:nth-child(3) > a"))).click();

        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//ul[@role='alert']/li/strong")));

        Assert.assertEquals(driver.findElement(By.xpath("//ul[@role='alert']/li")).getText(),errorFullMessage,
                "On my account page, error message should be '" + errorFullMessage + "'");

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedContainUrl),
                "On my account page url should contains '" + expectedContainUrl + "'");
    }
    @Test(priority = 4)
    public void successfulLoginWithValidVredentials(){
        String username = "customer";
        String password = "crz7mrb.KNG3yxv1fbn";
        String expectedLogoutText = "Log out";

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#primary-menu > ul > li:nth-child(3) > a"))).click();

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='login']")).click();

        String actualLogoutMessage = driver
                .findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]/a")).getText();

        Assert.assertEquals(actualLogoutMessage,expectedLogoutText
                ,"On my account page, when successful login should be a Log out button with message '" + expectedLogoutText + "'");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
