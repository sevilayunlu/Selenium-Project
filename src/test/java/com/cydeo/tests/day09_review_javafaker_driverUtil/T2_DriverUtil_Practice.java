package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_DriverUtil_Practice {

  /*  WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }*/
    /*  //3- Write “apple” in search box
        WebElement searchBox=driver.findElement(By.xpath(("//textarea[@name='q']")));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String actualTitle= driver.getTitle();
        String expectedTitle= ConfigurationReader.getProperty("searchValue")+" - Search";

        Assert.assertEquals(actualTitle,expectedTitle);*/

    @Test
    public void bing_search_test() throws InterruptedException {



        //2- Go to: https://bing.com
        //Driver.getDriver() will return me the "driver"
        //Instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));//if we enter wrong key, it will throw NullPointerException

        //3- Write “apple” in search box
        //locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@name='q']"));
        Thread.sleep(2000);

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);


        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        String actualTitle = Driver.getDriver().getTitle();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    @Test
    public void bing_search_test2() throws InterruptedException {

        //2- Go to: https://bing.com
        //Driver.getDriver() will return me the "driver"
        //Instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));//if we enter wrong key, it will throw NullPointerException

        //3- Write “apple” in search box
        //locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        Thread.sleep(2000);

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);


        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        String actualTitle = Driver.getDriver().getTitle();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }


    @AfterMethod
    public void tearDownMethod() {

        /*
        We won't be using the selenium's quit method directly anymore
        Driver.getDriver().quit();
         */


        Driver.closeDriver();
    }


}
