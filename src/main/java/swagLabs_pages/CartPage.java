package swagLabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasicPage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isCartPage (){
        return driver.getCurrentUrl().contains("/cart.html");
    }
    public boolean isCartIconVisible(){
        return driver.findElement(By.className("shopping_cart_link")).isDisplayed();
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getTitleInHead(){
        return getTitle();
    }
    public void clickAndShowLeftMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn"))).click();
    }
    public boolean verifyLeftMenuIsShowing(){
            WebElement leftMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));
            return leftMenu.getAttribute("aria-hidden").equals("false");
        }
    public boolean verifyLeftMenuButtonIsEnable(){
        return driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
    }
    public boolean verifyCartIconIsEnable(){
        return driver.findElement(By.className("shopping_cart_link")).isDisplayed();
    }
    public String getSubHeaderTitle(){
        return driver.findElement(By.xpath("//span[@class='title']")).getText();
    }
}
