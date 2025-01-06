package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashboardPage {
    private static final Logger logger = LogManager.getLogger(DashboardPage.class);

    //Constructor for the page
    public DashboardPage(){
        logger.info("Initializing the Dashboard page");
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************
    @FindBy(xpath = "//a[@href='/admin/items']")
     public WebElement itemsTab;

    @FindBy(xpath = "//a[@href='/admin/invoices']")
    public WebElement invoicesTab;




}
