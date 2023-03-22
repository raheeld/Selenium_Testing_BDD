package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/loginPage.feature",
        glue = "stepDefinitions"
        )
public class runnerLoginPage  extends AbstractTestNGCucumberTests {

}
