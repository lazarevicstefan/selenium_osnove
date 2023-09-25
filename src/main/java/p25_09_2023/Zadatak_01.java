package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://cms.demo.katalon.com/");
        // input[type='search']     // css Selector
//        webDriver.findElement(By.name("s")); //  //input[@name='s']     // css Selector
        webDriver.findElement(By.xpath("//input[@type='search']")).sendKeys("Flying Ninja");
//        webDriver.navigate().to("https://cms.demo.katalon.com/my-account/");
        webDriver.navigate().back();
        webDriver.navigate().forward(); // navigate have access to history
        webDriver.navigate().refresh();

        // //button[contains(@class, 'search-submit')]     //xPath with contains
        // .search-submit     // css Selecotr
        webDriver.findElement(By.xpath("//button[@class='search-submit']")).click();
        Thread.sleep(5000);

        webDriver.close();    // exit one tab
        webDriver.quit();
    }
}
