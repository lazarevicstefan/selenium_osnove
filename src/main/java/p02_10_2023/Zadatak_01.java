package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;
import java.time.Duration;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji:
        Krairajte folder za fajlove u okviru projekta pod nazivom test_data
        U folder skinite i postavite proizvoljnu sliku
        Ucitava stranu https://tus.io/demo.html
        Skrola do dela za upload fajla
        Aploadujte sliku
        Cekajte da se pojava dugme za download fajla
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        webDriver.get("https://tus.io/demo");
//        webDriver.manage().window().maximize();
        WebElement upload = webDriver.findElement(By.id("P0-0"));
        Thread.sleep(2000);
        try {
            new Actions(webDriver).scrollToElement(webDriver.findElement(By.id("http-traffic"))).build().perform();
        }catch (Exception e){

        }
        File fileUpload = new File("test_data/street.jpg");
        upload.sendKeys(fileUpload.getAbsolutePath());
        wait    .withMessage("Error")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'_buttons')]/a")));
        System.out.println("File is uploaded!");


        try {
            Thread.sleep(1000);
            String url = webDriver.findElement(By.xpath("//div[contains(@class,'_buttons')]/a")).getAttribute("href");
            System.out.println(url);
            downloadIMG(url,new File("downloads/street.jpg").getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if ((new File("test_data/street.jpg").length()) == (new File("downloads/street.jpg").length())){
            System.out.println("Slike su identicne velicine");
        }else{
            System.out.println("Slike nisu identicne velicine");
        }


        webDriver.quit();
    }
    public static void downloadIMG(String urlLocation,String location) throws Exception{
        URL url = new URL(urlLocation);
        Image image = ImageIO.read(url);
        ImageIO.write((RenderedImage) image,"jpg",new File(location));
    }
}
