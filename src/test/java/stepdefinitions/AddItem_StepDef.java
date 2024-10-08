package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AddItem_StepDef {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ItemsPage itemsPage = new ItemsPage();

    @Given("user is logged in successfully")
    public void user_is_logged_in_successfully() throws InterruptedException {
        //navigate to crater, login , enter user/pass/click on login
        driver.get("http://crater.primetech-apps.com/login");
        SeleniumUtils.sendkeysWithActionsClass(loginPage.emailInput ,"entityadmin@primetechschool.com");
        Thread.sleep(2000);
        SeleniumUtils.sendkeysWithActionsClass(loginPage.passwordInput,"primetech@school");
        Thread.sleep(2000);
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }
    @And("the user is on the item page")
    public void the_user_is_on_the_item_page() {
        dashboardPage.itemsTab.click();
    }
    @When("the user clicks on the Add Item button")
    public void the_user_clicks_on_the_add_item_button() {
        itemsPage.addItemButton.click();
    }
    @And("the user enters the item name")
    public void the_user_enters_the_item_name() {
        itemsPage.nameInput.sendKeys("Test Case 1");
    }
    @And("the user enters the item description")
    public void the_user_enters_the_item_description() {
        itemsPage.descriptionInput.sendKeys("Description for test case 1");
    }
    @And("the user enters the item price {string}")
    public void the_user_enters_the_item_price(String itemPrice) {
        itemsPage.priceInput.sendKeys(itemPrice);
    }
    @And("the user enters the item unit {string}")
    public void the_user_enters_the_item_unit(String itemUnit) {
        itemsPage.unitSelect.sendKeys(itemUnit);
        //we will be back here
        itemsPage.unitSelect.sendKeys(Keys.ENTER);

    }
    @And("the user clicks on the Save Item button")
    public void the_user_clicks_on_the_save_item_button() {
        itemsPage.saveItemButton.click();
    }
    @Then("the item should be listed in the items table")
    public void the_item_should_be_listed_in_the_items_table() throws InterruptedException {
        Thread.sleep(4000);
        //verify the item is listed in the table
        String itemName = "Test Case 1";
        Assert.assertTrue(SeleniumUtils.isItemInTable(itemsPage.itemsList , itemName));


    }

}
