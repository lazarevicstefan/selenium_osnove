package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class UvodUTestNG {
//    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver webDriver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        webDriver.get("http://google.com");
//
//
//        webDriver.quit();
//    }


    private WebDriver webDriver;
    private WebDriverWait wait;
    @BeforeClass
    public void setup (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        // radi se konfiguracija drivera ili stranice najcesce
    }
    @BeforeMethod
    public void beforeMethod (){
        webDriver.navigate().to("https://google.com");
        // pre svakog testa uvek!
    }
    @Test
    public void googleTitleTest() {
        String expected = "Google";
//        webDriver.navigate().to("https://google.com");
//        System.out.println("Naslov: " + webDriver.getTitle());

            Assert.assertEquals(webDriver.getTitle(),expected);
            Assert.assertEquals(webDriver.getCurrentUrl(),"https://google.com");

    }
    @Test
    public void googleSearchTest() {
//        webDriver.navigate().to("http://google.com");
        webDriver.findElement(By.name("q")).sendKeys("IT Bootcamp");
    }

    @AfterClass
    public void AfterClass (){
        webDriver.quit();
    }
}
