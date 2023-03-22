package step;

import driver.WebDriverInitiate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.ByteArrayInputStream;

public class stepDefinationHomepage {

    WebDriver driver = null;
    WebDriverInitiate wd = new WebDriverInitiate();

    @Before
    public void browserSetup() {
        WebDriverInitiate wd = new WebDriverInitiate();
        driver = wd.initiateWebDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }



    @When("user is on login page")
    public void user_is_on_login_page() {
        driver.get("http://example.testproject.io/web/");
        String expectedTitle = "TestProject Demo";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("user enter {string} and {string}")
    public void user_enter_username_and_password(String username, String password) {
        driver.findElement(By.cssSelector("#name")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.cssSelector("#login")).click();

    }

    @Then("user verifies Welcome message with {string}")
    public void user_verifies_welcome_message(String username) throws InterruptedException {
        String actualGreetingMsg = driver.findElement(By.cssSelector("#greetings")).getText();
        String expectedGreetingMsg = "Hello " + username + ", let\'s complete the test form:";
        Assert.assertEquals(actualGreetingMsg, expectedGreetingMsg);
        driver.close();
    }

    @When("user selects country {string} from dropdown")
    public void user_selects_country_from_dropdown(String country) {
        Select select = new Select(driver.findElement(By.cssSelector("#country")));
        select.selectByVisibleText(country);
    }
    @When("user enters {string} by {string}")
    public void user_enters(String text, String selector) {
        driver.findElement(By.cssSelector(selector)).sendKeys(text);
    }
    @Then("user clicks save button and verify message")
    public void user_clicks_save_button_and_verify_message() {
        driver.findElement(By.cssSelector("#save")).click();
        String actualMessage = driver.findElement(By.cssSelector(".tp-saved")).getText();
        Assert.assertEquals(actualMessage, "Saved");
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(1000);
        if(scenario.isFailed()) {
            byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(screenshot));
        }
        driver.quit();
    }
}
