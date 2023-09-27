package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
        Visit Paris
        Visit Prague
        Visit London
        Visit New York
        Visit Belgrade
        Maksimizirati prozor
        Ucitati stranicu https://example.cypress.io/todo
        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
        Nakon svakog unosa todo-a, unosi se enter. Koristan link
        Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
        Cekanje od 5s
        Zatvorite pretrazivac
        */
        String[] toDoList = {"Visit Paris",
                "Visit Prague",
                "Visit London",
                "Visit New York",
                "Visit Belgrade"};

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://example.cypress.io/todo");
        Thread.sleep(2000);

        for (String todo: toDoList){
            webDriver.findElement(By.xpath("/html/body/section/div/header/input")).sendKeys(todo + Keys.ENTER);
            Thread.sleep(1000);
        }
        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@class='todo-list']//input"));
        Thread.sleep(1000);
        for (WebElement element : elements){
            element.click();
            Thread.sleep(1000);
        }

        Thread.sleep(4000);
        webDriver.quit();
    }
}
