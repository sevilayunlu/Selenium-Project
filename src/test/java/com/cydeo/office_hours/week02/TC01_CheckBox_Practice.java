package com.cydeo.office_hours.week02;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_CheckBox_Practice {


@Test
    public void checkbox_text(){
    //  2-go to https://practice.cydeo.com/
    Driver.getDriver().get("https://practice.cydeo.com/");

    //  3-click Checkboxes
   // Driver.getDriver().findElement(By.linkText("Checkboxes")).click();
    BrowserUtils.clickOption(Driver.getDriver(), "Checkboxes");

    //  4-verify title equals Checkboxes
    WebElement title=Driver.getDriver().findElement(By.xpath("//h3[.='Checkboxes']"));
    Assert.assertTrue(Driver.getDriver().getTitle().equals("Checkboxes"));

    //  5-click Checkbox 1
    WebElement checkBox1=Driver.getDriver().findElement(By.id("box1"));
    checkBox1.click();
    BrowserUtils.sleep(2);

    //  6-verify the Checkbox 1 is checked
    Assert.assertTrue(checkBox1.isSelected());

    //  7-click Checkbox 2
    WebElement checkBox2=Driver.getDriver().findElement(By.id("box2"));
    checkBox2.click();

    //8-Verify the CheckBox 2 is not selected
    Assert.assertTrue(!checkBox2.isSelected());











}




}








