package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/webtables");
        webDriver.findElement(By.xpath("//span[@id='edit-record-1']")).click();

        webDriver.findElement(By.xpath("//input[@id='firstName']")).clear();
        webDriver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Stefan");

        webDriver.findElement(By.xpath("//input[@id='lastName']")).clear();
        webDriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Lazarevic");

        webDriver.findElement(By.xpath("//input[@id='userEmail']")).clear();
        webDriver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("email@mail.com");

        webDriver.findElement(By.xpath("//input[@id='age']")).clear();
        webDriver.findElement(By.xpath("//input[@id='age']")).sendKeys("28");

        webDriver.findElement(By.xpath("//input[@id='salary']")).clear();
        webDriver.findElement(By.xpath("//input[@id='salary']")).sendKeys("200000");

        webDriver.findElement(By.xpath("//input[@id='department']")).clear();
        webDriver.findElement(By.xpath("//input[@id='department']")).sendKeys("Automation QA Software");

        webDriver.findElement(By.xpath("//button[@id='submit']")).click();

        Thread.sleep(3000);
        webDriver.quit();

    }
}
