package com.cydeo.office_hours.week3;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Iframe_Windowhandles_Practice {






    @Test
    public void iframe_windowHandle_test() {
        //Task 1:  Iframe-window handles
        //Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
        //Test Scenario:
        //Step 1- Go to the above URL.
        Driver.getDriver().get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        Driver.getDriver().findElement(By.cssSelector("#accept-choices")).click();
        //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
        String mainWindowHandle = Driver.getDriver().getWindowHandle();

        //Step 3- Locate the “Visit W3Schools.com!” link and click it.
        //Driver.getDriver().switchTo().frame(2);
        Driver.getDriver().switchTo().frame("iframeResult");
        //Driver.getDriver().switchTo().frame(//iframe[@id='iframeResult']);

        WebElement visitLink = Driver.getDriver().findElement(By.linkText("Visit W3Schools.com!"));
        visitLink.click();

        //Step 4- Get all window handles and hold them in a list.
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        //Step 5- Write to total window handle number to the console. It must be 2.
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        //Step 6- Switch to the second window.
        for (String eachWindow : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindow);
            
        }

        //Step 7- Get the current window’s handle and write to the console window. It must be a second window
        String currentWindowHandle=Driver.getDriver().getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);

        //Step 8- Check the upper left side logo in the second window.
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[@title='Home']/i")).isDisplayed());

        //Step 9- Go back (Switch) to the first window.
        //Step 10- Get the current window’s handle and write to the console window. It must be the first window handle.
        Driver.getDriver().switchTo().window(mainWindowHandle);
        System.out.println("mainWindowHandle = " + mainWindowHandle);

        //Step 11- Check the See Run Button Text. It must contain “Run >” text.
        WebElement runButton=Driver.getDriver().findElement(By.xpath("//button[@id='runbtn']"));
        Assert.assertEquals(runButton.getText(),"Run ❯" );



    }


}
