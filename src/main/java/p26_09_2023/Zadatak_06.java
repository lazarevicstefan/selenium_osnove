package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_06 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Ucitati stranicu https://google.com
        Maksimizovati prozor
        Prostavite dimenzije prozora na 700px i visinu na 700px
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://google.com");
        webDriver.manage().window().maximize();
        Thread.sleep(2000);
        webDriver.manage().window().setSize(new Dimension(700,700));
        Thread.sleep(2000);

        webDriver.quit();
    }
}
