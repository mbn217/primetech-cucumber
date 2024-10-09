package stepdefinitions;

import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.InvoicesPage;

public class AddNewInvoice_StepDef {
    InvoicesPage invoicesPage = new InvoicesPage();
    String firstInvoice;
    @When("the user clicks on the Add New Invoice button")
    public void the_user_clicks_on_the_add_new_invoice_button() {
        firstInvoice = invoicesPage.firstInvoice.getText().split("-")[1]; //exp: INV-00040
        System.out.println(firstInvoice);
        invoicesPage.addNewInvoiceButton.click();
    }
    @And("the user selects a client from the New Customer dropdown")
    public void the_user_selects_a_client_from_the_new_customer_dropdown() throws InterruptedException {
        invoicesPage.selectNewCustomer.click();
        invoicesPage.customerInputField.sendKeys("Garfield");
        invoicesPage.firstCustomerInList.click();
        Thread.sleep(6000);
    }

    @When("the user select the first item")
    public void the_user_select_the_first_item() {
        invoicesPage.selectNewItemDropdown.click();
        invoicesPage.firstItemInList.click();
    }
    @And("the user add exchange rate {string}")
    public void the_user_add_exchange_rate(String rateInput) {
        invoicesPage.exchangeRateInput.clear();
        invoicesPage.exchangeRateInput.sendKeys(rateInput);
    }
    @And("the user enters the price {string}")
    public void the_user_enters_the_price(String priceInput) {
        invoicesPage.priceInput.sendKeys(priceInput);

    }
    @And("the user clicks on the Save Invoice button")
    public void the_user_clicks_on_the_save_invoice_button() throws InterruptedException {
        invoicesPage.saveInvoiceButton.click();
        Thread.sleep(6000);
    }
    @Then("the invoice should be saved and listed in the invoices list")
    public void the_invoice_should_be_saved_and_listed_in_the_invoices_list() {
        //grab the intitial invoice number before creating new invoice , save it into variable
        // after creating the new invoice we get the new invoice number and verify that the number is
        // equal to old number +1
        int firstInvoiceNumber = Integer.parseInt(firstInvoice);
        String newInvoiceNumber = invoicesPage.newInvoiceNumber.getText().split("-")[1]; //INV-00041
        int newInvoiceNumberInt = Integer.parseInt(newInvoiceNumber);

        Assert.assertTrue(newInvoiceNumberInt > firstInvoiceNumber);

    }

//    @And("the invoice total should match the items and their quantities")
//    public void the_invoice_total_should_match_the_items_and_their_quantities() {
//        //todo as HW
//    }

}
