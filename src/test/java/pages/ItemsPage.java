package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ItemsPage {

    //Constructor for the page
    public ItemsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************

    @FindBy(xpath = "//button[@class='inline-flex whitespace-nowrap items-center border font-medium focus:outline-none focus:ring-2 focus:ring-offset-2 px-4 py-2 text-sm leading-5 rounded-md border-transparent shadow-sm text-white bg-primary-600 hover:bg-primary-700 focus:ring-primary-500']")
    public WebElement addItemButton;


    @FindBy(xpath = "(//input[@type='text'])[2]")//This xpath can break because we use index , but its fine for now to move on
    public WebElement nameInput;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement priceInput;

    @FindBy(xpath = "(//input[@type='text'])[3]")//This xpath can break because we use index , but its fine for now to move on
    public WebElement unitSelect;

    @FindBy(xpath = "//span[.='grams']")
    public WebElement gramsOption;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveItemButton;

    @FindBy(xpath = "//a[contains(@href,'/admin/items')]")
    public List<WebElement> itemsTab;



    //************ Methods *************


}
