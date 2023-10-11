package saurcedemo_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftNavPage extends BasicPage{
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isLeftNavShowing(){
        WebElement leftMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));
        return leftMenu.getAttribute("aria-hidden").equals("false");
    }
    public boolean isLogOutButtonExist(){
        return driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
    }
    public void clickOnLogOutButton(){
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}
