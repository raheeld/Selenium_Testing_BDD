import com.github.dockerjava.api.model.CpuStatsConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Raheel {
    String landingPage1 = "https://rahulshettyacademy.com/AutomationPractice/";
    WebDriver driver = null;

    @BeforeTest
    public void invokeBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();//ChromeDriver;// Gecko Driver, IE iedriver, safari driver
//        driver.get("https://www.google.com");
    }

    @Test
    public void validateUrls() {
//        WebDriverManager.firefoxdriver().setup();
        String landingPage = "https://rahulshettyacademy.com/AutomationPractice/";
//        driver = new FirefoxDriver();
        driver.get(landingPage);
        String currentUrls = driver.getCurrentUrl();
        Assert.assertEquals(currentUrls, landingPage);
//        driver.quit();
    }

    @Test
    public void validateAutoSuggestionCountry() throws InterruptedException {
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("Pa");
        Thread.sleep(2000);
        List<WebElement> countries = driver.findElements(By.xpath("//ul[@id=\"ui-id-1\"]/li"));

        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i).getText());
        }

        for (int x = 0; x < countries.size(); x++) {
            if (countries.get(x).getText().equals("Pakistan")) {
                countries.get(x).click();
            }
//            driver.quit();
        }
    }

    @Test
    public void autoSuggestion () throws InterruptedException {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("am");
        Thread.sleep(2000);
        List<WebElement> countries1 = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]"));

        for (int j = 0; j < countries1.size(); j++) {
            System.out.println(countries1.get(j).getText());
        }

        for (WebElement country: countries1) {
            System.out.println(country.getText());
        }
    }

    @Test
    public void radiobutton1(){
//        WebDriverManager.firefoxdriver().setup();
//        driver  = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
       List<WebElement> seDropDown = select.getOptions();
//        for (WebElement se: seDropDown) {
      System.out.println(seDropDown);
        }


//    @Test
//    public void openWindow(){
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
////        driver.switchTo().newWindow();
//        System.out.println (driver.getTitle());



    @AfterTest
    public void tearDown () {
    driver.quit();
    }
}