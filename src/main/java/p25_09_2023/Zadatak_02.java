package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        String username = "itbootcamp";
        String password = "ITBootcamp2021!";

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://demoqa.com/login");
        webDriver.findElement(By.xpath("//input[@id='userName']")).clear();
        webDriver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);

        webDriver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        webDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);

        webDriver.findElement(By.xpath("//form[@id='userForm']/div[4]/div[1]/button")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//button[text()='Log out']")).click();
        webDriver.quit();

    }
}
