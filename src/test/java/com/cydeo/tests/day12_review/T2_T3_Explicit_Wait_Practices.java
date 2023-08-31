package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_T3_Explicit_Wait_Practices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
       dynamicControlsPage=new DynamicControlsPage();
    }
    @Test
    public void t2_remove_checkBix_test(){
        //TC #2: Explicit wait practice


        //3- Click to “Remove” button

        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        //Create the object of WebDriverWait class and set up the constructor
        //WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

        //Use the 'wait' object with the proper syntax to create explicit wait conditions

        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //Using the custom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        try{
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            //e.printStackTrace();
            Assert.assertTrue(true);
        }


        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itIsGoneMessage.isDisplayed());




    }

    @Test
    public void t3_enable_input_box_test(){
        //TC #3: Explicit wait practice
        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();

        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled(),"Input box is not enabled!");

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itIsGoneMessage.isDisplayed(),"Message is not displayed!");

        String actualMessageText=dynamicControlsPage.itIsGoneMessage.getText();
        Assert.assertTrue(actualMessageText.equals("It's enabled!"));



    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/dynamic_controls



//NOTE: FOLLOW POM


}





//NOTE: FOLLOW POM