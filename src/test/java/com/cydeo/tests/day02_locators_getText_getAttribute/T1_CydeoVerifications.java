package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");
        /*String currentUrL=driver.getCurrentUrl();
        boolean answerURL=currentUrL.contains("cydeo");
        System.out.println(answerURL);

        String title= driver.getTitle();
        boolean answerTitle=title.equals("Practice");
        System.out.println(answerTitle);*/
        String expectedinURL = "cydeo";
        String actualinURL = driver.getCurrentUrl();

        if (actualinURL.contains(expectedinURL)) {
            System.out.println("URL verification is PASSED!");
        } else {
            System.out.println("URL verification is FAILED!");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAILED!");
        }

        //close the driver
        driver.close();

    }
}
/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
Expected: Practice

 */