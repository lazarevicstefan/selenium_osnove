package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUTrazenje {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        webDriver.get("https://cms.demo.katalon.com/");

        // //div[@id='primary-menu']/ul/li[1]/a
        // #primary-menu > ul > li:nth-child(1) > a

//        WebElement cartLink = webDriver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[1]/a"));  // xPath
//        WebElement cartLink = webDriver.findElement(By.cssSelector("#primary-menu > ul > li:nth-child(1) > a"));   // css Selector
//        cartLink.click();
        webDriver.findElement(By.cssSelector("#primary-menu > ul > li:nth-child(3) > a"))
                        .click();


        webDriver.findElement(By.cssSelector("#username")).sendKeys("Username");


        Thread.sleep(5000);
        webDriver.quit();
    }
}
