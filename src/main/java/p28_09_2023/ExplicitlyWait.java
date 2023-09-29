package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitlyWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://demoqa.com/dynamic-properties");
        WebElement btn = webDriver.findElement(By.id("enableAfter"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));

        wait
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .withMessage("Dugme nije postalo kliktabilno")
                .until(ExpectedConditions.elementToBeClickable(btn));

    }
}
