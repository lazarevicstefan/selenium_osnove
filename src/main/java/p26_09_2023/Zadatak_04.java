package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak_04 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.ebay.com/");
        Thread.sleep(2000);
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='gh-cat']")));
        select.selectByVisibleText("Crafts");

        Thread.sleep(4000);
        webDriver.quit();

    }
}
