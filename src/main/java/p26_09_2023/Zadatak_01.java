package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisti proram koji :
        Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
        Hvatamo sve page-eve iz paginacije tabele
        Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
        Izmedju iteracija napravite pauzu od 1s
        Zatvorite pretrazivac
         */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://s.bootsnipp.com/iframe/oV91g");

        List<WebElement> elementList = webDriver.findElements(By.cssSelector("a.page_link"));
        for (WebElement element : elementList){
            element.click();
            Thread.sleep(1000);
        }
        webDriver.quit();
    }
}
