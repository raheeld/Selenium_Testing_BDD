package org.example;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class LoginPageTest {
    WebDriver driver = null;



    @Test
    public void StateFarmHomePage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.statefarm.com");
        driver.findElement(By.cssSelector("button[class='-oneX-header-top-menu-btn'] span")).click();
        driver.findElement(By.xpath("//input[@id='oneX-username']")).sendKeys("raheeld@hotmail.com");
        driver.findElement(By.xpath("//input[@id='util-login-password']")).sendKeys("234567");
        driver.findElement(By.cssSelector("button[class='-oneX-util-login-button -oneX-btn-primary -oneX-btn-fit-content']")).click();
        Thread.sleep(4000);
        String errorMessage = driver.findElement(By.cssSelector("#troubleLoggingIn")).getText();
        String LoginErrorMsg = "Trouble logging in?";
        Assert.assertEquals(errorMessage, LoginErrorMsg);
        driver.quit();
    }
//    @Test
//    public void printStatement() {
//        String hello = "Hello My Name Usman";
//        String [] splitHello = hello.split(" ");
//        for ( int i = 0;i<splitHello.length;i++){
//            System.out.println(splitHello[i]);
//        }
//        System.out.println("Hello \nWorld");
//    }
//
}
