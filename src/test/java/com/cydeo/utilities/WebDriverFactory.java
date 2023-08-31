package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    // TASK: NEW METHOD CREATION
    // Method name : getDriver
    // Static method
    // Accepts String arg: browserType

    public static WebDriver getDriver(String browser){
        //- This arg will determine what type of browser is opened
        // - if "chrome" passed --> it will open Chrome browser
        // - if "firefox" passed --> it will open firefox browser
        //RETURN TYPE: "WebDriver"

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
           return new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
           return new FirefoxDriver();

        }else{
            System.out.println("Given String does not represent any browser.");
            System.out.println("Either that browser does not exit or not currently supported.");
            System.out.println("driver=null");
            return null;
        }


    }





}


