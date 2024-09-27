package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    //Constructor for the page
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //************ ELEMENTS *************

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;


    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login' and @type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='These credentials do not match our records.']")
    public WebElement loginErrorMessageLabel;




}
