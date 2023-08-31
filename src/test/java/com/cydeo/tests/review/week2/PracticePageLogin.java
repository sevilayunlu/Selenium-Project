package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PracticePageLogin {

    public static void main(String[] args) {

        // TC#2: Practice page Login test
        // 1. Open Chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement usernameBox=driver.findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys("tomsmith");


        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordBox=driver.findElement(By.cssSelector("input[type='password']"));
        passwordBox.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // 6. Verify text displayed on page
        // Expected: "You logged into a secure area!"
        WebElement resultText1 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
        String verifyText=resultText1.getText();
        String expectedText="You logged into a secure area!";
        if(verifyText.contains(expectedText)){
            System.out.println("Test is passed!");
        }else{
            System.out.println("Test is failed!");
        }

        driver.close();

    }
}







