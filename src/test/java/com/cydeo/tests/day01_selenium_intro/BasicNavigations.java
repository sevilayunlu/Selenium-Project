package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.InvalidAttributeValueException;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //Setup browser driver
        WebDriverManager.chromedriver().setup();

        //Create instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        //this line will maximize the currently opened browser
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();==for mac



        //Go to tesla.com
        driver.get("https://www.tesla.com");//https shows what protocol we are trying to reach


        //Use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        //Use navigate back() to go back
        driver.navigate().back();


        //Stop execution for 3 seconds
        Thread.sleep(3000);


        //User navigate forward to go forward
        driver.navigate().forward();

        //Stop execution for 3 seconds
        Thread.sleep(3000);

        //User refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        //Stop execution for 3 seconds
        Thread.sleep(3000);


        //navigate to google.com by using navigate().to();
        driver.navigate().to("https://www.google.com");

        //Use .getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //get title of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());


        //closes only the currently focused window/tab
        //driver.close();

        //closes all-of-the opened browsers
        driver.quit();//the session will be terminated:


    }
}
