package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Google_XPATH_CSS {

    public static void main(String[] args) throws InterruptedException {
        //TC #3: Back and forth navigation
        //1- Open a Chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //skip cookies
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();
        WebElement search = driver.findElement(By.name("q"));
        Thread.sleep(3000);


        //3- Click to Gmail from top right.
        //WebElement gmailLink = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/&ogbl']"));


        //Using the text of the web element with xpath locator
        //tagName[text()='textValue']--> //tagName[.='textValue']
        //WebElement gmailLink = driver.findElement(By.xpath("//a[.='https://mail.google.com/mail/&ogbl']"));
        //WebElement gmailLink = driver.findElement(By.xpath("//a[text()='Gmail']"));

        //Locating the Gmail link using "cssSelector" locator
        WebElement gmailLink = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));
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
