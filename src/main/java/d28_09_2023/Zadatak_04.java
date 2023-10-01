package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_04 {
    public static void main(String[] args) {
        /*
        Ucitati stranicu http://seleniumdemo.com/?post_type=product
        Klik na search dugme u gornjem desnom uglu
        Cekati da forma za pretragu bude vidljiva
        Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
        Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu.
        Ispisati odgovarajuce poruke u terminalu
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("http://seleniumdemo.com/?post_type=product");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.findElement(By.xpath("//a[contains(@class, 'search-toggle_btn icn-search czr-overlay')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#s-651536d633c09")))
                .sendKeys("BDD Cucumber" + Keys.ENTER);
        WebElement element = webDriver.findElement(By.xpath("//div[@class='grid__wrapper grid']/section/article[1]"));
        element.findElement(By.xpath("//a[@class='czr-title']"));
        if (element.getText().contains("BDD Cucumber")){
            System.out.println(element.getText());
        }
        webDriver.quit();
    }
}
