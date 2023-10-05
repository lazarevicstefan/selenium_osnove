package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji:
        Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
        Uploadujte sliku
        Ceka se da se pojavi slika u listi uploadovanih fajlova
        Koristite uslov da broj elemenata bude 1.
        Klik na Start dugme u okviru item-a koji se uploadovao
        Ceka se da se pojavi delete dugme pored itema
        Klik na delete dugme pored itema
        Ceka se da se element obrise
        Koristite da broj elemenata bude 0
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        webDriver.get("https://blueimp.github.io/jQuery-File-Upload/");
        File file = new File("test_data/street.jpg");

        webDriver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='files']/tr")));

        webDriver.findElement(By.xpath("//tbody[@class='files']/tr/td[4]/button[2]")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@class='files']/tr/td[4]/button"))).click();

        wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//tbody[@class='files']/tr"))));
        webDriver.quit();
    }
}
