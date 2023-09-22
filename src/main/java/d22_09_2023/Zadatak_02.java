package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
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
