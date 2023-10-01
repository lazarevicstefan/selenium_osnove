package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_01 {
    public static void main(String[] args) {
        /*
        Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
        Klik na Type drawdown
        Klik na Public iz drowdowna
        Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
        Kilk na Clear filter u desnom uglu
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//details[@id='type-options']/summary"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='type-options']/details-menu/div/div/label[2]"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='org-repositories']/div/div/div[1]/div[2]/a"))).click();
        webDriver.quit();
    }
}
