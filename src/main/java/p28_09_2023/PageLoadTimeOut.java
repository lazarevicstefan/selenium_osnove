package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageLoadTimeOut {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        webDriver.get("http://google.com");
        webDriver.navigate().to("http://google.com");
        webDriver.navigate().refresh();
        webDriver.findElement(By.id("submit")).click();


        webDriver.quit();
    }
}
