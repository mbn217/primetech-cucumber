package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "src/test/resources/features/Login_saucedemo_outline.feature" ,
                glue = {"stepdefinitions", "hooks"},
                plugin = {"pretty" , "html:target/primetech-report.html",
                        "json:target/primetech-report.json"}

                //tags = "@smoke and @regression" will execute any feature or scenario that has both tags at the same time
                //tags = "@smoke or @regression" // will execute any feature or scenario that has either of these two tags
                //tags = "(@smoke) and (not @saucedemo)"
                //tags= "@crater"



                //strict was decommissioned from 6.0.0 but it forces the test to fail is the step is not defined in the step definition
                //monochrome = true -- is to prettify the console output but it was deprecated in version 7.0
                )
public class TestRunner {

}


/**
 * This class will allow us to execute and run our feature files/step definitions
 */
