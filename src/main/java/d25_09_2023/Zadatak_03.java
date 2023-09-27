package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_03 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji vrsi dodavanje 5 redova
        Maksimizirati prozor
        Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
        Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
        Klik na dugme Add New
        Unesite name,departmant i phone (uvek iste vrednost)
        Trazenje po name atributu
        Kliknite na zeleno Add dugme.
        PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
        Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
        Cekanje od 0.5s
        Na kraju programa ugasite pretrazivac.
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        Thread.sleep(2000);
        WebElement buttonAdd = webDriver.findElement(By.xpath("//button[@type='button']"));

        for (int i = 0; i < 5; i++) {
            buttonAdd.click();
            WebElement element = webDriver.findElement(By.xpath("//table//tbody/tr[last()]"));
            element.findElement(By.name("name")).sendKeys("Ime");
            element.findElement(By.name("department")).sendKeys("Odeljenje");
            element.findElement(By.name("phone")).sendKeys("123456789");
            Thread.sleep(1000);
            element.findElement(By.className("add")).click();
            Thread.sleep(500);
        }

        Thread.sleep(2000);
        webDriver.quit();
    }
}
