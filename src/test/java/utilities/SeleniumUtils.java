package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
     * This method will send keys to an element using the JavascriptExecutor
     * @param inputString the input that we want to send to the element
     * @param element the element that we want to send keys to
     */
    public static void sendKeysUsingJavaScriptExecutor(String inputString , WebElement element){
        JavascriptExecutor js  = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + inputString +"')", element);
    }

    /**
     * This method will send keys to an element using the Actions class
     * @param element the element that we want to send keys to
     * @param input the input that we want to send to the element
     */
    public static void sendkeysWithActionsClass(WebElement element , String input){
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(element , input).build().perform();
    }


    /**
     * This method will check if the item is in the table
     * @param elementList the list of elements that are in the table
     * @param itemName the name of the item that we want to check if it is in the table
     * @return true if the item is in the table, false if the item is not in the table
     */
    public static boolean isItemInTable(List<WebElement> elementList, String itemName) {
        for (WebElement item : elementList) {
            if (item.getText().equals(itemName)) {
                return true;
            }
        }
        return false;
    }
}
