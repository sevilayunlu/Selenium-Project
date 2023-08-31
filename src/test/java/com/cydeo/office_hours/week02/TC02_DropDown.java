package com.cydeo.office_hours.week02;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_DropDown extends TestBase {

    @Test
    public void dropdown_test() {
        //Dropdown
        // TC02 As a user I should be able to see default option as Select a State
        //  1-open a Chrome browser
        //  2-go to https://practice.cydeo.com/dropdown
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        // 3-verify default option Select a State
        Select selectState = new Select(Driver.getDriver().findElement(By.id("state")));
        WebElement defaultOption = selectState.getFirstSelectedOption();

        String actualDefaultOption = defaultOption.getText();
        String expectedDEfaultOption = "Select a State";

        Assert.assertEquals(actualDefaultOption, expectedDEfaultOption, "Default option verification failed!");

    }

    @Test
    public void dropdown_test2(){
        //As a user I should be able to select Alabama
        //1-open a Chrome browser
        //2-goto https://practice.cydeo.com/dropdown
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        //3-select Alabama
        Select selectState = new Select(Driver.getDriver().findElement(By.id("state")));
        //selectState.selectByIndex(1);
        //selectState.selectByValue("AL");
        selectState.selectByVisibleText("Alabama");

        WebElement currentSelectedOption=selectState.getFirstSelectedOption();

        String actualSelectedOption=currentSelectedOption.getText();
        String expectedSelectedOption="Alabama";
        Assert.assertTrue(actualSelectedOption.equals(expectedSelectedOption));






    }


}




//  4-verify Alabama is selected