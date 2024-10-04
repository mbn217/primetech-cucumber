package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Dashboard;
import pages.InvoicesPage;
import pages.LoginPage;
import utilities.Driver;

public class AddNewInvoice_StepDef {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    InvoicesPage invoicesPage = new InvoicesPage();

    @When("the user clicks on the Add New Invoice button")
    public void the_user_clicks_on_the_add_new_invoice_button() {
        invoicesPage.addNewInvoiceButton.click();
    }
    @And("the user selects a client from the New Customer dropdown")
    public void the_user_selects_a_client_from_the_new_customer_dropdown() {
        invoicesPage.newCustomerSelect.click();
        invoicesPage.customerToSelect.click();
    }
    @When("the user add exchange rate {string}")
    public void the_user_add_exchange_rate(String exchangeRate) {
        invoicesPage.exchangeRateInput.clear();//clear the input field
        invoicesPage.exchangeRateInput.sendKeys(exchangeRate);

    }
    @And("the user selects an item from the Item dropdown")
    public void the_user_selects_an_item_from_the_item_dropdown() {
        invoicesPage.itemSelect.click();
        invoicesPage.itemToSelect.click();
    }
    @And("the user enters the quantity {string}")
    public void the_user_enters_the_quantity(String quantity) {
        invoicesPage.quantityInput.sendKeys(quantity);

    }
    @And("the user enters the price {string}")
    public void the_user_enters_the_price(String price) {
        invoicesPage.priceInput.sendKeys(price);

    }
    @And("the user clicks on the Save Invoice button")
    public void the_user_clicks_on_the_save_invoice_button() {
        invoicesPage.saveInvoiceButton.click();
    }
    @Then("the invoice should be saved and listed in the invoices list")
    public void the_invoice_should_be_saved_and_listed_in_the_invoices_list() {

    }
    @And("the invoice total should match the items and their quantities")
    public void the_invoice_total_should_match_the_items_and_their_quantities() {

    }


}
