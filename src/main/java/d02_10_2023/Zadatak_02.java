package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_02 {
    public static void main(String[] args) {
        /*
        Napisati program koji:
        Ucitava stranu https://itbootcamp.rs/
        Misem prelazi preko Vesti iz navigacionog menija
        Ceka da se prikaze padajuci meni za Vesti
        Misem prelazi preko Kursevi iz navigacionog menija
        Ceka da se prikaze padajuci meni za Kursevi
        Misem prelazi preko Prijava i pravilnik iz navigacionog menija
        Ceka da se prikaze padajuci meni za Prijava i pravilnik
        Koristan link. Mouse over preko seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("https://itbootcamp.rs/");

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.cssSelector("#menu-item-6408 > a")))
                .perform();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#menu-item-6408 > ul.dropdown-menu")));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.cssSelector("#menu-item-5362 > a")))
                .perform();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#menu-item-5362 > ul.dropdown-menu")));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.cssSelector("#menu-item-5453 > a")))
                .perform();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#menu-item-5453 > ul.dropdown-menu")));

        webDriver.quit();
    }
}
