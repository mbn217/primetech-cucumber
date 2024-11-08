package stepdefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import utilities.DBUtils;

public class AddInvoice_And_Verify_DB_StepDef {

    @And("the invoice should be added to the database")
    public void the_invoice_should_be_added_to_the_database() {
        String query = "select * from CraterDBS.invoices order by invoice_date desc;";
        String invoiceNumber = DBUtils.selectRecord(query , "invoice_number");
        System.out.println("The new invoice number is " + invoiceNumber );

        Assert.assertTrue(invoiceNumber.startsWith("INV-"));
    }
}
