package p28_09_2023.Zadatak_02;

import org.openqa.selenium.By;

public class Main {
    public static void main(String[] args) {
        TestHelper testHelper = new TestHelper("https://demoqa.com/modal-dialogs");
        testHelper.setDefaultImplicitWait();
        testHelper.elementExists(By.id("showLargeModal"));
        String print = testHelper.elementExistsByList(By.xpath("//div[@role='dialog']")) ? "Element je prikazan" : "Element nije prikazan";
        System.out.println(print);
        testHelper.driverExit();
    }
}
