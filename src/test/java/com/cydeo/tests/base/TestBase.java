package com.cydeo.tests.base;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
// This class is the parent of all Test classes
// You will update this class based on what you are keep writing in your most test classes
// instead writing in all test classes, you can just write in this class
// and you can extend this class from any class
// This class is abstract because we don't want to create any object with using this class




public abstract class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        // 1. Open Chrome browser
        //Driver class will handle driver setting up line of codes

        driver=WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
        //Driver.closeDriver();
        //Taking screenshot codes here to get screenshot of failing Test after they are done
    }

}
