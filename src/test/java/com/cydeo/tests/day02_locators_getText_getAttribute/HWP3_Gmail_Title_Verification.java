package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Gmail_Title_Verification {

    public static void main(String[] args) throws InterruptedException {
        //TC #3: Back and forth navigation
        //1- Open a Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //skip cookies
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();
        WebElement search = driver.findElement(By.name("q"));
        Thread.sleep(3000);


        //3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)) {
            System.out.println("Gmail title verification is PASSED!");
        } else {
            System.out.println("Gmail title verification is FAILED!");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();
        Thread.sleep(2000);

        //6- Verify title equals:
        //Expected: Google
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification is PASSED!");
        }else{
            System.out.println("Google title verification is FAILED!");
        }
        driver.close();

    }
}






