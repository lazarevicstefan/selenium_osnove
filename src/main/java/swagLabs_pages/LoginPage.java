package swagLabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saurcedemo_pages.BasicPage;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
    }
    public void clearAndEnterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    public void clearAndEnterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }
    public void logInWithValidCredentials(){
        String username = "standard_user";
        String password = "secret_sauce";
        clearAndEnterUsername(username);
        clearAndEnterPassword(password);
        clickOnLoginButton();
    }
}
