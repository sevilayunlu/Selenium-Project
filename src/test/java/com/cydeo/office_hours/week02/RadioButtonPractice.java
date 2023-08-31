package com.cydeo.office_hours.week02;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPractice extends TestBase {

    @Test
    //As a user I should be able to select my favorite color and sport
    // 1-open a Chrome browser
    // 2-goto https://practice.cydeo.com/
    public void radio_button_test(){
        Driver.getDriver().get("https://practice.cydeo.com/");

        //  3-click Radio Buttons
        BrowserUtils.clickOption(Driver.getDriver(), "Radio Buttons");

        //  4-verify title contains Radio buttons
        //Assert.assertEquals(Driver.getDriver().getTitle(),"Radio Buttons");
        BrowserUtils.verifyTitle(Driver.getDriver(),"Radio buttons");

        //  5-select the favorite color as Red
        WebElement redButton=Driver.getDriver().findElement(By.cssSelector("#red"));
        redButton.click();

        //  6-verify the Red is selected
        Assert.assertTrue(redButton.isSelected());

        //  7-select the favorite sport as Football
        WebElement footballButton=Driver.getDriver().findElement(By.id("football"));
        footballButton.click();

        //  8-verify the Football is select
        Assert.assertTrue(footballButton.isSelected());



    }




}






