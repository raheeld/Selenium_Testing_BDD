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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.in;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class Started {
    WebDriver driver = null;

    String nameCoursePrice[][] = {{"Rahul Shetty", "Selenium Webdriver with Java Basics + Advanced + Interview Guide", "30"}, {
            "Rahul Shetty", "Learn SQL in Practical + Database Testing from Scratch", "25"
    }, {
            "Rahul Shetty", "Appium (Selenium) - Mobile Automation Testing from Scratch", "30"
    }
    };

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
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> rowsSize = driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table[@id='product']/tbody/tr"));
        List<WebElement> columnSize = driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table[@id='product']/tbody/tr[3]/td"));
        int idx = 2;
        for (int x = 1; x < rowsSize.size() - 7; x++) {
            for (int i = 0; i < columnSize.size(); i++) {
                System.out.println(driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table[@id='product']/tbody/tr[" + idx + "]/td")).get(i).getText());
                System.out.println(nameCoursePrice[x - 1][i]);
                Assert.assertEquals(driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table[@id='product']/tbody/tr[" + idx + "]/td")).get(i).getText(), nameCoursePrice[x - 1][i]);
            }
            idx++;
        }
        driver.close();
//        WebDriverManager.chromedriver().setup();
//        driver = new FirefoxDriver();
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        List<WebElement> cartList[] = {};
//        String cartListElements = driver.findElements(By.ByXPath"//tbody/tr");
//        for (int i=0;) i < cartListElements.length(); ++i) {


    }
}







