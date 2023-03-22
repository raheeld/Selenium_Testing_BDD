package stepDefinitions;


import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class stepForLoginPage {
        WebDriver driver = null;

    public void waitUntilVisible(WebDriver driver, By locator) {
        int waitInSeconds = 10;
        Duration durationInSeconds = Duration.ofSeconds(waitInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Given("user on login page")
    public void user_on_login_page() throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get("https://www.statefarm.com");
        }

    @And("user click on \"Auto + Renters\"")
    public void user_click_on_Auto_Renters() throws InterruptedException {
        Select se = new Select(driver.findElement(By.cssSelector("#popDropdown")));
        se.selectByVisibleText("    Auto + Renters");

         }
    @And("user enter ZIPCODE \"19056\"")
    public void user_enter_ZIPCODE() throws InterruptedException {

        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("19056");
    }

    @And("user click on Start a quote button")
    public void user_click_on_Start_a_quote_button() {
        driver.findElement(By.xpath("//button[@id='quote-main-zip-btn']")).click();
            }

    @Then("user land on Welcome page")
    public void user_land_on_Welcom_page() throws InterruptedException {
        waitUntilVisible(driver,By.xpath("//div[@class='sub-header']"));
        String pageValidation =  driver.findElement(By.xpath("//div[@class='sub-header']")).getText();
        String expectedPageText = "Trust us. This won't take long.";
        Assert.assertEquals(pageValidation,expectedPageText);

    }
}
