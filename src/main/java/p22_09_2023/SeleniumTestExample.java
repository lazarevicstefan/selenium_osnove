package p22_09_2023;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.datatype.Duration;

public class SeleniumTestExample {
    public static void main(String[] args) throws InterruptedException {
        // Postavljanje ChromeDriver koristeći WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Kreiranje instance ChromeDriver-a
        WebDriver driver = new ChromeDriver();
        // Otvaranje veb stranice
        driver.get("https://google.com");
        Thread.sleep(5000);
        // Mesto za test kod ...


        // Zatvoranje pretrazivaca nakon sto se zavrsi testiranje
        driver.quit();
    }
}
