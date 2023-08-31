package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object

    private Driver(){}
    /*
    We make the WebDriver private, because we want to close ACCESS FROM OUTSIDE THE CLASS.
    We are making it static, because we will use it in a static method
    */

    private static WebDriver driver;

    public static WebDriver getDriver(){

        /*
        Create a reusable utility method which will return the same driver instance once we call it.
        -If an instance doesn't exist, it will create first, and then it will always return same instance
        */

        if(driver==null){//Singleton pattern:The pattern is useful when exactly one object is needed to coordinate actions across a system.
            /*
            We will read our browser type from configuration properties file. This way, we can control which browser is opened from outside our code.

             */
            String browserType= ConfigurationReader.getProperty("browser");
            /*

            Depending on the browserType returned from the configuration.properties switch statement will determine the "case", and open the matching browser.
             */

            switch(browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }
        }

        return driver;
    }

    public static void closeDriver(){

        if(driver!=null){//This line will terminate the currently existing driver completely.It will be non-Existing
            driver.quit();
            //We assign the value back to null so that Singleton can create a newer one if needed.
            driver=null;
        }



    }



}
/*
Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
 */

//We were having hard time passing around the same driver instance in different classes and packages