package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "@target/failed_scenarios.txt" , // path to failed the feature files
                glue = "stepdefinitions",  // path to the step definition files
                plugin = {"pretty" , "html:target/primetech-report.html",
                        "json:target/primetech-report.json"}




                //strict was decommissioned from 7.0.0 but it forces the test to fail is the step is not defined in the step definition
                //monochrome = true -- is to prettify the console output
                )
public class FailedTestRunner {

}


/**
 * This class will allow us to execute and run our feature files/step definitions
 */
