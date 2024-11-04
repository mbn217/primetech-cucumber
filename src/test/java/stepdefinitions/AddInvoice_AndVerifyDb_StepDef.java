package stepdefinitions;

import io.cucumber.java.en.And;

import java.util.List;

import org.junit.Assert;
import utilities.DBUtils;
public class AddInvoice_AndVerifyDb_StepDef {


    @And("the invoice should be added to the database")
    public void the_invoice_should_be_added_to_the_database() {
        String query = "SELECT * from invoices order by created_at desc;";
        List<String> lastInvoice = DBUtils.selectRecord(query);
        System.out.println("Last invoice in the database: " + lastInvoice);
        Assert.assertTrue(lastInvoice.get(5).startsWith("INV"));


    }


}
