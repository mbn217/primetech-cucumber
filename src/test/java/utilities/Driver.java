package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;
    static ChromeOptions options = new ChromeOptions();
    private Driver(){


    }

    /**
     * Static method to get the single instance of WebDriver
     */

    public static WebDriver getDriver(){
        //Read the browser type you want to launch from properties file
        String browserType = ConfigurationReader.getPropertyValue("browserType");

        if(driver == null){//if the driver is null, then create the driver
            //Create the driver based on the browser type
            switch (browserType){
                case "chrome"://if the browser type is chrome
                    driver = new ChromeDriver(); //Instantiate only once
                    break;
                case "firefox"://if the browser type is firefox
                    driver = new FirefoxDriver();
                    break;
                case "edge": //if the browser type is edge
                    driver = new EdgeDriver();
                    break;
                case "safari": //if the browser type is safari
                    driver = new SafariDriver();
                    break;
                case "chrome-headless": //if the browser type is chrome-headless
                    options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox-headless": //if the browser type is firefox-headless
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    driver = new ChromeDriver(options);
            }

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
