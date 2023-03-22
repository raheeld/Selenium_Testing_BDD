package step;

import driver.WebDriverInitiate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class stepDefinationRahulShettyPractice {
    WebDriver driver = null;
    WebDriverInitiate wd = new WebDriverInitiate();

    @Before
    public void browserSetup() {
        driver = wd.initiateWebDriver();
    };


    public

    @After
    public void tearDown(){
        driver.close();

    }

}
