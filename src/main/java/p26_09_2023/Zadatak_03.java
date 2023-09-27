package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_03 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisti program koji:
        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
        Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
        Ceka 5s
        Zatvara pretrazivac
        Stampa treba da bude kao u primeru:
        John	Doe	john@example.com
        Mary	Moe	mary@example.com
        July	Dooley	july@example.com
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(2000);


        List<WebElement> elementList = webDriver.findElements(By.xpath("//div[@id='lorem']//tbody//tr"));
        for (WebElement row : elementList){
            for(WebElement one : row.findElements(By.xpath("td"))){
                System.out.print(one.getText() + " \t");
            }
            System.out.println();
        }
        webDriver.quit();
    }
}
