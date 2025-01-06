package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DashboardPage;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {
    private static final Logger logger = LogManager.getLogger(SeleniumUtils.class);


    /**
     * This method will select from a Drop down using selectByValue from Selenium
     * @param element the Select element with select tag from the html
     * @param valueToBeSelected the option value that we want to select
     */
    public static void selectByValueFromDropDown(WebElement element, String valueToBeSelected){
        logger.info("Selecting the value: " + valueToBeSelected + " from the dropdown");
        //create an instance of the Select class
        Select select = new Select(element);
        //select the option by value
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
        logger.info("Dragging the element from source to target");
        //create an instance of the Actions class
        Actions actions = new Actions(driver);
        //drag and drop the source element to the target element
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    /**
     * This method will send keys to an element using the JavascriptExecutor
     * @param inputString the input that we want to send to the element
     * @param element the element that we want to send keys to
     */
    public static void sendKeysUsingJavaScriptExecutor(String inputString , WebElement element){
        logger.info("Sending keys to the element using JavascriptExecutor");
        //create an instance of the JavascriptExecutor
        JavascriptExecutor js  = (JavascriptExecutor) Driver.getDriver();
        //send the keys to the element
        js.executeScript("arguments[0].setAttribute('value', '" + inputString +"')", element);
    }

    /**
     * This method will send keys to an element using the Actions class
     * @param element the element that we want to send keys to
     * @param input the input that we want to send to the element
     */
    public static void sendkeysWithActionsClass(WebElement element , String input){
        logger.info("Sending keys to the element using Actions class");
        //create an instance of the Actions class
        Actions actions = new Actions(Driver.getDriver());
        //send the keys to the element
        actions.sendKeys(element , input).build().perform();
    }

    /**
     * This method will check if the item is in the table
     * @param elementList the list of elements that are in the table
     * @param itemNameToSearchFor the item name that we are looking for
     * @return true if the item is in the table, false if the item is not in the table
     */
    public static boolean isItemInTable(List<WebElement> elementList , String itemNameToSearchFor){
        logger.info("Checking if the item is in the table");
        //loop through the list of elements
        for(WebElement item : elementList){
            //if the item text is equal to the item name that we are looking for
            if(item.getText().equals(itemNameToSearchFor)){
                //return true if the item is in the table
                return true;
            }
        }
        //if the item is not in the table
        return  false;
    }


    public List<String> getAllRecordsFromTable(List<WebElement> listOfTableDataElements){
        logger.info("Getting all records from the table");
        List<String> records = new ArrayList<>();
        List<WebElement> listOfRecordsInTable = listOfTableDataElements;
        for (WebElement element : listOfRecordsInTable){
            records.add(element.getText());
        }
        return records;
    }



}
