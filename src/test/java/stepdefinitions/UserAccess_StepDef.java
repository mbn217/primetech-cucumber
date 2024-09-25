package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SettingsPage;
import utilities.Driver;

import java.time.Duration;

public class UserAccess_StepDef {
    WebDriver driver = Driver.getDriver();//declaring the driver as global because it will be used across all the class
    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();
    @Given("user is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() {
        driver.get("http://crater.primetech-apps.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        loginPage.emailInput.sendKeys("entityadmin@primetechschool.com");
        loginPage.passwordInput.sendKeys("primetech@school");
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        //verify using the url that is different from login
        String loginUrl = "http://crater.primetech-apps.com/login";
        String afterLoginUrl = driver.getCurrentUrl();
        System.out.println("Current URL after loggin in is : " + afterLoginUrl);
        Assert.assertNotEquals(loginUrl , afterLoginUrl);
        //verify using the setting label is displayed
        Assert.assertTrue(settingsPage.settingsLabel.isDisplayed());

    }



    // Second scenario

    @When("user enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {

    }
    @Then("user should see an error message {string} displayed")
    public void user_should_see_an_error_message_displayed(String string) {

    }
    @And("user should not be logged in")
    public void user_should_not_be_logged_in() {

    }




}
