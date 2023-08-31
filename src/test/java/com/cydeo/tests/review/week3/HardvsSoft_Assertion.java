package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardvsSoft_Assertion {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        // 1. Open Chrome browser

        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

    }

    @Test
    public void login_test_with_hard_assertion(){

// 3. Enter username: "tomsmith"
        WebElement usernameBox=driver.findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys("tomsmith");


        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordBox=driver.findElement(By.cssSelector("input[type='password']"));
        passwordBox.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Assert.assertTrue(driver.getTitle().equals("Secure Area"));

        // 6. Verify text displayed on page
        // Expected: "You logged into a secure area!"
        WebElement resultText1 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
        String verifyText=resultText1.getText();
        String expectedText="You logged into a secure area!";

        Assert.assertTrue(verifyText.contains(expectedText));

    }

    @Test
    public void login_test_with_soft_assertion(){
// 3. Enter username: "tomsmith"
        WebElement usernameBox=driver.findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys("tomsmith");


        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordBox=driver.findElement(By.cssSelector("input[type='password']"));
        passwordBox.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(driver.getTitle().equals("Secure Ara"));

        WebElement resultText1 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
        String verifyText=resultText1.getText();
        String expectedText="You logged into a secure area!";

        softAssert.assertTrue(verifyText.contains(expectedText));






    }


















}

// 3. Enter username: "tomsmith"
// 4. Enter password: "SuperSecretPassword"
// 5. Click to Log in button
// 6. Verify text displayed on page
//    Expected: "You logged into a secure area!"