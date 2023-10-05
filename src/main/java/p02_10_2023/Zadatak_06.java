package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Zadatak_06 {
    public static void main(String[] args) throws IOException {
        /*
        Zadatak (za vezbanje)
        Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u
        folderu screenshots po imenom screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
        Koristan link https://www.javatpoint.com/java-date-to-string
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String stringDate = dateFormat.format(date);

        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), new File("screenshots/screenshot-" + stringDate + ".jpg").toPath());

        webDriver.quit();
    }
}
