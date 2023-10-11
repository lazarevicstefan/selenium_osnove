package saurcedemo_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import saurcedemo_pages.InventoryPage;
import saurcedemo_pages.LeftNavPage;
import saurcedemo_pages.LoginPage;
import saurcedemo_pages.TopNavPage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.saucedemo.com/";
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected TopNavPage topNavPage;
    protected LeftNavPage leftNavPage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver,wait);
        inventoryPage = new InventoryPage(driver,wait);
        topNavPage = new TopNavPage(driver,wait);
        leftNavPage = new LeftNavPage(driver,wait);
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to(baseUrl);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
