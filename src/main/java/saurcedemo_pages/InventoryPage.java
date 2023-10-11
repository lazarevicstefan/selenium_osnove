package saurcedemo_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InventoryPage extends BasicPage{

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isInventoryPage(){
        return driver.getCurrentUrl().contains("/inventory.html");
    }
    public void addToCartProduct(String nameOfProduct){
        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".inventory_list .inventory_item_description"));
        for (int i = 0; i < listOfProducts.size(); i++) {
            WebElement product = listOfProducts.get(i).findElement(By.className("inventory_item_name"));
            System.out.println(product.getText());
            if (product.getText().equals(nameOfProduct)){
                listOfProducts.get(i).findElement(By.cssSelector(".inventory_item_label > a")).click();
            }
        }
    }
}
