package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class StateFarm {
    WebDriver driver = null;
    String expectedZipCodeErrorMessage = "Enter a valid 5-digit ZIP Code.";

    @Test
    public void stateFarmHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();// Gecko Driver, IE iedriver, safari driver
        driver.get("https://www.statefarm.com");
        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("19047");
        int lengthOfZipCode = driver.findElement(By.id("quote-main-zip-code-input")).getAttribute("value").length();
        System.out.println(lengthOfZipCode);
        Assert.assertEquals(lengthOfZipCode, 5);

    }

    @Test
    public void validateIfZipCodeTakesMoreThan5Integer() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();//ChromeDriver();// Gecko Driver, IE iedriver, safari driver
        driver.get("https://www.statefarm.com");
        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("1904745345345");
        int lengthOfZipCode = driver.findElement(By.id("quote-main-zip-code-input")).getAttribute("value").length();
        System.out.println(lengthOfZipCode);
        Assert.assertEquals(lengthOfZipCode, 5);
    }

    @Test
    public void DropDownMenuTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Select select=new Select(driver.findElement(By.id("dropdown-class-example")));
        List<WebElement> selectedOptions = select.getOptions();
        for (int i = 0; i<selectedOptions.size();i++) {
            System.out.println(selectedOptions.get(i).getText());
        }
        select.selectByIndex(0);
        Thread.sleep(3000);
    }
    @Test
    public void validateIfZipCodeFieldTakesCharacters() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();// Gecko Driver, IE iedriver, safari driver
        driver.get("https://www.statefarm.com");
        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("abcedf");
        int lengthOfZipCode = driver.findElement(By.id("quote-main-zip-code-input")).getAttribute("value").length();
        System.out.println(lengthOfZipCode);
        Assert.assertEquals(lengthOfZipCode, 0);
    }

    @Test
    public void validateZipCodeErrorMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();// Gecko Driver, IE iedriver, safari driver
        driver.get("https://www.statefarm.com");
        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("00098", Keys.ENTER);

        String errorMessage = driver.findElement(By.cssSelector("#quote-error-alert")).getText();
        System.out.println(errorMessage);
        Assert.assertEquals(errorMessage, expectedZipCodeErrorMessage);

    }

    @AfterTest
    public void tearDown() {
        driver.quit(); // driver.close();
    }
}
