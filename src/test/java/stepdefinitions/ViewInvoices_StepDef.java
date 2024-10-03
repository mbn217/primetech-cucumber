package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Dashboard;
import pages.InvoicesPage;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class ViewInvoices_StepDef {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    InvoicesPage invoicesPage = new InvoicesPage();


    @And("the user is on the invoices page")
    public void the_user_is_on_the_invoices_page() {
        dashboard.invoicesTab.click();
    }
    @Then("the Invoices label should be displayed")
    public void the_invoices_label_should_be_displayed() throws InterruptedException {
        Assert.assertTrue(invoicesPage.invoicesLabel.isDisplayed());
    }
    @And("the user clicks on a specific invoice")
    public void the_user_clicks_on_a_specific_invoice() throws InterruptedException {
        Thread.sleep(7000);
        invoicesPage.firstInvoice.click();
    }
    @Then("the invoice details should be displayed on the right side of the screen")
    public void the_invoice_details_should_be_displayed_on_the_right_side_of_the_screen() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(invoicesPage.invoiceDetails.isDisplayed());
    }

}
