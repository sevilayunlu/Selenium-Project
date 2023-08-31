package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class T2_Upload_Practice {

    //TC #2 Upload Test
    //1. Go to https://practice.cydeo.com/upload
    //2. Find some small file from your computer, and get the path of it.

    @Test
    public void uploading_test(){
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        String path="/Users/etr/Desktop/file.txt";

        //3. Upload the file.
        WebElement chooseFileButton=Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(path);

        Driver.getDriver().findElement(By.id("file-submit")).click();

        WebElement fileUploadedHeader=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(),"Header text is not displayed");





        
    }



}


//4. Assert:
//-File uploaded text is displayed on the page