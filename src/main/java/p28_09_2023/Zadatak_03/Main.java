package p28_09_2023.Zadatak_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("D:\\Java\\ITBootCamp\\selenium_osnove\\src\\main\\java\\p28_09_2023\\Zadatak_03\\Zadatak3.html");

        for (int i = 0; i < 5; i++) {
            webDriver.findElement(By.id("showInBtn")).click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='id-"+i+"']")));
        }
        webDriver.quit();
    }
}
