package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_03 {
    public static void main(String[] args) {
        /*
        Napisati program implementira search test case za task-ove:
        Ucitati stranicu https://s.bootsnipp.com/iframe/8dqr
        Klik na filter dugme iz Tasks tabele
        Ceka da polje za input bude vidljivo. (Postaviti odgovarajuce poruke u slucaju greske)
        Za pretragu unosi tekst za koji nema rezultata pretrage npr: dsdsdsds
        Ceka da se pojavi No results found red i proverava ispisanu poruku da li je tekst “No results found”
        Za pretragu unosi sledeci tekst mi
        Validira da red No results found  vise ne postoji
        Validira rezultate pretrage 🔥
        Pravila pretrage:
        Red ce biti u rezultatu ukoliko bar jedna kolona tog reda sadrzi termin pretrage.
        Pretraga nije case sensitive, sto znaci da radi i za velika i mala slova.
        Ispisuje odgovarajuce poruke
        Klik na filter dugme
        Ceka da polje za pretragu postane nevidljivo. (Postaviti odgovarajuce poruke u slucaju greske)
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://s.bootsnipp.com/iframe/8dqr");

        webDriver.findElement(By.xpath("//div[@class='panel panel-success']//span"));
        WebElement search = webDriver.findElement(By.xpath("//div[@class='panel panel-success']//input[@class='form-control']"));
        wait    .withMessage("Greska!")
                .until(ExpectedConditions.visibilityOf(search));
        search.sendKeys("dsdsdsds");

        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//tr[@class='filterTable_no_results']/td"),"No results found"));
        webDriver.quit();


    }
}
