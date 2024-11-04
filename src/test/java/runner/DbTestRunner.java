package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//You telling junit to run the TestRunner class as a cucumber test
@CucumberOptions(features = "src/test/resources/features/" ,
                glue = {"stepdefinitions", "hooks"},
                plugin = {"pretty" , "html:target/primetech-report.html",
                        "json:target/primetech-report.json",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"},// to generate a txt file with failed scenarios

                tags= "@db-test"
                )
public class DbTestRunner {

}


/**
 * This class will allow us to execute and run our feature files/step definitions
 */
