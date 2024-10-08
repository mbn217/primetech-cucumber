package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InvoicesPage {
    //Constructor for the page
    public InvoicesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************
    @FindBy(xpath = "//h3[text()='Invoices']") //or you can do like this //h3[.='Invoices']
     public WebElement invoicesLabel;

    @FindBy(xpath = "(//a[contains(@href,'/admin/invoices/')])[2]")
    public WebElement firstInvoice;

    @FindBy(xpath = "//h3")
    public WebElement invoiceDetailsLabel;



}
