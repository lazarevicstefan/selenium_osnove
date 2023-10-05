package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak_05 {
    public static void main(String[] args) {
        /*
        Napisati program koji:
        Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
        Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
        Ceka da se prikazu 4 item-a a upload
        Klik na upload
        Ceka da se upload zavrsi
        */

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://blueimp.github.io/jQuery-File-Upload/");


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")))
                .sendKeys(
                new File("test_data/front.jpg\n").getAbsolutePath()
                ,new File("test_data/back.jpg\n").getAbsolutePath()
                ,new File("test_data/left.jpg\n").getAbsolutePath()
                ,new File("test_data/right.jpg").getAbsolutePath()
        );

        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.cssSelector("tbody.files > tr"), 4));

        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.cssSelector("tbody.files > tr button"),4));

        webDriver.quit();
    }
}
