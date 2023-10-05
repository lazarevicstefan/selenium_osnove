package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.time.Duration;

public class Zadatak_03 {
    public static void main(String[] args)  {
        /*
        Napisati program koji
        Kreirati folder downloads folder u projektu
        URL SLIKE https://cdn.britannica.com/29/150929-050-547070A1/lion-Kenya-Masai-Mara-National-Reserve.jpg
        Sliku sacuvajte u folderu downloads pod nazivom ljuti-lav.jpg
        Azurirajte gitignore da ignorise downloads folder
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        webDriver.get("https://www.pexels.com/photo/a-woman-holding-a-laptop-in-the-living-room-6585859/");
        String getSrc = webDriver.findElement(By.xpath("//img[contains(@alt, 'Free A Woman Holding')]")).getAttribute("src").split("\\?")[0];
//        getSrc = String.valueOf(getSrc.endsWith("jpeg"));

        System.out.println(getSrc);
        String newURL = "https://cdn.britannica.com/29/150929-050-547070A1/lion-Kenya-Masai-Mara-National-Reserve.jpg";

        try {
            Thread.sleep(1000);
           downloadIMG(newURL,new File("downloads/ljuti-lav.jpg").getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        webDriver.quit();
    }
    public static void downloadIMG(String urlLocation,String location) throws Exception{
        URL url = new URL(urlLocation);
        Image image = ImageIO.read(url);
        ImageIO.write((RenderedImage) image,"jpg",new File(location));
    }
}
