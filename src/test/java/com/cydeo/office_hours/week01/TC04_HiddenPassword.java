package com.cydeo.office_hours.week01;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC04_HiddenPassword {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC004 As a user I should be able to see the password hidden as default
        // 1- Set up the "browser driver"
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com/");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void hiddenPassword() {
        //3- Click Login label
        WebElement loginButton = driver.findElement(By.xpath("//a[.='LOGIN']"));
        loginButton.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        WebElement usernameBox = driver.findElement(By.cssSelector("input.span2"));
        usernameBox.sendKeys("User1");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys("UserUser123");

        // 5- Verify the password is hidden


    }






}



