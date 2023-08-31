package com.cydeo.office_hours.week01;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC01_LoginLabel {

    public static void main(String[] args) {

        //TC001 As a user I should be able to see Login label is displayed
        //  1-open a Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3-verify Login is displayed
        WebElement loginButton=driver.findElement(By.xpath("//a[.='LOGIN']"));
        System.out.println("loginButton.isDisplayed() = " + loginButton.isDisplayed());

        driver.quit();


    }





}


