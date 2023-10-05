package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.TreeSet;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji:
        Podesava:
        implicitno cekanje za trazenje elemenata od 10s
        implicitno cekanje za ucitavanje stranice od 10s
        eksplicitno cekanje podeseno na 10s
        Podaci:
        Potrebno je u projektu ukljuciti 4 slike:
        front.jpg
        left.jpg
        right.jpg
        back.jpg
        Koraci:
        Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
        Maksimizuje prozor
        Klik na edit ikonicu
        Klik na delete iz iskacuceg dijaloga
        Klik na Add Image dugme
        Sacekajte da se pojavi desni meni
        Uploadujte front.jpg sliku
        Sacekajte da je ispod uploada slike, broj slika 1.
        Klik na sliku
        Klik na Done dugme
        Sacekajte 2s
        Klik na Add Image dugme
        Sacekajte da se pojavi desni meni
        Uploadujte right.jpg sliku
        Sacekajte da je ispod uploada slike, broj slika 2.
        Klik na sliku
        Klik na Done dugme
        Sacekajte 2s
        Klik na Add Image dugme
        Sacekajte da se pojavi desni meni
        Uploadujte back.jpg sliku
        Sacekajte da je ispod uploada slike, broj slika 3.
        Klik na sliku
        Klik na Done dugme
        Sacekajte 2s
        Klik na Add Image dugme
        Sacekajte da se pojavi desni meni
        Uploadujte back.jpg sliku
        Sacekajte da je ispod uploada slike, broj slika 3.
        Klik na sliku
        Klik na Done dugme
        Sacekajte 2s
        Sacekajte da Next dugme bude klikljivo
        Klik na Next dugme
        Unesite tekst
        Klik na Next
        Klik na Preview
        Klik na Add to cart
        Sacekajte 5s
        Quit
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        webDriver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        webDriver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("edit-image"))).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("image-option-remove"))).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("edit-image"))).click();
        Thread.sleep(2000);
        webDriver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/front.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"),1));
        webDriver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        Thread.sleep(2000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("edit-image"))).click();
        Thread.sleep(2000);
        webDriver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/right.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"),2));
        webDriver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("edit-image"))).click();
        Thread.sleep(2000);
        webDriver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/left.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"),3));
        webDriver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("edit-image"))).click();
        Thread.sleep(2000);
        webDriver.findElement(By.id("imageUpload"))
                .sendKeys(new File("test_data/back.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//img[contains(@id,'image-option')]"),4));
        webDriver.findElement(By.id("image-option-0")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textareaID")))
                .sendKeys("Neki tekst");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button"))).click();
        Thread.sleep(5000);

        webDriver.quit();
    }
}
