package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void login_crm(WebDriver driver){

        /*
        this method will log in using below credentials:
        UserName: hr1@cybertekschool.com
        PassWord: UserUser
        */

        //2. Go to: http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr1@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
    }

    public static void login_crm(WebDriver driver, String username, String password){

        /*
        this method will log in using below credentials:
        UserName: hr1@cybertekschool.com
        PassWord: UserUser
        */

        //2. Go to: http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
    }








}
//TC #5: Create utility method
//1. Create a new method for login
//2. Create a method to make Task3 logic re-usable
//3. When method is called, it should simply login
//This method should have at least 2 overloaded versions.
//Method #1 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//Method #2 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String username
//• Arg3: String password