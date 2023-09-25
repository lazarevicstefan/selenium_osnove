package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Zadatak_05 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        String[] links = {"https://google.com/",
                "https://youtube.com/",
                "https://www.ebay.com/",
                "https://www.kupujemprodajem.com/"};

        for (String link : links) {
            webDriver.get(link);
            System.out.println(webDriver.getTitle());
        }
        webDriver.quit();
    }
}
