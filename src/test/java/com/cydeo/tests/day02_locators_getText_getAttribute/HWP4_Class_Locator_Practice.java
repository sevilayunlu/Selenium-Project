package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_Class_Locator_Practice {
    public static void main(String[] args) throws InterruptedException {

        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
       // WebElement homelink=driver.findElement(By.linkText("Home"));-- gives the same result
        WebElement homeLink=driver.findElement(By.className("nav-link"));
        Thread.sleep(2000);


        //4- Verify title is as expected:
        //Expected: Practice
        homeLink.click();
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Home title verification is PASSED!");
        }else{
            System.out.println("Home title verification is FAILED!");
        }

        driver.close();















    }
}



//PS: Locate “Home” link using “className” locator