package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_03 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Zadatak (za vezbanje)
        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
        Visit Paris
        Visit Prague
        Visit London
        Visit New York
        Visit Belgrade
        Maksimizirati prozor
        Ucitati stranicu https://example.cypress.io/todo
        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
        Nakon svakog unosa todo-a, unosi se enter
        Validira da li je novi todo dodat na stranici  (ispisati poruku)
        Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
        Validirati da je na kraju programa broj todo-a na stranici 0. (ispisati poruku)
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
//            System.out.println(webDriver.findElement(By.xpath("/html/body/section/div/header/input")).getText());
        }

        List<WebElement> fullList = webDriver.findElements(By.xpath("//ul[@class='todo-list']/li/div/button"));
        for (int i = 0; i < fullList.size(); i++) {
            WebElement el = webDriver.findElement(By.xpath("//ul[@class='todo-list']/li[last()]/div/button"));
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("document.getElementByXpath('//ul[@class='todo-list']/li[last()]/div/button').setAttribute('style.display','revert');");
            el.click();
                Thread.sleep(500);
        }

        System.out.println("Deleted");
        List<WebElement> elementsCheck = webDriver.findElements(By.xpath("//ul[@class='todo-list']//input"));
        System.out.println(elementsCheck.size());
        Thread.sleep(5000);
        webDriver.quit();
    }
}
