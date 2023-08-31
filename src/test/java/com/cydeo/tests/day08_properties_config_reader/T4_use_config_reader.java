package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_use_config_reader {

    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #4: Google search
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL"));

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void google_search_test() throws InterruptedException {

        //3- Write “apple” in search box
        //4- Verify title:
        //Expected: apple - Google Search

        //skip cookies
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(3000);
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Google'da Ara";
        BrowserUtils.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }
}



