package saurcedemo_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
    }
    public boolean isErrorMessageExist(){
        return driver.findElement(By.cssSelector(".error-message-container h3")).isDisplayed();
    }
    public String getErrorMessage(){
        if (isErrorMessageExist()){
            return driver.findElement(By.cssSelector(".error-message-container h3")).getText();
        }
        return "No error";
    }
    public void clearAndEnterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    public void clearAndEnterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }
    public boolean isLoginPageShowing(){
        return driver.findElement(By.className("login_container")).isDisplayed();
    }
}
