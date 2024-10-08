package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.InvoicesPage;
import utilities.Driver;

public class ViewInvoices_StepDef {
    WebDriver driver = Driver.getDriver();
    DashboardPage dashboardPage = new DashboardPage();
    InvoicesPage invoicesPage = new InvoicesPage();

    @And("the user is on the invoices page")
    public void the_user_is_on_the_invoices_page() {
        //user gets into the invoices page by clickin on the invoice hyperlink from left tab
        dashboardPage.invoicesTab.click();
    }
    @Then("the Invoices label should be displayed")
    public void the_invoices_label_should_be_displayed() {
        Assert.assertTrue(invoicesPage.invoicesLabel.isDisplayed());
    }
    @Then("the user clicks on a specific invoice")
    public void the_user_clicks_on_a_specific_invoice() {
        invoicesPage.firstInvoice.click();
    }
    @Then("the invoice details should be displayed on the right side of the screen")
    public void the_invoice_details_should_be_displayed_on_the_right_side_of_the_screen() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(invoicesPage.invoiceDetailsLabel.isDisplayed());
    }

}
