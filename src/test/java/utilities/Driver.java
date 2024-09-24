package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }

    /**
     * Static method to get the single instance of WebDriver
     */

    public static WebDriver getDriver(){
        System.out.println("Getting an instance of the driver");
        if(driver == null){
            driver = new ChromeDriver(); //Instantiate only once
        }
        return driver;// this is an existing one that is not null ( driver this is alive)
    }

    /**
     * This method will quit the driver and set it to null
     */
    public static void closeDriver(){
        //We Check if the driver still alive then
        //quit the driver and set the driver object to null
        System.out.println("Closing the driver");
        if(driver != null){
            driver.quit();
            driver = null;
        }


    }



}
