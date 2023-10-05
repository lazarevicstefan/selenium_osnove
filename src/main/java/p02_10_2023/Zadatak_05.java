package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Zadatak_05 {
    public static void main(String[] args) throws IOException {
        /*
        Napisati program koji:
        Ucitava stranicu https://demoqa.com/broken
        Hvata oba linka sa stranice i
        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
        Koristan link za citanje status koda nekog url-a
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/broken");

        URL link1 = new URL (webDriver.findElement(By
                .xpath("//a[@href='http://demoqa.com']")).getAttribute("href"));

        URL link2 = new URL (webDriver.findElement(By
                .xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']"))
                .getAttribute("href"));

        HttpURLConnection connection1 = (HttpURLConnection) link1.openConnection();
        System.out.println(connection1.getResponseCode());
        connection1.disconnect();

        HttpURLConnection connection2 = (HttpURLConnection) link2.openConnection();
        System.out.println(connection2.getResponseCode());
        connection2.disconnect();

        webDriver.quit();
    }
}
