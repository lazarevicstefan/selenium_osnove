package swagLabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saurcedemo_pages.BasicPage;

import java.util.List;

public class InventoryPage extends BasicPage {

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isInventoryPage(){
        return driver.getCurrentUrl().contains("/inventory.html");
    }
    public void addToCartProduct(String... nameOfProduct){
        try{
        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".inventory_list .inventory_item_description"));
        for (int i = 0; i < listOfProducts.size(); i++) {
            WebElement product = listOfProducts.get(i).findElement(By.className("inventory_item_name"));
            System.out.println(product.getText());
            for (int j = 0; j < nameOfProduct.length; j++) {
                if (product.getText().equals(nameOfProduct[i])){
                    listOfProducts.get(i).findElement(By.cssSelector(".pricebar button")).click();
                }
            }

        }}catch (Exception e){}
    }
    public void clickOnCartIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link"))).click();
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getCartNumber (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge"))).getText();
    }
}
