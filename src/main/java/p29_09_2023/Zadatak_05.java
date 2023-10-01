package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_05 {
    public static void main(String[] args) {
        /*
        Napisati program koji:
        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/
        Vrsi klik na Basic example link iz desne navigacije
        Ceka da url sadrzi #section-basic-example
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://mdbootstrap.com/docs/standard/components/toasts/");
        webDriver.findElement(By.xpath("//*[@id=\"scrollspy\"]/ul/li[2]/a")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("#section-basic-example"));
        webDriver.quit();
    }
}
