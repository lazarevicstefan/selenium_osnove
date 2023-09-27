package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Niz od 5 stringova. Svaki element u nizu je url stranice:
        https://www.google.com/
        https://www.facebook.com/
        https://www.youtube.com/
        https://www.ebay.com/
        https://www.katalon.com/
        zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu prateci sledeca pravila:
        za svaku stranicu se kreira nova infrastuktura
        ucitava stranica
        pravi pauza od 1s
        ponistava testna stuktura

         */
        List<String> nizUrl = new ArrayList<>();
        nizUrl.add("https://www.google.com/");
        nizUrl.add("https://www.facebook.com/");
        nizUrl.add("https://www.youtube.com/");
        nizUrl.add("https://www.ebay.com/");
        nizUrl.add("https://www.katalon.com/");

        for (String url: nizUrl){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
