package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAccess_StepDef {

    @Given("user is navigated to Crater login page")
    public void user_is_navigated_to_crater_login_page() {

    }
    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {

    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {

    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

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
