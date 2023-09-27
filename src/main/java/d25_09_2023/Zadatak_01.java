package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Maksimizirati prozor
        Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Prijavite se na sistem
        Username: Admin
        Password: admin123
        Cekanje od 5s
        U input za pretragu iz navigacije unesite tekst Me
        Kliknite na prvi rezultat pretrage (to ce biti Time)
        Cekanje od 1s
        Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
        Klinkite na logout
        Cekanje od 5s
        Zatvorite pretrazivac
         */
        String username = "Admin";
        String password = "admin123";
        String searchText = "Me";

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        webDriver.findElement(By.name("username")).sendKeys(username);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[text()=' Login ']")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//*[@class='oxd-main-menu-search']/input")).sendKeys(searchText);
        webDriver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[1]/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        webDriver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(5000);

        webDriver.quit();

    }
}
