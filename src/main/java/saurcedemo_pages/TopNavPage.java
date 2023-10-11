package saurcedemo_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavPage extends BasicPage{

    public TopNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickAndShowLeftMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn"))).click();
    }
}
