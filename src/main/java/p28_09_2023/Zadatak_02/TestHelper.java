package p28_09_2023.Zadatak_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestHelper {
    private WebDriver driver;

    public TestHelper(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }
    public boolean elementExists (By object){
        try {
            driver.findElement(object).click();
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean elementExistsByList (By object){
            return !driver.findElements(object).isEmpty();
    }
    public void setDefaultImplicitWait (){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void setImplicitWait (int seconds){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    public void driverExit (){
        this.driver.quit();
    }
}
