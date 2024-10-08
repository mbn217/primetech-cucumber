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

    @FindBy(xpath = "//button[text()=' New Invoice']")
    public WebElement addNewInvoiceButton;

    @FindBy(xpath = "//label[text()='New Customer ']")
    public WebElement newCustomerSelect;

    @FindBy(xpath = "//div[@class='flex relative rounded-md shadow-sm font-base']//input")
    public WebElement exchangeRateInput;

    @FindBy(xpath = "//table[@class='w-full']//input[@type='text']")
    public WebElement newItemSelect;

    @FindBy(xpath = "//table[@class='w-full']//input[@type='number']")
    public WebElement quantityInput;

    @FindBy(xpath = "//table[@class='w-full']//input[@type='tel']")
    public WebElement priceInput;

    @FindBy(xpath = "//button[text()=' Save Invoice']")
    public WebElement saveInvoiceButton;






}
