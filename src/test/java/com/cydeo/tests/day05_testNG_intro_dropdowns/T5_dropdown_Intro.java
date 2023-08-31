package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_dropdown_Intro {

    WebDriver driver= WebDriverFactory.getDriver("chrome");

    @BeforeMethod

    public void setUpMethod() {
        //TC#5: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void simple_dropdowns_tests(){
        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        //Locating the dropdown as a webElement
        WebElement simpleDropDown=driver.findElement(By.xpath("//select[@id='dropdown']"));

        //Creating Select class object, and passing the dropdown web element into the constructor
        Select select=new Select(simpleDropDown);
        String expectedDefaultValue="Please select an option";

        //Actual
        String actualDefaultValue=select.getFirstSelectedOption().getText();

        //Assert
        Assert.assertEquals(actualDefaultValue,expectedDefaultValue);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateSelection=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Assert.assertEquals(stateSelection.getFirstSelectedOption().getText(),"Select a State");






    }
}


