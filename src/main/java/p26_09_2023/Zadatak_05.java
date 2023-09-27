package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_05 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji ucitava stranicu https://demoqa.com/automation-practice-form
        Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.
        */

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(4000);

        webDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
        webDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
        webDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
        Thread.sleep(4000);

        if (webDriver.findElement(By.cssSelector("#hobbies-checkbox-1")).isSelected()) System.out.println("Selektovan");
        if (webDriver.findElement(By.cssSelector("#hobbies-checkbox-2")).isSelected()) System.out.println("Selektovan");
        if (webDriver.findElement(By.cssSelector("#hobbies-checkbox-3")).isSelected()) System.out.println("Selektovan");

        webDriver.quit();
    }
}
