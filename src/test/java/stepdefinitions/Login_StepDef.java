package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Driver;

public class Login_StepDef {
    WebDriver driver = Driver.getDriver();
    @Given("User is navigated to saucedemo.com")
    public void user_is_navigated_to_saucedemo_com() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("User enters {string} in the username field")
    public void user_enters_in_the_username_field(String usernameValue) {
        System.out.println("This is the value of username : " + usernameValue);
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys(usernameValue);
    }
    @And("User enters {string} in the password field")
    public void user_enters_in_the_password_field(String passValue) {
        System.out.println("This is the value of pass : " + passValue);
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys(passValue);

    }
    @And("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        WebElement button  = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

    }

    @Then("User is able to verify the {string} label is displayed")
    public void user_is_able_to_verify_the_label_is_displayed(String expectedProductLabel) {
        WebElement actualElement = driver.findElement(By.xpath("//span[text()='Products']"));//coming from UI
        String actualLabel = actualElement.getText();
        boolean productLabelIsDisplayed = actualElement.isDisplayed(); //if its true means displauyed , false means not displayed
//        if (productLabel.equals(actualElement.getText())){
//            System.out.println("they are equal");
//        }else{
//            System.out.println("not equal");
//        }
        //Assertion --> a way for you to verify if expected value is equal to actual value

        Assert.assertEquals(expectedProductLabel ,actualLabel );
        Assert.assertTrue(productLabelIsDisplayed);

    }



}
