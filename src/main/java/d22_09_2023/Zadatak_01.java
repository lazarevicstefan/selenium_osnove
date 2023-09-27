package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Niz od 5 stringova. Svaki element u nizu je url stranice:
        https://www.google.com/
        https://www.facebook.com/
        https://www.youtube.com/
        https://www.ebay.com/
        https://www.katalon.com/
        kreira testnu infrastukturu
        zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu i pritom pravi pauzu od 2 sekunde izmedju svaka dva ucitanja stranice
        Na kraju program ponisava testnu ifrastukturu
         */
        List<String> nizUrl = new ArrayList<>();
        nizUrl.add("https://www.google.com/");
        nizUrl.add("https://www.facebook.com/");
        nizUrl.add("https://www.youtube.com/");
        nizUrl.add("https://www.ebay.com/");
        nizUrl.add("https://www.katalon.com/");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        for (String url:nizUrl){
            driver.get(url);
            Thread.sleep(2000);
        }

        driver.quit();
    }
}
