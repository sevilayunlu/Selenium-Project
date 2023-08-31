package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {


    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        //2- Go to: https://bing.com
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigurationReader.getProperty("bingURL"));//if we enter wrong key, it will throw NullPointerException

    }





      /*  //3- Write “apple” in search box
        WebElement searchBox=driver.findElement(By.xpath(("//textarea[@name='q']")));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String actualTitle= driver.getTitle();
        String expectedTitle= ConfigurationReader.getProperty("searchValue")+" - Search";

        Assert.assertEquals(actualTitle,expectedTitle);*/

        @Test
        public void bing_search_test () throws InterruptedException {

            //3- Write “apple” in search box

            //locate the search box
            WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
            Thread.sleep(2000);

            searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);


            //4- Verify title:
            //Expected: apple - Search
            //Expected: flowers - Search
            String actualTitle = driver.getTitle();

            //String expectedTitle = "apple - Search";
            //We are just making the expectedTitle dynamic based on the text we are searching.
            String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";

            Assert.assertTrue(actualTitle.equals(expectedTitle));

        }














}
//TC #1: Bing search



//Use `configuration.properties` for the following:
//1. The browser type
//2. The URL
//3. The search keyword
//4. Make title verification dynamic. If search value changes, title
//assertion should not fail.