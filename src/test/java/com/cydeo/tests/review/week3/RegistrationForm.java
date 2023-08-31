package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationForm {

    @Test
    public void registrationFormPageTest(){

        // TC#3: Registration Form Page Testing
        // 1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String expectedTitle="Registration Form";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test

    public void registration_Form_Page_Filling_Form(){
        // TC#4: Registration Form Page Filling Form Test
        // 1. Open Chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Enter First name: "John"
        WebElement firstNameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastNameBox=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement userNameBox=driver.findElement(By.xpath("//input[@name='username']"));
        userNameBox.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailBox=driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement passWordBox=driver.findElement(By.xpath("//input[@name='password']"));
        passWordBox.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumberBox=driver.findElement(By.xpath("//input[@placeholder='571-000-0000']"));
        phoneNumberBox.sendKeys("123-456-7890");


        // 9. Click to "Male" from Gender
         WebElement maleButton=driver.findElement(By.xpath("//input[@value='male']"));
         maleButton.click();


         // 10. Enter Date of birth "01/28/1990"
        WebElement birthDayBox=driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        birthDayBox.sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select departmentDropDown=new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departmentDropDown.selectByValue("DE");

        // 12. Select "SDET" from Job title dropdown
        Select jobTitleDropDown=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropDown.selectByVisibleText("SDET");

        // 13. Click to "Java" from languages
        WebElement programmingLanguage=driver.findElement(By.xpath("//input[@value='java']"));
        programmingLanguage.click();

        // 14. Click to "Sign up" button
        WebElement signUpButton=driver.findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();


        // 15. Verify text displayed on page
        //Expected: "Well done
        WebElement wellDoneText=driver.findElement(By.cssSelector("h4.alert-heading"));
        System.out.println("wellDoneText.isDisplayed() = " + wellDoneText.isDisplayed());




        driver.close();

    }



}



















