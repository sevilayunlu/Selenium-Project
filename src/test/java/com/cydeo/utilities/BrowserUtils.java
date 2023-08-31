package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {


    public static void sleep(int second) {
      /*
   This method will accept int (in seconds) and execute Thread.sleep method for given duration
   Arg:int
    */
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle) {

    /*

TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
*/
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = " + windowHandles);
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL)) {//we stay on Etsy
                break;
            }

        }

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));


    }

    public static void   verifyTitle(WebDriver driver, String expectedTitle) {
       /*
        TC #3: Create utility method
        1. Create a new method for title verification
        2. Create a method to make title verification logic re-usable
        3. When method is called, it should simply verify expected title with actual
                title
        Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle
       */




        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }

    public static void clickOption(WebDriver driver,String option){

        Driver.getDriver().findElement(By.linkText(option)).click();

    }

    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of WebDriverWait class and set up the constructor
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //Use the 'wait' object with the proper syntax to create explicit wait conditions
        wait.until(ExpectedConditions.invisibilityOf(target));
    }//This method accepts WebElement target, and  waits for that Webelement not to be displayed on the page

    public static void waitForTitleContains(String title){
        //Create the object of WebDriverWait class and set up the constructor
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //Use the 'wait' object with the proper syntax to create explicit wait conditions
        wait.until(ExpectedConditions.titleContains(title));



    }//This method accepts a String title and waits that title to contain  the given String value.

}
/*
This class will be storing only the utility methods that can be used across the project.
 */