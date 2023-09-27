package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisti program koji:
        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
        Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
        Ceka 1s
        Hvata sve elemente prvog reda i stampa tekst svakog elementa
        Ceka 5s
        Zatvara pretrazivac
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(2000);

        List<WebElement> firstRow = webDriver.findElements(By.xpath("//div[@id='lorem']//tbody//td[1]"));
        Thread.sleep(1000);
        for (WebElement elemen: firstRow){
            System.out.print(elemen.getText() + "\t");
        }
        System.out.println();

        List<WebElement> tables = webDriver.findElements(By.xpath("//div[@id='lorem']//tbody/tr[1]/td"));
        Thread.sleep(5000);
        for (WebElement element:tables){
            System.out.print(element.getText() + "\t");
        }
        webDriver.quit();
    }
}
