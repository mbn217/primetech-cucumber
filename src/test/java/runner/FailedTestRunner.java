package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "@target/failed_scenarios.txt", // path to failed  scenarios in feature files
                glue = "stepdefinitions",
                plugin = {"pretty" , "html:target/primetech-report.html",
                        "json:target/primetech-report.json"}
                )
public class FailedTestRunner {

}


/**
 * This class will allow us to execute and run our feature files/step definitions
 */
