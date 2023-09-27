package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak_01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji:
        Ucitava stranicu https://demoqa.com/automation-practice-form
        Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
        (za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
        Klik na submit
        */
        Scanner scanner = new Scanner(System.in);
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(1000);
        System.out.print("Enter First Name: ");
        webDriver.findElement(By.id("firstName")).clear();
        webDriver.findElement(By.id("firstName")).sendKeys(scanner.next());

        System.out.print("Enter Last Name: ");
        webDriver.findElement(By.id("lastName")).clear();
        webDriver.findElement(By.id("lastName")).sendKeys(scanner.next());

        System.out.print("Enter Email: ");
        webDriver.findElement(By.id("userEmail")).clear();
        webDriver.findElement(By.id("userEmail")).sendKeys(scanner.next());

        System.out.print("Enter male/female/other: ");
        String mfo = scanner.next();
        if (mfo.equals("male"))webDriver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        else if (mfo.equals("female"))webDriver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
        else if (mfo.equals("other"))webDriver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();

        System.out.print("Enter Mobile Number(10 digits): ");
        webDriver.findElement(By.id("userNumber")).clear();
        webDriver.findElement(By.id("userNumber")).sendKeys(scanner.next());

//        System.out.print("Enter Date(17 Sep 2023): ");
//        webDriver.findElement(By.id("dateOfBirthInput")).clear();
//        webDriver.findElement(By.id("dateOfBirthInput")).sendKeys(scanner.next());

        System.out.print("Enter Subject: ");
        webDriver.findElement(By.id("subjectsInput")).clear();
        webDriver.findElement(By.id("subjectsInput")).sendKeys(scanner.next());

        System.out.print("Enter Hobbies(separate with \",\")sport/reading/music: ");
        String[] hobbies = scanner.next().split(",");
        for (String hob : hobbies){
            if (hob.trim().equals("sport"))webDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
            if (hob.trim().equals("reading"))webDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
            if (hob.trim().equals("music"))webDriver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
        }

        System.out.print("Upload Image yes/no: ");
        if (scanner.next().equals("yes")) webDriver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("D:\\Java\\ITBootCamp\\selenium_osnove\\src\\main\\java\\d26_09_2023\\man.png");

        System.out.print("Enter Current Address: ");
        webDriver.findElement(By.id("currentAddress")).clear();
        webDriver.findElement(By.id("currentAddress")).sendKeys(scanner.next());
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}
