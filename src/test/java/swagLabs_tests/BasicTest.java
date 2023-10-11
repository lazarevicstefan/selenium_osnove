package swagLabs_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import swagLabs_pages.CartPage;
import swagLabs_pages.InventoryPage;
import swagLabs_pages.LoginPage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseURL = "https://www.saucedemo.com/";
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    @BeforeClass
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver,wait);
        inventoryPage = new InventoryPage(driver,wait);
        cartPage = new CartPage(driver,wait);
    }
    @BeforeMethod
    public void logIn (){
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
        loginPage.logInWithValidCredentials();
    }
    @AfterClass
    public void exit(){
        driver.quit();
    }
}
