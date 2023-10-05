package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class Zadatak_04 {
    public static void main(String[] args) throws IOException {
        /*
        Napisati program koji:
        Kreirati screenshots folder u projektu
        Ucitava stranicu https://google.com
        Kreira screenshot stranice
        Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), new File("screenshots/screen.jpg").toPath());

        webDriver.quit();
    }
}
