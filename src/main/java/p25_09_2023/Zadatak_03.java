package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/text-box");

        String[] osoba = {"Osoba 1","email@mail.com","Trenutna Adresa","Privremena Adresa",
                        "Osoba 2","email2@email.com","Trenutna Adresa2","Privremena adresa 2",
                        "Osoba 3","email3@email.com","Trenutna Adresa3","Privremena adresa 3"};

        int count = 0;
        for (int i = 1; i <= 3; i++) {

            webDriver.findElement(By.xpath("//input[@id='userName']")).sendKeys(osoba[0+count]);
            webDriver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(osoba[1+count]);
            webDriver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(osoba[2+count]);
            webDriver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(osoba[3+count]);
            webDriver.findElement(By.xpath("//button[text()='Submit']")).click();
            count += 4;
            Thread.sleep(2000);
            webDriver.navigate().refresh();
        }
        webDriver.quit();
    }
}
