package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Zadatak_00 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //Add Actions scroll to Element sample code
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://docs.katalon.com/");

        WebElement footer = webDriver.findElement(By.className("learnMore_S033"));
        Actions action = new Actions(webDriver);
        action.scrollToElement(footer);
        action.perform();

//        new Actions(webDriver).scrollToElement(footer).perform();





    }
}
