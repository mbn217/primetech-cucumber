package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DashboardPage {
    //Constructor for the page
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************
    @FindBy(xpath = "//a[@href='/admin/items']")
     public WebElement itemsTab;

    @FindBy(xpath = "//a[@href='/admin/invoices']")
    public WebElement invoicesTab;




}
