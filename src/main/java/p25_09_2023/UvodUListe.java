package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UvodUListe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://cms.demo.katalon.com/my-account/");

        List<WebElement> links = webDriver.findElements(By.cssSelector("li.page_item > a"));

        for (int i = 0; i < links.size(); i++) {
//            System.out.println();
        }

    }
}
