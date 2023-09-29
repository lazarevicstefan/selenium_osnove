package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://www.youtube.com/");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement search = webDriver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Breskvica" );
        search.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[@id='video-title']"),3));
        webDriver.findElement(By.xpath("(//a[@id='video-title'])[1]")).click();
        Thread.sleep(4000);

        webDriver.quit();
    }
}
