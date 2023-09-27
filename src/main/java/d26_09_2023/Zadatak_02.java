package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_02 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji:
        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
        POMOC: Brisite elemente odozdo.
        Probajte da resite da se elemementi brisu i odozgo
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(2000);

        List<WebElement> messageList = webDriver.findElements(By.xpath("//div[@class='col-md-12']/div"));

        while (!messageList.isEmpty()){
            webDriver.findElement(By.xpath("//div[@class='col-md-12']/div[last()]/button")).click(); // //div[@class='col-md-12']/div[1]/button
            int num = messageList.size();
            messageList = webDriver.findElements(By.xpath("//div[@class='col-md-12']/div"));
            if (num - 1 == messageList.size()){
                System.out.println("Deleted!");
            }
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
        webDriver.quit();

    }
}
