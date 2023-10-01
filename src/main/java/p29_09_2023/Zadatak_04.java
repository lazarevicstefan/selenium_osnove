package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_04 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji
        ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        Klik Primary dugme
        Ceka da se pojavi toasts u gBootstrap Toasts - examples & tutorialornjem desnom uglu
        Ispisuje da se element pojavio
        Ceka da se izgubi toasts u gornjem desnom uglu
        Ispisuje da se elment izgubio
        Klik na primary dugme
        Ceka da se pojavi toasts u gornjem desnom uglu
        Ispisuje da se element pojavio
        Klik na x dugme iz toasts-a
        Ceka da se element izgubi
        Ispisuje da se element izgubio
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.findElement(By.id("basic-primary-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='basic-primary-example'][contains(@class, 'show')]")));
        System.out.println("Element je prikazan");

        wait    .pollingEvery(Duration.ofMillis(100))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='basic-primary-example'][contains(@style, 'none')]")));
        System.out.println("Element je skriven");

        webDriver.findElement(By.id("basic-primary-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='basic-primary-example'][contains(@class, 'show')]")));
        System.out.println("Element je prikazan");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='basic-primary-example']/div[1]/button"))).click();
        System.out.println("Element je skriven");
        webDriver.quit();

    }
}
