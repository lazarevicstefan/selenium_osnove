package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak_01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://demoqa.com/modal-dialogs");

        WebElement element = webDriver.findElement(By.id("showLargeModal"));
        element.click();
        ///////////////////////////////////////////////////////////////////
//        List<WebElement> form = webDriver.findElements(By.xpath("//div[@role='dialog']"));
//        if (!form.isEmpty()){
//            System.out.println("Forma je prikazana");
//        }else{
//            System.out.println("Forma nije prikazana");
//        }
        ///////////////////////////////////////////////////////////////////
        boolean formValid = true;
        try {
            webDriver.findElements(By.xpath("//div[@role='dialog']"));
        }catch (Exception e){
            formValid = false;
        }
        String print = formValid ? "Forma je prikazana" : "Forma nije prikazana";
        System.out.println(print);
        ///////////////////////////////////////////////////////////////////

        webDriver.quit();
    }
}
