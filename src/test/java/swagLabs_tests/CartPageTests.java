package swagLabs_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends BasicTest{
    @Test
    public void verifyTheUrl(){
        Assert.assertTrue(inventoryPage.isInventoryPage(), "There should be Inventory page");
    }
    @Test
    public void verifyTheTitlePage (){
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(inventoryPage.getTitle(),expectedTitle
                ,"Title should be '" + expectedTitle + "'");
    }


}
