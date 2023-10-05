package d03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    /*
    1.Zadatak
    Kreirati BootstrapTableTests klasu koja ima:
    Base url: https://s.bootsnipp.com/iframe/K5yrx
    Test #1: Edit Row
    Podaci:
    First Name: ime polaznika
    Last Name: prezime polaznika
    Middle Name: srednje ime polanzika
    Koraci:
    Ucitati stranu /iframe/K5yrx
    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    Klik na Edit dugme prvog reda
    Sacekati da dijalog za Editovanje bude vidljiv
    Popuniti formu podacima.
    Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear.
    Sacekati da dijalog za Editovanje postane nevidljiv
    Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
    Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
    Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
    Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    Test #2: Delete Row
    Podaci:
    First Name: ime polaznika
    Last Name: prezime polaznika
    Middle Name: srednje ime polanzika
    Koraci:
    Ucitati stranu /iframe/K5yrx
    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    Klik na Delete dugme prvog reda
    Sacekati da dijalog za brisanje bude vidljiv
    Klik na Delete dugme iz dijaloga
    Sacekati da dijalog za Editovanje postane nevidljiv
    Verifikovati da je broj redova u tabeli za jedan manji
    Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    Test #3: Take a Screenshot
    Koraci:
    Ucitati stranu  /iframe/K5yrx
    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
    Kreirati screenshot stranice.
    Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png
    */
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://s.bootsnipp.com/iframe/K5yrx");
    }
    @Test(priority = 1)
    public void editRow(){
        String firstName = "Stefan";
        String lastName = "Lazarevic";
        String middleName = "Zoran";

        Assert.assertTrue(driver.getTitle().contains("Table with Edit and Update Data - Bootsnipp.com")
        ,"Title should be 'Table with Edit and Update Data - Bootsnipp.com'");
        driver.findElement(By
                .xpath("//tr[@id='d1']//button[@data-target='#edit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-open")));
        driver.findElement(By.cssSelector(".modal-body #fn")).clear();
        driver.findElement(By.cssSelector(".modal-body #fn")).sendKeys(firstName);
        driver.findElement(By.cssSelector(".modal-body #ln")).clear();
        driver.findElement(By.cssSelector(".modal-body #ln")).sendKeys(lastName);
        driver.findElement(By.cssSelector(".modal-body #mn")).clear();
        driver.findElement(By.cssSelector(".modal-body #mn")).sendKeys(middleName);
        driver.findElement(By.cssSelector(".modal-footer #up")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-open")));

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(),firstName
        ,"On first line below 'First Name' should be '" + firstName + "'");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(),lastName
        ,"On first line below 'Last Name' should be '" + lastName + "'");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(),middleName
        ,"On first line below 'Middle Name' should be '" + middleName + "'");
    }
    @Test (priority = 2)
    public void deleteRow (){
        String firstName = "Stefan";
        String lastName = "Lazarevic";
        String middleName = "Zoran";

        Assert.assertTrue(driver.getTitle().contains("Table with Edit and Update Data - Bootsnipp.com")
                ,"Title should be 'Table with Edit and Update Data - Bootsnipp.com'");

        List<WebElement> atStartNumOfColum = driver
                .findElements(By.xpath("//tbody/tr/td[6]/button"));

        driver.findElement(By
                .xpath("//tr[@id='d1']//button[@data-target='#delete']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-open")));
        driver.findElement(By.cssSelector(".modal-footer #del")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-open")));

        List<WebElement> atEndNumOfColum = driver
                .findElements(By.xpath("//tbody/tr/td[6]/button"));

        Assert.assertEquals(atEndNumOfColum.size()+1, atStartNumOfColum.size()
        ,"Table elements should be one less than at the beginning of test");

    }
    @Test (priority = 3)
    public void takeAScreenshot () throws IOException {
        Assert.assertTrue(driver.getTitle().contains("Table with Edit and Update Data - Bootsnipp.com")
                ,"Title should be 'Table with Edit and Update Data - Bootsnipp.com'");

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(),new File("screenshots/slika.png").toPath());
    }
    @AfterClass
    public void end(){
        driver.quit();
    }
}
