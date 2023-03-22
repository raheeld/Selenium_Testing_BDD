package stepDefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class stepForLoginPage {
    WebDriver driver;
    @Given("user on login page")
    public void user_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.statefarm.com");
    }

    @Given("user enter on username")
    public void user_enter_on_username() {
        driver.findElement(By.cssSelector("button[class='-oneX-header-top-menu-btn'] span"));
    }

    @Given("user enter password")
    public void user_enter_password() {

    }

    @Then("user land on home page")
    public void user_land_on_home_page() {

    }
}
