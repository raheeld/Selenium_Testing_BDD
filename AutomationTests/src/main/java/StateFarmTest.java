import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StateFarmTest {

    WebDriver driver = null;
    String expectedZipCodeErrorMessage = "Enter a valid 5-digit ZIP Code.";

    @Test
    public void testJava() {
        System.out.println("Hello World");
    }

    @Test
    public void stateFarmHomePage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();// Gecko Driver, IE iedriver, safari driver
        driver.get("https://www.google.com");
        driver.findElement(By.id("quote-main-zip-code-input")).sendKeys("19047");
        int lengthOfZipCode = driver.findElement(By.id("quote-main-zip-code-input")).getAttribute("value").length();
        System.out.println(lengthOfZipCode);
        Assert.assertEquals(lengthOfZipCode, 5);

    }
}
