package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    @Test
    public void hovering_test(){
        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //Locate all images
        WebElement firstImg=Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement secondImg=Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement thirdImg=Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all user headers
        WebElement user1=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        //To be able to hover on images, we nee to create Actions class object,
        //and pass 'driver' in the constructor

        //2. Hover over to first image
        Actions hovering=new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        hovering.moveToElement(firstImg).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());

        //4. Hover over to second image
        BrowserUtils.sleep(2);
        hovering.moveToElement(secondImg).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());

        //6. Hover over to third image
        BrowserUtils.sleep(2);
        hovering.moveToElement(thirdImg).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());

        Driver.closeDriver();


    }


}






