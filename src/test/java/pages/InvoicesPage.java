package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class InvoicesPage {

    //Constructor for the page
    public InvoicesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************

    @FindBy(xpath = "")
    public WebElement addInvoiceButton;

    @FindBy(xpath = "//h3[.='Invoices']")
    public WebElement invoicesLabel;


    @FindBy(xpath = "(//a[contains(@href,'/admin/invoices/')])[2]")//first invoice
    public WebElement firstInvoice;

    @FindBy(xpath = "//h3[starts-with(.,'INV-')]")
    public WebElement invoiceDetails;






    //************ Methods *************


}
