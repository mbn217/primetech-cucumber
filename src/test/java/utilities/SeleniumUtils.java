package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils {

    /**
     * This method will select from a Drop down using selectByValue from Selenium
     * @param element the Select element with select tag from the html
     * @param valueToBeSelected the option value that we want to select
     */
    public static void selectByValueFromDropDown(WebElement element, String valueToBeSelected){
        Select select = new Select(element);
        select.selectByValue(valueToBeSelected);
    }

    /**
     * This method will drag and drop an element from a source to a target element using Action class
     * if selenium
     * @param driver the driver object that was instantiated
     * @param sourceElement the source element that we want to drag
     * @param targetElement the target element that we want to drag the source element to
     */
    public static void dragAndDrop(WebDriver driver , WebElement sourceElement, WebElement targetElement ){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    /**
     * This method will send keys to an element using JavaScriptExecutor
     * @param inputString the string that we want to send
     * @param element the element that we want to send the string to
     */
    public static void sendKeysUsingJavaScriptExecutor(String inputString , WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + inputString +"')", element);
    }

    /**
     * This method will send keys to an element using Actions class
     * @param element the element that we want to send the keys to
     * @param input the string that we want to send
     */
    public static void sendkeysWithActionsClass(WebElement element, String input) {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(element, input).build().perform();
    }



    /**
     * This method will click on an element using JavaScriptExecutor
     * @param element the element that we want to click
     */
    public static void clickUsingJavaScriptExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", element);
    }




}
