package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form(){
        //TC#1: Registration form confirmation
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form

        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.URL"));

        //3. Enter first name
        WebElement inputFirstName=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys("John");

        //4. Enter last name
        WebElement inputLastName=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys("Doe");

        //5. Enter username
        WebElement inputUserName=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUserName.sendKeys("JenDoe58");


        //6. Enter email address
        WebElement inputEmail=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("johndoe@example.com");

        //7. Enter password
        WebElement inputPassword=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("12345678");

        //8. Enter phone number
        WebElement inputPhone=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys("111-222-3333");

        //9. Select a gender from radio buttons
        WebElement radioButtonForFemale=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioButtonForFemale.click();

        //10. Enter date of birth
        WebElement birthDay=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthDay.sendKeys("01/12/1996");

        //11. Select Department/Office
        Select departmentDropDown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropDown.selectByVisibleText("Department of Engineering");

        //12. Select Job Title
        Select jobTitleDropdown=new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitleDropdown.selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        WebElement javaCheckBox=Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckBox.click();

        //14. Click to sign up button
        WebElement signUpButton=Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement successMessage=Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(successMessage.isDisplayed());

        Driver.closeDriver();
















    }




}













