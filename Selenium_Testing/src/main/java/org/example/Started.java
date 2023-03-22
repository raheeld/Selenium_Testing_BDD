package org.example;

//import io.github.bonigarcia.wdm.WebDriverManager;

import dev.failsafe.internal.util.DelegatingScheduler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

import static java.lang.System.in;
import static org.openqa.selenium.By.cssSelector;

public class Started {
    WebDriver driver = null;

    @Test
    public void ValidateUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String expectedUrls = "https://rahulshettyacademy.com/AutomationPractice/";
        String actualUrls = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrls, actualUrls);
    }

    @Test
    public void ValidateRadioButtons() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String expectedRadioButtonsText = "Radio Button Example";
        String actualRadioButtonsText = driver.findElement(cssSelector("div[id='radio-btn-example'] fieldset legend")).getText();
        Assert.assertEquals(actualRadioButtonsText, expectedRadioButtonsText);
        driver.quit();
    }

    @Test
    public void ValidateRadio1ButtonsText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String expectedRadioButton1Text = "Radio1";
        String actualRadioButton1Text = driver.findElement(By.xpath("//label[@for='radio1']")).getText();
        System.out.println(actualRadioButton1Text);
        Assert.assertEquals(actualRadioButton1Text, expectedRadioButton1Text);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void ValidateRadioButtonsText() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String GetButtonText = driver.findElement(cssSelector("#dropdown-class-example")).getText();
        //Assert.assertEquals();
        System.out.println(GetButtonText);
    }

    @Test
    public void SuggestionClassExample() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).getText();
    }

    @Test
    public void getWebTable() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> table = driver.findElements(By.cssSelector("body > div:nth-child(5) > div:nth-child(1) > fieldset:nth-child(1) > table:nth-child(2)"));
        for (WebElement i : table) {
            System.out.println(i.getText());
        }
    
    }
}

