package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ItemsPage {
    //Constructor for the page
    public ItemsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************
    @FindBy(xpath = "")
    public WebElement addItemButton;

    @FindBy(xpath = "")
    public WebElement nameInput;

    @FindBy(xpath = "")
    public WebElement priceInput;

    @FindBy(xpath = "")
    public WebElement unitSelect;

    @FindBy(xpath = "")
    public WebElement descriptionInput;

    @FindBy(xpath = "")
    public WebElement saveItemButton;






}
