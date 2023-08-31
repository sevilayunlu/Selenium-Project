package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.management.MBeanAttributeInfo;

public class HWP2_Zerobank_XPATH_CSS {
    public static void main(String[] args) throws InterruptedException {
        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”

        //solution with xpath locator
        //WebElement header = driver.findElement(By.xpath("//h3"));
        //syntax cssSelector= tagName[attribute='value']
        WebElement header = driver.findElement(By.cssSelector("h3"));//although we do not have any attribute or value, because our page is small
        //just with the tag name we could be able to locate the web element


        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = header.getText();

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header verification is passed!");
        } else {
            System.out.println("Header verification is passed!");
        }
        Thread.sleep(3000);
        driver.close();
    }
}


