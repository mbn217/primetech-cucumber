package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Dashboard;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class AddItem_StepDef {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    ItemsPage itemsPage = new ItemsPage();

    @Given("user is logged in successfully")
    public void user_is_successfully_logged_in() throws InterruptedException {
        //navigate to the crater app login page
        driver.get("http://crater.primetech-apps.com/login");
        SeleniumUtils.sendkeysWithActionsClass(loginPage.emailInput ,"entityadmin@primetechschool.com");
        Thread.sleep(2000);
        SeleniumUtils.sendkeysWithActionsClass(loginPage.passwordInput,"primetech@school");
        Thread.sleep(2000);
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }

    @And("the user is on the items page")
    public void the_user_is_on_the_items_page() {
        dashboard.itemsTab.click();
    }
    @When("the user clicks on the Add Item button")
    public void the_user_clicks_on_the_add_item_button() {
        itemsPage.addItemButton.click();
    }
    @And("the user enters the item name")
    public void the_user_enters_the_item_name() {
        itemsPage.nameInput.sendKeys("Item 1");
    }
    @And("the user enters the item description")
    public void the_user_enters_the_item_description() {
        itemsPage.descriptionInput.sendKeys("Item 1 description");
    }
    @And("the user enters the item price {string}")
    public void the_user_enters_the_item_price(String itemPrice) {
        itemsPage.priceInput.sendKeys(itemPrice);
    }
    @And("the user selects the item unit {string}")
    public void the_user_selects_the_item_unit(String itemUnit) {
        itemsPage.unitSelect.sendKeys(itemUnit);
        itemsPage.gramsOption.click();

    }
    @And("the user clicks on the Save Item button")
    public void the_user_clicks_on_the_save_item_button() {
        itemsPage.saveItemButton.click();
    }
    @Then("the item should be listed in the items table")
    public void the_item_should_be_listed_in_the_items_table() throws InterruptedException {
        Thread.sleep(4000);
        //verify the item is listed in the table
        String itemName = "Item 1";
        Assert.assertTrue(SeleniumUtils.isItemInTable(itemsPage.itemsTab , itemName));

    }

}
