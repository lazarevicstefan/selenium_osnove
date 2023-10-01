package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_06 {
    public static void main(String[] args) {
        /*
        Napisati program koji:
        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        Vrsi klik na Primary dugme, Secondary, Sucess, Danger
        Ceka da broj toasts-a bude 4
        Ispisuje poruku, toasts su prikazani
        Ceka da broj toasts-a bude 0
        Ispisuje poruku, toasts su se izgubili
        */
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        webDriver.findElement(By.id("basic-primary-trigger")).click();
        webDriver.findElement(By.id("basic-secondary-trigger")).click();
        webDriver.findElement(By.id("basic-success-trigger")).click();
        webDriver.findElement(By.id("basic-danger-trigger")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'toast-fixed show')]"),4));
        System.out.println("Svi elementi su prikazani");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'toast-fixed show')]"),0));
        System.out.println("Svi elementi su skriveni");

        end = System.currentTimeMillis();
        double time = (end - start ) / 1000.0;
        System.out.println("Vreme koje je potrebno za izvrsenje: " + time + "s");
        webDriver.quit();

    }
}
