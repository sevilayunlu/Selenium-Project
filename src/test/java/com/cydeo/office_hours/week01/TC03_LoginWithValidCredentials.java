package com.cydeo.office_hours.week01;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC03_LoginWithValidCredentials {
    public static void main(String[] args) throws InterruptedException {

        //TC003 As a user I should be able to login with valid credentials
        // 1- Setup the "browser driver"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com/");

        // 3- Click Login label
        WebElement loginButton = driver.findElement(By.xpath("//a[.='LOGIN']"));
        loginButton.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBox.sendKeys("User1");

        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");

        //Click to the Login button
        WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        Thread.sleep(2000);

        if(driver.getTitle().contains("Dashboard")) {
            System.out.println("Title verification is passed!");
        }else{
            System.out.println("Title verification is failed!");
        }





    }



}


// 5- Verify the title contains "Dashboard"