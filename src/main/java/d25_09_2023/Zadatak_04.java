package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_04 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Zadatak
        Maksimizirati prozor
        Ucitati stranicu https://artplayer.org/
        U fokusu je player sa desne strane
        Ceka 3-4s
        Klik na play dugme
        Klik na na zvucnik za mute
        Ceka 3s
        Klik na screenshot
        Klik na PIP mode
        Ceka 1s
        Klik na Exit PIP mode
        Klik na WebFullscreen
        Klik na Exit WebFullscreen
        Cekanje od 5s
        Zatvorite pretrazivac
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.artplayer.org/");
        Thread.sleep(4000);
        webDriver.findElement(By.xpath("//i[@aria-label='Play']")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//i[contains(@class,'art-icon-volume')][1]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//i[contains(@class,'art-icon-screenshot')]")).click();
        webDriver.findElement(By.xpath("//i[contains(@class,'art-icon-pip')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//i[contains(@class,'art-icon-pip')]")).click();
        webDriver.findElement(By.xpath("//i[contains(@class,'art-icon-fullscreenWebOn')]")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//i[contains(@class,'art-icon-fullscreenWebOff')]")).click();

        Thread.sleep(5000);
        webDriver.quit();
    }
}
