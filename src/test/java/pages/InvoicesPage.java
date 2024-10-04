package pages;

import org.openqa.selenium.Alert;
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

    @FindBy(xpath = "(//a[contains(@href,'/admin/invoices/')])[1]/button")
    public WebElement addNewInvoiceButton;

    @FindBy(xpath = "//h3[.='Invoices']")
    public WebElement invoicesLabel;


    @FindBy(xpath = "(//a[contains(@href,'/admin/invoices/')])[2]")//first invoice
    public WebElement firstInvoice;

    @FindBy(xpath = "//h3[starts-with(.,'INV-')]")
    public WebElement invoiceDetails;

    @FindBy(xpath = "//label[contains(.,'New Customer')]")
    public WebElement newCustomerSelect;

    @FindBy(xpath = "//div[@title='Garfield']")
    public WebElement customerToSelect;

    @FindBy(xpath = "//div[@class='flex relative rounded-md shadow-sm font-base']//input")
    public WebElement exchangeRateInput;

    @FindBy(xpath = "//table[@class='w-full']//input[@type='text']")
    public WebElement itemSelect;

    @FindBy(xpath = "//table[@class='w-full']//li[1]")
    public WebElement itemToSelect;

    @FindBy(xpath = "//table[@class='w-full']//input[@type='number']")
    public WebElement quantityInput;

    @FindBy(xpath = "//table[@class='w-full']//input[@type='tel']")
    public WebElement priceInput;

    @FindBy(xpath = "//div[@class='flex flex-wrap justify-between']//button")
    public WebElement saveInvoiceButton;






    //************ Methods *************


}
