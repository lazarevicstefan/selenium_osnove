package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadatak_04 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
        Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
        Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
        1243+329=
        21912-4=
        12913÷4=
        U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere.
        Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
        Zatim u odnosu na karakter uradite odredjenu logiku
        */
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.calculatorsoup.com/calculators/math/basic.php");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert command in format 15+5= / 514-14=");
        String insert = scanner.nextLine();

        List<Character> chars = new ArrayList<>();
        for (char ch : insert.toCharArray()){
            chars.add(ch);
        }
        WebElement input = webDriver.findElement(By.xpath("//*[@id='cs_display']"));

        for (Character ch : chars){
            if (Character.isDigit(ch)){
                input.sendKeys(ch.toString());
            }else {
                if (ch == '/'){
                    webDriver.findElement(By.xpath("//*[@id=\"cs_calculator_form\"]//button[@name='cs_divide']")).click();
                }else if (ch == '*'){
                    webDriver.findElement(By.xpath("//*[@id=\"cs_calculator_form\"]//button[@name='cs_multiply']")).click();
                }else if (ch == '-'){
                    webDriver.findElement(By.xpath("//*[@id=\"cs_calculator_form\"]//button[@name='cs_subtract']")).click();
                }else if (ch == '+'){
                    webDriver.findElement(By.xpath("//*[@id=\"cs_calculator_form\"]//button[@name='cs_add']")).click();
                }else if (ch == '='){
                    webDriver.findElement(By.xpath("//*[@id=\"cs_calculator_form\"]//button[@name='cs_equal']")).click();
                }
            }
        }
        Thread.sleep(5000);
        webDriver.quit();
    }
}