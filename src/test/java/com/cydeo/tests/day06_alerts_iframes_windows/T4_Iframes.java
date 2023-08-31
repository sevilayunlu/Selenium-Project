package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_Iframes {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2. Go to website:https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void iframe_test(){

        //2. Create new test and make set ups
        //4. Assert: “Your content goes here.” Text is displayed.

        //we have to switch to iframe to be able to locate the web elements in there
        //option#1- switch "id" or name attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option#2- switch index
        //driver.switchTo().frame(0);

        //option#3- switch using WebElement
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        driver.switchTo().frame("mce_0_ifr");
        WebElement content=driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(content.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
        WebElement headerText=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed());





    }





}


//3. Go to: https://practice.cydeo.com/iframe
//TC #4: Iframe practice
//1. Create a new class called: T4_Iframes
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”