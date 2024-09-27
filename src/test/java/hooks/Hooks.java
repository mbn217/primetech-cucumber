package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before
    public void beforeScenario(){
        System.out.println("We are running before each scenario");
    }
    @After
    public void afterScenario(Scenario scenario){
        System.out.println("We are running after each scenario");

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot , "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }
    @BeforeStep
    public void beforeStep(){
        System.out.println("This line will get printed before each step");
    }
    @AfterStep
    public void afterStep(){
        System.out.println("This line will get printed after each step");
    }





}
