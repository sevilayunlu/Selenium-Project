package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations_GetMethods {
    public static void main(String[] args) {
        // TC#1: Navigations and Get methods Practice
        // 1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();//setting up driver browser with WebDriver manager was used in Selenium 3 version
        //Selenium 4 version does not need any more
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to: https://www.etsy.com/
        driver.get("https://www.etsy.com/");

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 4. Navigate back, forward and refresh
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        // 6. Press search button to search
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

        // 7. Verify title is "Amazon.com : selenium"
        String expectedTitle = "Amazon.com : selenium";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is passed!");
        } else {
            System.out.println("Title verification is failed!");
        }

        // 8. Verify url contains "selenium"
        String expectedURL = "selenium";
        String actualInURL = driver.getCurrentUrl();

        if (actualInURL.contains(expectedURL)) {
            System.out.println("URL verification is passed!");
        } else {
            System.out.println("URL verification is passed!");
        }


        //it will close only the currently opened page
        //if you have more than one 1 tab , it will only close currently open tab
        //you can still use the driver instance in other tabs
        //driver.close();


        //if you have multiple windows are opened, it will close everything
        //it will kill driver session and the driver instance will be no longer usable
        driver.quit();

    }
}








